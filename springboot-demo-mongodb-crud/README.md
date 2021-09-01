# Spring Boot CRUD - Mongo DB + Docker

CRUD Operations using Spring Boot and MYSQL Database using docker-compose.

Docker is required to be install on the machine.

## Installation
1) Clone the Repo & run the following commands.

```bash
docker-compose up
```

## Output

| Endpoint | Method | Body | Description |
|:---:|:---:|:---:|:---:|
| http://localhost:8080/products | GET | - | Fetch all products |
| http://localhost:8080/products/{id} | GET | - | Find Product by Id |
| http://localhost:8080/products | POST | { "id":"1", "name":"Mobile", "Description":"Samsung Mobile." } | To Add product to the DB |
| http://localhost:8080/products | PUT | { "id":"1", "name":"Apple Iphone", "Description":"Apple" } | To update existing record. |
| http://localhost:8080/products/{id} | DELETE | - | Delete the record be Id |

## Usage
### ProductRepository.java
```java
@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
```

## Configuration

### application.properties

```c
spring.data.mongodb.host=mongo_db
spring.data.mongodb.port=27017
spring.data.mongodb.database=mydb
```

### docker-compose.yml

```c
version: '3.3'

services:
    #service 1: definition of mongo database
    mongo_db:
      image: mongo
      container_name: mongoDB  
      restart: always
      ports:
        - 27017:27017
     
    
    #service 2: definition of your spring-boot app 
    productservice:                        #it is just a name, which will be used only in this file.
      image: product-service               #name of the image after dockerfile executes
      container_name: product-service-app  #name of the container created from docker image
      build:
        context: .                          #docker file path (. means root directory)
        dockerfile: Dockerfile              #docker file name
      ports:
        - "8080:8080"                       #docker containter port with your os port
      restart: always  
      depends_on:                           #define dependencies of this app
        - mongo_db                                #dependency name (which is defined with this name 'db' in this file earlier)
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
