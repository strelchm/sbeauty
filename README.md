# sbrackets
Task 4 SB challenge: Text operations API with brackets check endpoint.

**Features:**
- [x] All [task requirements](TASK.md) are done

**Technologies:**
- Java 17
- Gradle
- Docker
- Spring Boot
- Spring Validation
- Project Lombok
- Mapstruct
- OpenAPI (Springdoc)
- JUnit 5

**App starting**

Run the next command from root directory to build and start program: 
**1)** with Gradle:
```
sudo gradlew clean build bootRun
```

**2)** with Docker:
```
sudo docker-compose up
```

**App using and documentation**
* In both starting cases an app will be started on `8080 port`
* Try to test API and read docs through Open API Swagger UI: `http://localhost:8080/swagger-ui/index.html`
