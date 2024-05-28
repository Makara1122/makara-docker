# Build stage

FROM gradle:7.4.2-jdk17 AS build

WORKDIR /app

COPY build.gradle settings.gradle ./

COPY src ./src

RUN gradle clean build -x test

# Run stage

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build build/libs/*-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "app.jar"]