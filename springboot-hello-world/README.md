# Spring Boot [Rest API] - Hello World

Hello World App developed using Spring Boot.

## Installation

Import Maven based project in any of your Favourite IDE.

```bash
./mvnw spring-boot:run
```
## Output
Open in Browser

```
http://localhost:5000/hello-world
```

```
http://localhost:5000/helloworld-bean
```
## Usage
### HelloWorldController.java
helloWorld() method returning a string "Hello World".

```java
@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
```
helloWorldBean() method returning a bean.

```java
@GetMapping("/helloworld-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
```
helloWorld1() method printing Hello World, 'name' using @PathVariable annotation

```java
@GetMapping("/helloworld/{name}")
	public HelloWorldBean helloWorl1(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
```


## Credits
[in28Minutes](https://www.udemy.com/user/in28minutes/)