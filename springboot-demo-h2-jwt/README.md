# Spring Boot [Rest API] - H2 Database

CRUD Operations using Spring Boot and H2 Database.

## Installation

Import Maven based project in any of your Favourite IDE.

```bash
./mvnw spring-boot:run
```
## Output
Open in Browser

Access all the endpoints using Swagger UI.

```
http://localhost:8080/swagger-ui.html
```
Access H2 Database.

```
http://localhost:8080/h2-console
```
## Usage
### PropertyService.java
addProperty() method Saving property to the in-memory database H2.

```java
	public ResponseEntity<Object> addProperty(Property property) {
	     Property savedProperty = propertyRepository.save(property);
	     URI location =  ServletUriComponentsBuilder
	     .fromCurrentRequest()
	     .path("/{id}")
	     .buildAndExpand(savedProperty.getId()).toUri();
	     return ResponseEntity.created(location).build();
	  }
```

retriveAllProperties() Method to get all the properties from the DB.

```java
public List<Property> retriveAllProperties() {
		return propertyRepository.findAll();
	}
```

getPropertyByid() Method to find property by ID.

```java
public Optional<Property> getPropertyById(Integer id) {
	    return propertyRepository.findById(id);
	}
```

deletePropertyByid() Method to delete property by ID.

```java
public String deletePropertyById(Integer id) {
		propertyRepository.deleteById(id);
		return "Successfully Deleted property with ID:- " + id;
	}
```

updateProperty() method to update existing property.

```java
public ResponseEntity<Object> updateProperty(Property property) {
	     Property savedProperty = propertyRepository.save(property);
	     URI location =  ServletUriComponentsBuilder
	     .fromCurrentRequest()
	     .path("/{id}")
	     .buildAndExpand(savedProperty.getId()).toUri();
	     return ResponseEntity.created(location).build();
	  }
```

### PropertyController.java

```java
@GetMapping("/property")
	public List<Property> retriveAllProperties() {
		return propertyService.retriveAllProperties();
	}
```
```java
@PostMapping("/property")
	public ResponseEntity<Object> addProperty(@RequestBody Property property) {
	     return propertyService.addProperty(property);
	  }
```

```java
@GetMapping("/property/{id}")
	public Optional<Property> getPropertyById(@PathVariable Integer id) {
		return propertyService.getPropertyById(id);
	}
```

```java
@DeleteMapping("/property/{id}")
	public void deletePropertyById(@PathVariable Integer id) {
		propertyService.deletePropertyById(id);
		
	}
```

```java
@PatchMapping("/property")
	public ResponseEntity<Object> updateProperty(@RequestBody Property property) {
	     return propertyService.updateProperty(property);
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
[in28Minutes](https://www.udemy.com/user/in28minutes/)