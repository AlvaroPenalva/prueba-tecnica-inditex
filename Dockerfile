FROM openjdk:21-jdk

WORKDIR /app

COPY prices/target/prices-0.0.1-SNAPSHOT.jar /app/prices.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "prices.jar"]