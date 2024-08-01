FROM maven
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package

FROM eclipse-temurin
COPY target/game-management-service-1.0-SNAPSHOT.jar /game-management-server.jar
ENTRYPOINT ["java","-jar","game-management-server.jar"]