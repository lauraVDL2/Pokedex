# Pokedex
This project is a Pokedex which is not using PokeApi ; I wrote my own APIs here.
Backend is using Spring Boot (with MongoDB database), frontend is using Angular.

# Install
1. Clone the repository
2. If not done, install [docker and docker compose](https://docs.docker.com/compose/install/)
3. Go to the root of the repository and run from your terminal <strong>./lifecycle.sh build</strong>
4. Wait for the script to run, it will automatically create a few Pokemon and start your environment
5. Go to http://localhost:4200
6. Once you are done, you can run <strong>./lifecycle.sh purge</strong>

# Overview
![Alt Text](https://zupimages.net/up/25/33/9y40.png)
![Alt Text](https://zupimages.net/up/25/33/agoi.png)
![Alt Text](https://zupimages.net/up/25/33/rqfj.png)

# What about the APIs ?
I'm using [Bruno](https://www.usebruno.com/) to test my APIs. You can download the file PokedexApis.json and import it through Bruno.
You will be able to create, delete, modify, search and get your entities.
