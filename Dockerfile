# Builder
FROM maven:3.9.5-amazoncorretto-21-debian-bookworm as builder
ENV TZ="Asia/Tashkent"

WORKDIR /app
COPY src src
COPY pom.xml pom.xml

RUN mvn package -DskipTests
RUN mvn clean package -DskipTests


# Application
FROM eclipse-temurin:21-jdk
ENV TZ="Asia/Tashkent"

RUN apt-get update && apt-get install -y \
    libstdc++6 libcurl3-gnutls libc6 libxml2 libcurl4 fonts-dejavu fonts-opensymbol wget \
    fonts-liberation fonts-crosextra-carlito && \
    apt-get clean \

WORKDIR /app/lib
COPY --from=builder /app/target/*.jar application.jar
COPY --from=builder /app/src/main/resources/application.yml application.yml

ENTRYPOINT ["java", "-jar", "application.jar"]
