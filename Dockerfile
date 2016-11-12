FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/collision.jar /collision/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/collision/app.jar"]
