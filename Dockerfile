FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/djricardo.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]