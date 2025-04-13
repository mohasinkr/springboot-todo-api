# 📝 ToDo Application (Spring Boot + PostgreSQL)

A full-featured backend ToDo application built using **Spring Boot** and **PostgreSQL**. This project demonstrates clean architecture principles, layered separation (Controller → Service → Repository → Entity), and usage of key Spring concepts.

---

## 🧰 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Lombok

---

## 🚀 Features

- Create, Read, Update, and Delete (CRUD) ToDos
- PostgreSQL database integration via JPA
- Docker setup for database
- RESTful API design
- Exception handling using `ResponseEntity`
- Secure environment configuration
- Usage of `@Entity`, `@Repository`, `@Service`, and `@RestController`
- Auto-wiring and Dependency Injection

---

## 📁 Project Structure

```text
src/
└── main/
    ├── java/com/mkr/todo/
    │   ├── controller/        # REST controllers
    │   ├── service/           # Business logic
    │   ├── repository/        # JPA repositories
    │   ├── model/             # Entities
    │   └── TodoApplication.java
    └── resources/
        └── application.properties
