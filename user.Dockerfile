FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/expense-service-jar-with-dependencies.jar /app/expense-service.jar

EXPOSE 8090

CMD ["java", "-jar", "/app/expense-service.jar"]
