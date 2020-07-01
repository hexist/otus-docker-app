FROM openjdk:8
ADD target/docker-service.jar /srv/auth-service.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/srv/auth-service.jar"]
