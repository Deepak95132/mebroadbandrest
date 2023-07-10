#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17-jre-slim
COPY --from=build /home/app/target/me-broadband-rest-api-0.0.1-SNAPSHOT.jar /usr/local/lib/me-broadband-rest-api.jar
EXPOSE 8091
ENTRYPOINT ["java","-jar","/usr/local/lib/me-broadband-rest-api.jar"]