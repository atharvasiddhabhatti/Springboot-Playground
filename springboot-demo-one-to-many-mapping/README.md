# Spring Boot One To Many Mapping Demo With H2 database

There are three basic entity relationships:-

* One-to-One
* One-to-Many/Many-to-one
* Many-to-Many

## Installation

Import Maven based project in any of your Favourite IDE.

```bash
./mvnw spring-boot:run
```
## Output
Open in Browser

Access H2 Database.

```
http://localhost:8080/h2-console
```

## Usage
### MainClass.java
run() method is run when the application is started. The data is added in the database.

```java
	Post post = new Post("Spring Boot Post Title","Spring Boot Post Description");
		Comment comment1 = new Comment("Thanks for uploading");
		Comment comment2 = new Comment("Comment2 test");
		Comment comment3 = new Comment("Comment3 test");
		
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);
		
		postRepository.save(post);
```


### Post.java
Id column is used to map the post and comments together.

```java
@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_Comment_id",referencedColumnName = "id")
	List<Comment> comments = new ArrayList<>();
```
## Output
![alt Output1](./output/output1.png)
![alt Output2](./output/output2.png)
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