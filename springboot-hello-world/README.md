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
The @GetMapping annotation is used to handle the GET request with the URI provided. It is a different version of @RequestMapping specifically for the GET Request.

```java
@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
```
helloWorldBean() method returning a bean with string parameter "Hello World". The bean is nothing but the instance object which are managed by the spring container. These beans are kind of stored at a one place like bag of beans from where they are accessed whenever required. The object created by the container are called beans.

```java
@GetMapping("/helloworld-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
```
helloWorld1() method printing Hello World, 'name' using @PathVariable annotation. The @PathVariable annotation is used to extract the parameter value from the URI provided in this case name is being extracted from the URI and then it is called by the HelloWorldBean.

```java
@GetMapping("/helloworld/{name}")
	public HelloWorldBean helloWorl1(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
```


## Credits
[in28Minutes](https://www.udemy.com/user/in28minutes/)