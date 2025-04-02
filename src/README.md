# Franchise Management API
This API allows to manage franchises, branches and products. Developed with Spring Boot, MySQL and Gradle.

## Project Structure

```
franchise-api/
├── src/
│   ├── main/
│   │   ├── java/com/accenture/franchise_api/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── FranchiseApiApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .gitignore
├── build.gradle
└── README.md
```

## Requisitos Previos

- Java 17
- Gradle 8+
- MySQL 8.0+
- Git

## Ejecución Local

1. Clonar el repositorio:
    ```bash
   git clone https://github.com/EstebanEscobar99/franchise-api.git
   cd franchise-api
    ```
2. Configurar la base de datos MySQL:

   - Asegúrate de tener MySQL corriendo en el puerto 3306
   - Crea una base de datos llamada `franchise_db` (la aplicación puede crearla automáticamente si tiene permisos)
   - Verifica las credenciales en `src/main/resources/application.properties`

3. Ejecutar la aplicación:
   ```bash
   ./gradlew bootRun
   ```

4. La API estará disponible en: http://localhost:8080
    - Documentación Swagger: http://localhost:8080/swagger-ui.html