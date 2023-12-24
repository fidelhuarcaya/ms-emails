FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /home/app/target/ms-emails-0.0.1-SNAPSHOT.jar ms-emails-0.0.1.jar
ENTRYPOINT ["java","-jar","/ms-emails-0.0.1.jar"]

