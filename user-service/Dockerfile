FROM openjdk:8
ADD target/docker-service.jar /srv/docker-service.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/srv/docker-service.jar"]
