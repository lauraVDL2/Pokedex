# Stage 1: Build with Maven
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app
COPY backend/ /app/
RUN mvn clean install -DskipTests
# Stage 2: Java/SpringBoot
FROM openjdk:21-jdk
WORKDIR /app
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/backend-0.0.1-SNAPSHOT.jar"]
