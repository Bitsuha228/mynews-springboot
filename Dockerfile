FROM gradle:8.7-jdk-21-and-22-alpine AS builder
COPY . .
RUN ./gradlew bootJar --no-daemon
RUN pwd

FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=builder /home/gradle/build/libs/news-0.0.1-SNAPSHOT.jar news.jar

ENTRYPOINT ["java","-jar","news.jar"]