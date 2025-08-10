#!/bin/bash

DB_NAME="pokedex"
JSON_FILE_POKEMON="pokemon_to_create.json"
JSON_FILE_MOVES="moves_to_create.json"

function build() {
  docker compose up -d --build
  create_pokemon
}

function rebuild() {
  docker compose stop
  docker compose up -d --build
}

function create_indexes() {
  docker exec -it mongodb mongosh "$DB_NAME" --eval 'db.Pokemon.createIndex({ entryNumber: 1 }, { unique: true })'
  docker exec -it mongodb mongosh "$DB_NAME" --eval 'db.Move.createIndex({ name: 1 }, { unique: true })'
}

function create_pokemon() {
  docker cp $JSON_FILE_POKEMON mongodb:/tmp/pokemon_to_create.json
  docker cp $JSON_FILE_MOVES mongodb:/tmp/moves_to_create.json
  docker exec -it mongodb mongoimport -d "$DB_NAME" --collection "Pokemon" --file "/tmp/pokemon_to_create.json" --jsonArray
  docker exec -it mongodb mongoimport -d "$DB_NAME" --collection "Move" --file "/tmp/moves_to_create.json" --jsonArray
  create_indexes
}

function generate_files() {
  cd backend/
  mvn clean install
  cd ..
  cd frontend/
  ng-openapi-gen --input ../backend/src/main/resources/PokedexApi.yaml --output ./src/apiModels/
}

function purge() {
  docker exec -it mongodb mongosh "$DB_NAME" --eval 'db.Pokemon.drop()'
  docker system prune -a --volumes
  docker stop '$(docker ps -q)'
  docker rm '$(docker ps -a -q)'
}

if [ "$1" = "build" ]; then
  build
elif [ "$1" = "rebuild" ]; then
  rebuild
elif [ "$1" = "purge" ]; then
  purge
elif [ "$1" = "generate" ]; then
  generate_files
fi
