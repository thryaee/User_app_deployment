# build stage
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY user_app/pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY user_app/src ./src
RUN mvn -q -DskipTests package

# run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target/*.war app.war
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -Dserver.port=${PORT:-8080} -jar app.war"]
