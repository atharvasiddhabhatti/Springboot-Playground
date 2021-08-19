# Spring Boot [Publisher- Subscriber] - Rabbit MQ using Docker



Docker is required to be installed on the machine.

## Installation
1) Clone the Repo & run the following commands.

```bash
docker-compose up
```

## Output

Post a request using Postman on:-

```
localhost:8081/order/taj
```
Send this in body:- 

```c
{
"name" : "Sandwitch",
"qty" : 2,
"price" : 212
}
```

## Usage
### MessagingConfig.java
```java
@Configuration
public class MessagingConfig {
	@Bean
	public Queue queue() {
		 return new Queue(Constants.QUEUE);
	}
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(Constants.EXCHANGE); 
	}
	@Bean	
	public Binding binding(Queue queue , TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Constants.ROUTING_KEY); 
	}
	
    @Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(converter());
	        return rabbitTemplate;
    }
}
```
### OrderPublisher.java
```java
@RestController 
@RequestMapping("/order")
public class OrderPublisher {
 
	@Autowired
	private RabbitTemplate rabbitTemplate;
	 
		@PostMapping("/{restaurantName}")
		public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName ) {
			order.setOrderId(UUID.randomUUID().toString());
			OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order Successfully Placed"+ restaurantName);
			
			rabbitTemplate.convertAndSend(Constants.EXCHANGE,Constants.ROUTING_KEY, orderStatus);
			return "success!!"; 
		}
}
```
### User.java (consumer)
```java
@Component
public class User {

	@RabbitListener(queues = Constants.QUEUE )
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("Message Received from queue: " +orderStatus );
	}
}
```
### Constants.java 
Constants are defined in the class.

```java
public class Constants {
	public static final String QUEUE = "rabbit_queue";
	public static final String EXCHANGE = "rabbit_exchange";
	public static final String ROUTING_KEY = "rabbit_routingKey";
}
```
## Configuration
### docker-compose.yml

```c
version: '3.3'

services:
    #service 1: definition of mysql database
    rabbitmq:
      image: rabbitmq:3-management
      container_name: rabbitmq  
      restart: always
      ports:
        - "15672:15672"
        - "5672:5672"
    
    #service 3: definition of your spring-boot app 
    orderservice:                        #it is just a name, which will be used only in this file.
      image: order-service               #name of the image after dockerfile executes
      container_name: order-service-app  #name of the container created from docker image
      build:
        context: .                          #docker file path (. means root directory)
        dockerfile: Dockerfile              #docker file name
      ports:
        - "8081:8080"                       #docker containter port with your os port
      restart: always
      environment:
        - SPRING_RABBITMQ_HOST=rabbitmq  
      depends_on:                           #define dependencies of this app
        - rabbitmq                                #dependency name (which is defined with this name 'db' in this file earlier)
```
### Dockerfile
```c
FROM openjdk:11 as rabbitmq
EXPOSE 8081
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

RUN ./mvnw package -DskipTests
ENTRYPOINT ["java","-jar","target/springboot-demo-activemq-0.0.1-SNAPSHOT.jar"]
```
