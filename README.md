# Practicum Blog

This project is a web application for a blog developed using Java with the Spring framework. It uses Maven for project management and builds as a .war package for deployment.

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Testing](#testing)
- [License](#license)

## Project Overview

The Practicum Blog is designed to showcase various features of a modern web application built using the Spring framework and related technologies. It uses H2 as an in-memory database for development and testing purposes.

## Features

- MVC pattern implementation with Spring Web MVC
- Frontend developed with Thymeleaf
- Data handling with Spring Data JDBC
- In-memory database with H2
- Lightweight and easy to deploy as a .war package

## Technologies Used

- **Java 21**
- **Spring Web MVC 6.2.1**
- **Jakarta Servlet API 6.1.0**
- **H2 Database 2.2.224**
- **Spring Data JDBC 3.4.1**
- **Spring Boot Starter Thymeleaf 3.4.1**
- **Lombok 1.18.36**
- **MapStruct 1.6.3**
- **JUnit 5.9.3**

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd blog
2. **Build the project using Maven:**

    ```bash
    mvn clean install
3. **Deploy the .war file:**

The output .war file will be located in target/practicum-blog.war, which can be deployed to any servlet container like Tomcat.

## Usage
Ensure your servlet container (e.g., Apache Tomcat) is running and deploy the generated practicum-blog.war to it. Once deployed, you can access the application via the respective local server path (e.g., http://localhost:8080).

## Testing
The project uses JUnit and Spring Test for unit and integration testing. To run the tests, simply execute:

    ```bash
    mvn test

## License
This project is under the MIT License : LICENSE.

