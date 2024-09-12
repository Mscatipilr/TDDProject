# TddProjectApplication

## Overview

`TddProjectApplication` is a Spring Boot application that demonstrates how to manage orders using basic CRUD operations (Create, Read, Update, Delete). The project uses Spring Boot, Spring Data JPA, and an embedded database to persist and manage orders.

## Features

- Create new orders
- Retrieve existing orders by ID
- Update existing orders
- Delete orders
- Automatically creates an initial order when the application starts

## Requirements

To run this application, you need the following installed on your machine:

- **Java 17 or higher**
- **Maven** (for building the application) or **Gradle** (if you're using Gradle as a build tool)

## Running the Application

### Option 1: Running the Application in an IDE

1. **Clone the repository** or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Build the project using the Maven or Gradle build tool.
4. Run the application:
    - Navigate to the `TddProjectApplication.java` file located at `src/main/java/org/joann/tddproject/`.
    - Right-click the file and select "Run".

The application will start on the default port (`8080`).

### Option 2: Running the Application as an Executable JAR

1. **Build the JAR file**:

   If you're using **Maven**, run the following command in the terminal from the project root:

   ```bash
   mvn clean package
