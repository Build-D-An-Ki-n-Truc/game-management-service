# Game Management Service

<div align="center">
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/192107855-e669c777-9172-49c5-b7e0-404e29df0fee.png" alt="gRPC" title="gRPC"/></code>
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java"/></code>
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/182884177-d48a8579-2cd0-447a-b9a6-ffc7cb02560e.png" alt="mongoDB" title="mongoDB"/></code>
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/117207330-263ba280-adf4-11eb-9b97-0ac5b40bc3be.png" alt="Docker" title="Docker"/></code>
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/182534182-c510199a-7a4d-4084-96e3-e3db2251bbce.png" alt="Prometheus" title="Prometheus"/></code>
    <code><img width="50" src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" alt="IntelliJ" title="IntelliJ"/></code>
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/117207242-07d5a700-adf4-11eb-975e-be04e62b984b.png" alt="Maven" title="Maven"/></code>
</div>

## Description
A microservice to manage game's data

## Installation
Generate a jar file
```console
mvn package
```

## Running the service
Running the jar file
```console
java -jar service.jar
```

## Dockerizing
```console
docker build -t game-management-service .
docker run -p 4010:4010 game-management-service
```
or just use the **docker-compose.yml** file.

## Usage
### Updating a game's status
Send a POST request to **/gameManage/updateStatus** with the following payload:
```json
{
    "id": ${gameID},
    "status": "NotStarted"/"InProgress"/"Finished"
}
```
### Updating a game's info
Send a POST request to **/gameManage/updateInfo** with the following payload:
```json
{
    "id": ${gameID},
    "name": ${gameName},
    "image": ${gameImageURL},
    "type": "Quiz"/"Shake",
    "alloweditemtrade": true/false,
    "tutorial": ${gameTutorial},
    "startTime": ${millisecSinceUnixEpoch},
    "endTime": ${millisecSinceUnixEpoch},
    "maxPlayers": ${gameMaxPlayers},
    "duration": ${gameDuration}
}
```
### Getting all game's info
Send a GET request to **/gameManage/getAll**
### Adding a new game
Send a POST request to **/gameManage/add** with the following payload:
```json
{
    "name": ${gameName},
    "image": ${gameImageURL},
    "type": "Quiz"/"Shake",
    "tutorial": ${gameTutorial},
    "startTime": ${millisecSinceUnixEpoch},
    "endTime": ${millisecSinceUnixEpoch},
    "maxPlayers": ${gameMaxPlayers},
    "duration": ${gameDuration}
    "questions": [
    {
      "text": ${questionText},
      "options": [${questionStringOption1}, ${questionStringOption2}, ...],
      "correctAnswer": ${questionCorrectAnswer}
    },
    {
    "text": ${questionText},
    "options": [${questionStringOption1}, ${questionStringOption2}, ...],
    "correctAnswer": ${questionCorrectAnswer}
    }
    ...
  ]
}
```