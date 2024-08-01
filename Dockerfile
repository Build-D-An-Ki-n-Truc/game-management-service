FROM eclipse-temurin
COPY target/game-management-service-1.0-SNAPSHOT.jar /game-management-server.jar
ENTRYPOINT ["java","-jar","game-management-server.jar"]