FROM openjdk:23-jdk

WORKDIR /app

COPY target/prices-1.0.0.jar /app/prices.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "prices.jar"]