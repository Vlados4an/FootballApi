# Football Application

Football Application is a RESTful API built with Spring Boot for managing football teams and players. It provides a comprehensive platform for performing CRUD operations on various football-related entities such as Teams, Players, and Player Statistics.

## Features

- **Manage Football Teams**: Perform Create, Read, Update, Delete operations on Football Teams.
- **Manage Football Players**: Perform Create, Read, Update, Delete operations on Football Players.
- **Manage Player Statistics**: Perform Create, Read, Update operations on Player Statistics.
- **Retrieve Player Statistics**: Retrieve player statistics by player name.
- **Retrieve All Players in a Team**: Retrieve all players belonging to a specific team.

## Technologies Used

- Java
- Spring Boot
- Maven
- PostgreSQL
- Lombok
- MapStruct
- Hibernate

## Setup

1. Clone the repository.
2. Install PostgreSQL and create a database named `Football`.
3. Update `src/main/resources/application.properties` with your PostgreSQL username and password.
4. Run the application using the command `mvn spring-boot:run`.

## API Endpoints

- `/teams`: GET all teams, POST a new team.
- `/teams/{id}`: GET, UPDATE, DELETE a team by id.
- `/players`: GET all players, POST a new player.
- `/players/{name}`: GET a player by name.
- `/players/{name}/statistics`: GET player statistics by player name.
- `/players/{id}`: UPDATE, DELETE a player by id.
- `/statistics`: GET all statistics, POST a new statistic.
- `/statistics/{id}`: UPDATE a statistic by id.

## Project Structure

The project follows a typical Spring Boot project structure. Here are some of the key directories and files:

- `src/main/java/ru/erma/footballapplication`: Contains the main application classes.
- `src/main/java/ru/erma/footballapplication/controller`: Contains the controller classes.
- `src/main/java/ru/erma/footballapplication/service`: Contains the service classes.
- `src/main/java/ru/erma/footballapplication/repository`: Contains the repository interfaces.
- `src/main/java/ru/erma/footballapplication/model`: Contains the entity classes.
- `src/main/java/ru/erma/footballapplication/dto`: Contains the data transfer object (DTO) classes.
- `src/main/java/ru/erma/footballapplication/mapper`: Contains the mapper interfaces.
- `src/main/java/ru/erma/footballapplication/util`: Contains utility classes for exception handling.
- `src/main/resources/application.properties`: Contains the application configuration properties.
- `pom.xml`: Contains the project's Maven configuration.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Contact me:

- ssvetlaa235@gmail.com
- telegram: @evlad03
