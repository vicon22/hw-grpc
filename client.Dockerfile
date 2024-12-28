FROM openjdk:17-jdk-slim

# Установка curl
RUN apt-get update && apt-get install -y curl

WORKDIR /app

COPY target/client-jar-with-dependencies.jar /app/client.jar

EXPOSE 3000

CMD ["java", "-jar", "/app/client.jar"]
