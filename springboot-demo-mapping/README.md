# Spring Boot Mapping Demo With H2 database

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
	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setName("Atharva Siddhabhatti");
		customer.setEmail("atharvasiddhabhatti@gmail.com");
		Item item = new Item();
		item.setName("Macbook");
		item.setQty(1);
		customer.setItem(item);
		item.setCustomer(customer);
		customerRepository.save(customer);
		
```


### Customer.java
Following annotations are used in the Customer Entity class to join two tables.Check the class file to view other entities.

```java
@OneToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private Item item;
```


### Item.java
```java
@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
	private Customer customer;
```
## Output
![alt Output1](./output/image1.png)
![alt Output2](./output/image2.png)
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