FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/client-jar-with-dependencies.jar /app/client.jar

EXPOSE 8085

CMD ["java", "-jar", "/app/client.jar"]
