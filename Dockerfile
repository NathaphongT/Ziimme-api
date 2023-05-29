# ------------------------------ Maven ---------------------------------
FROM maven:3.9-ibmjava as build
COPY . .
RUN mvn clean package

# ------------------------------ Java  ---------------------------------
FROM openjdk:21-slim-buster
COPY --from=build target/websource-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/websource-0.0.1-SNAPSHOT.jar"]
