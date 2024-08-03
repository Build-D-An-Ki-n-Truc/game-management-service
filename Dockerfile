FROM maven as build
COPY pom.xml .
COPY src ./src
RUN mvn -f pom.xml clean package

FROM eclipse-temurin
COPY --from=build target/service.jar /game-management-service.jar
ENTRYPOINT ["java","-jar","game-management-service.jar"]