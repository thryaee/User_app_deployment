# =========================
# Build Stage
# =========================
FROM maven:3.9.11-eclipse-temurin-17 AS build

WORKDIR /src

# Copy pom.xml first to leverage Docker cache for dependencies
COPY user_app/pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Copy actual source code and build
COPY user_app/src ./src
RUN mvn -q -DskipTests package

# =========================
# Run Stage
# =========================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy built WAR file
COPY --from=build /src/target/*.war app.war

EXPOSE 8080

# Use proper spaces (no hidden NBSP)
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.war"]
