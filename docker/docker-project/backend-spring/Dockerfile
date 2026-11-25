# ==========================
# Stage 1: Build application
# ==========================
FROM gradle:8.14.3-jdk17 AS build

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew bootJar --no-daemon


# ==========================
# Stage 2: Run application
# ==========================
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]