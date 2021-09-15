# Spring Boot - Pagination and Sorting 
Pagination is often helpful when we have a large dataset and we want to present it to the user in smaller chunks.
Also, we often need to sort that data by some criteria while paging.


## Installation
1) Clone the Repo & run the following commands.

## Output
Open in Browser


Access H2 Database.

```
http://localhost:8080/h2-console
```

## Output

| Endpoint | Method | Body | Description |
|:---:|:---:|:---:|:---:|
| http://localhost:8080/student/search | GET | - | To get all students in paginated format |
| http://localhost:8080/products/{id} | GET | - | Find Product by Id |
| http://localhost:8080/student | POST | { "id":214214,"name":"Atharva","rollno":32 } | To Add Students to the DB |
| http://localhost:8080/pagination?pageSize=5 | GET | - | To Add Students to the DB |
| http://localhost:8080/employees?pageSize=5&pageNo=1 | GET | - | To get student details by pagesize 5 and pageno 2 |
| http://localhost:8080/employees?pageSize=5&pageNo=2 | GET | - | To get student details by pagesize 5 and pageno 1 |
| http://localhost:8080/employees?pageSize=5&pageNo=1&sortBy=id | GET | - | To sort student details by id |
| http://localhost:8080/employees?pageSize=5&pageNo=1&sortBy=name | GET | - | To sort student by name |


## Usage
### SortingRepository.java
```java
@Repository
public interface SortingRepository extends PagingAndSortingRepository<Student, Integer>  {

}
```

## Configuration

### application.properties

```c
spring.jpa.show-sql = true

# Enabling H2 Console
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.defer-datasource-initialization=true
spring.h2.console.enabled=true

# Enable Web Access
spring.h2.console.settings.web-allow-others=true

```
## Credits
https://howtodoinjava.com