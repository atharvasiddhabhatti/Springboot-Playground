# Spring Boot [Rest API] - SQL Database using Docker

CRUD Operations using Spring Boot and MYSQL Database using docker-compose.

Docker is required to be install on the machine.

## Installation
1) Clone the Repo & run the following commands.

```bash
docker-compose up
```

## Output

Open in Browser

Access all the endpoints using Swagger UI.

```
http://localhost:8084/swagger-ui.html
```
Access phpMyAdmin.

```
http://localhost:8082/
```

## Usage
[Check Spring Boot H2 Repo](https://github.com/atharvasiddhabhatti/Springboot-Playground/tree/main/springboot-demo-h2)
## Configuration

### application.properties

```c
spring.jpa.show-sql = true
server.port=8084
spring.application.name=property-service

# MYSQL Config
spring.jpa.hibernate.ddl-auto=create-drop
spring.datasource.url=jdbc:mysql://mysql-db:3306/property?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=spring
spring.datasource.driver-class-name =com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.datasource.initialization-mode=never
```

### docker-compose.yml

```c
version: '3.3'

services:
    #service 1: definition of mysql database
    db:
      image: mysql:latest
      container_name: mysql-db  
      environment:
        - MYSQL_ROOT_PASSWORD=spring
      ports:
        - "3306:3306"
      restart: always
      
    #service 2: definition of phpMyAdmin
    phpmyadmin:
      image: phpmyadmin/phpmyadmin:latest
      container_name: my-php-myadmin
      ports:
        - "8082:80"
      restart: always
        
      depends_on:
        - db
      environment:
        SPRING_DATASOURCE_USERNAME: root
        SPRING_DATASOURCE_PASSWORD: spring
      
    
    
    #service 3: definition of your spring-boot app 
    customerservice:                        #it is just a name, which will be used only in this file.
      image: property-service               #name of the image after dockerfile executes
      container_name: property-service-app  #name of the container created from docker image
      build:
        context: .                          #docker file path (. means root directory)
        dockerfile: Dockerfile              #docker file name
      ports:
        - "8084:8084"                       #docker containter port with your os port
      restart: always
        
      depends_on:                           #define dependencies of this app
        - db                                #dependency name (which is defined with this name 'db' in this file earlier)
      environment:
        SPRING_DATASOURCE_URL: jdbc:mysql://mysql-db:3306/property?createDatabaseIfNotExist=true
        SPRING_DATASOURCE_USERNAME: root
        SPRING_DATASOURCE_PASSWORD: spring
```
### Dockerfile
```c
FROM openjdk:11 as mysqldoc
EXPOSE 8084
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Copy the project source
COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN chmod 755 /app/mvnw

RUN ./mvnw dependency:go-offline -B

RUN ./mvnw package -DskipTests
RUN ls -al
ENTRYPOINT ["java","-jar","target/springboot-demo-mysql-0.0.1-SNAPSHOT.jar"]
```
