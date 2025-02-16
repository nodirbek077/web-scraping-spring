FROM eclipse-temurin:17-jdk
LABEL authors="Clone"

WORKDIR /web-scraping-spring

COPY target/*.jar web-scraping-spring.jar

EXPOSE 10000

CMD ["java", "-jar", "web-scraping-spring.jar"]