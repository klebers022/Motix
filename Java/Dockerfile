FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn -B -e -X -DskipTests dependency:go-offline


COPY src ./src
RUN mvn -B -e -DskipTests package spring-boot:repackage

FROM eclipse-temurin:21-jre
WORKDIR /app

# Usuário não-root
RUN useradd -r -u 1001 appuser
USER appuser

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080
ENV JAVA_OPTS=""

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
