FROM eclipse-temurin
COPY out/artifacts/game_management_service_jar/game-management-service.jar /service.jar
ENTRYPOINT ["java","-jar","service.jar"]