#!/bin/bash

DB_NAME="pokedex"
JSON_FILE="pokemon_to_create.json"

function build() {
  docker compose up -d --build
  create_pokemon
}

function rebuild() {
  docker compose stop
  docker compose up -d --build
}

function create_indexes() {
  docker exec -it mongodb mongosh "$DB_NAME" --eval 'db.pokemon.createIndex({ entryNumber: 1 }, { unique: true })'
}

function create_pokemon() {
  docker cp $JSON_FILE mongodb:/tmp/pokemon_to_create.json
  docker exec -it mongodb mongoimport -d "$DB_NAME" --collection "pokemon" --file "/tmp/pokemon_to_create.json" --jsonArray
  create_indexes
}

function purge() {
  docker exec -it mongodb mongosh "$DB_NAME" --eval 'db.pokemon.drop()'
  docker system prune -a --volumes
}

if [ "$1" = "build" ]; then
  build
elif [ "$1" = "rebuild" ]; then
  rebuild
elif [ "$1" = "purge" ]; then
  purge
fi