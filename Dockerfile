FROM maven:3-openjdk-17 as build-backend
WORKDIR /usr/src/app

# Copy server code & maven pom
COPY pom.xml .
COPY src src

# Build
RUN --mount=type=cache,target=/root/.m2  mvn clean install -P gcp -DskipTests


FROM bellsoft/liberica-openjdk-alpine:17
WORKDIR /usr/src/app

COPY --from=build-backend /usr/src/app/target/*.jar .

CMD java -jar *.jar --spring.profiles.active=gcp
