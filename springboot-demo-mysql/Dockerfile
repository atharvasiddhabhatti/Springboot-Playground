FROM openjdk:11
EXPOSE 8084
WORKDIR /app
COPY ./ ./
RUN ./mvnw clean package
COPY target/springboot-demo-mysql-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "springboot-demo-mysql-0.0.1-SNAPSHOT.jar" ]