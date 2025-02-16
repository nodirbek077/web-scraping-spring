# Java 17 bilan tayyor Docker imidjidan foydalanamiz
FROM eclipse-temurin:17-jdk

# Ishchi katalogni yaratamiz
WORKDIR /app

# Butun loyihani konteyner ichiga nusxalash
COPY . /app

# Maven wrapper ruxsatlarini sozlash
RUN chmod +x mvnw

# Maven build jarayonini bajaramiz (target katalogi yaratiladi)
RUN ./mvnw clean package -DskipTests

# JAR faylni ishga tushirish uchun ko‘chiramiz
COPY target/*.jar app.jar

# Render 10000-port orqali ishlaydi, uni ochamiz
EXPOSE 10000

# JAR faylni ishga tushiramiz
CMD ["java", "-jar", "app.jar"]
