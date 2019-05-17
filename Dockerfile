# syntax = docker/dockerfile:1.0-experimental

FROM openjdk:12.0.1-jdk-oracle AS builder

ADD . /work
WORKDIR /work
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build

FROM openjdk:12.0.1-jdk-oracle AS runner

ENV JAR=demo-0.0.1-SNAPSHOT.jar

WORKDIR /home/app

COPY --from=builder /work/build/libs/$JAR /home/app/

CMD ["sh", "-c", "java -jar $JAR"]
