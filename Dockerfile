FROM eclipse-temurin
WORKDIR /app
COPY out/artifacts/game_management_service_jar/game-management-service.jar /service.jar
CMD ["java","-jar","service.jar"]