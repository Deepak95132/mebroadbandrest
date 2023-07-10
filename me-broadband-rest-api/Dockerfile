#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17.0-jdk-slim
COPY --from=build /home/app/target/me-broadband-rest-api-0.0.1-SNAPSHOT.jar /usr/local/lib/me-broadband-rest-api.jar
EXPOSE 8094
ENTRYPOINT ["java","-Djdk.util.jar.enableMultiRelease=false","-jar","/usr/local/lib/me-broadband-rest-api.jar"]