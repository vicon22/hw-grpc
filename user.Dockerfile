FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/user-service-jar-with-dependencies.jar /app/user-service.jar

EXPOSE 8090

CMD ["java", "-jar", "/app/user-service.jar"]
