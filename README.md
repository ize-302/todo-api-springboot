# Todo App

A simple RESTful Todo API built with Spring Boot, JPA, and H2.

## Tech Stack

- **Java 25**
- **Spring Boot 3.5.0** (Web, Data JPA, DevTools)
- **H2** — file-based in-memory database
- **Lombok** — boilerplate reduction
- **Springdoc OpenAPI 2.8.5** — Swagger UI

## Getting Started

### Prerequisites

- JDK 25+
- Maven (or use the included `./mvnw` wrapper)

### Run

```bash
./mvnw spring-boot:run
```

The application starts on `http://localhost:8080`.

### Build

```bash
./mvnw clean package
java -jar target/todo-0.0.1-SNAPSHOT.jar
```

## API Endpoints

Base path: `/api/todos`

| Method | Path            | Description        |
|--------|-----------------|--------------------|
| POST   | `/api/todos`    | Create a todo      |
| GET    | `/api/todos`    | List all todos     |
| GET    | `/api/todos/{id}` | Get a todo by ID |
| PATCH  | `/api/todos/{id}` | Update a todo    |
| DELETE | `/api/todos/{id}` | Delete a todo    |

### Request / Response Shapes

**Create / Update** (`POST`, `PATCH`)

```json
{
  "title": "Buy groceries",
  "note": "Milk, eggs, bread"
}
```

- `title` — required, non-blank string (max 100 chars)
- `note` — optional string (max 255 chars)

**Response**

```json
{
  "id": 1,
  "title": "Buy groceries",
  "note": "Milk, eggs, bread"
}
```

## Interactive Docs

| Tool        | URL                                    |
|-------------|----------------------------------------|
| Swagger UI  | http://localhost:8080/swagger-ui.html  |
| OpenAPI JSON | http://localhost:8080/api-docs        |
| H2 Console  | http://localhost:8080/h2-console       |

**H2 Console credentials**

| Field    | Value                  |
|----------|------------------------|
| JDBC URL | `jdbc:h2:file:./testdb` |
| Username | `sa`                   |
| Password | `password`             |

## Project Structure

```
src/main/java/com/example/todo/
├── Main.java                  # Application entry point
├── config/
│   └── SwaggerConfig.java     # OpenAPI configuration
├── controller/
│   └── TodoController.java    # REST endpoints
├── dto/
│   ├── CreateTodoDto.java     # Create request body
│   ├── UpdateTodoDto.java     # Update request body
│   └── TodoResponseDto.java   # Response shape
├── entity/
│   └── Todo.java              # JPA entity
├── repository/
│   └── TodoRepository.java    # Spring Data repository
└── service/
    ├── TodoService.java        # Service interface
    └── TodoServiceImpl.java    # Service implementation
```

## Database

The app uses an H2 file-based database (`./testdb`). The schema is initialised from `src/main/resources/schema.sql`:

```sql
CREATE TABLE IF NOT EXISTS TODO (
  ID    INT          NOT NULL AUTO_INCREMENT,
  TITLE VARCHAR(100) NOT NULL,
  NOTE  VARCHAR(255),
  PRIMARY KEY (ID)
);
```

`spring.jpa.hibernate.ddl-auto` is set to `create-only`, so the schema is created on startup if it does not already exist.
