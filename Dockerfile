FROM eclipse-temurin
COPY out/artifacts/game_management_server/game-management-service.jar /game-management-server.jar
ENTRYPOINT ["java","-jar","game-management-server.jar"]

FROM eclipse-temurin
COPY out/artifacts/game_management_natssub/game-management-service.jar /game-management-natssub.jar
ENTRYPOINT ["java","-jar","game-management-natssub.jar"]