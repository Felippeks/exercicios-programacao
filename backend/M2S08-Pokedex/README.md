# Pokedex Health API

## Overview
This project is a Spring Boot application designed to manage a Pokedex, allowing users to view, add, update, and delete Pokémon entries. It supports operations for marking Pokémon as seen or captured and provides detailed information about each Pokémon.

## Technologies
- Java
- Spring Boot
- Maven
- JPA (Java Persistence API)
- H2 Database (for demonstration purposes, can be replaced with any SQL database)

## Features
- **List Pokémon**: Retrieve a list of all Pokémon entries, including their basic details.
- **Add Pokémon**: Mark a Pokémon as seen or captured, including details such as name, type, description, and more.
- **Update Pokémon**: Update details of a specific Pokémon entry.
- **Delete Pokémon**: Remove a Pokémon entry from the Pokedex.
- **View Pokémon**: Get detailed information about a specific Pokémon by its unique number.

## Setup and Installation
1. **Clone the repository**
https://github.com/Felippeks/M2S08-Pokedex.git
2. **Navigate to the project directory**
3. **Build the project using Maven**
mvn clean install
4. **Run the application**
mvn spring-boot:run

## API Endpoints

### Pokémon Management
- **POST** `/pokemon/visto` - Register a Pokémon as seen.
- **POST** `/pokemon/capturado` - Register a Pokémon as captured.
- **PUT** `/pokemon/{numero}` - Update a Pokémon's details.
- **DELETE** `/pokemon/{numero}` - Delete a Pokémon from the Pokedex.
- **GET** `/pokemon/{numero}` - Retrieve details of a specific Pokémon.
- **GET** `/pokemon/listar` - List all Pokémon entries.

## Exception Handling
Custom exception handling is implemented to provide clear and user-friendly error messages, especially for validation errors and missing fields.

## Contributing
Contributions are welcome! Please feel free to submit pull requests or open issues to suggest improvements or add new features.
