FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/djricardo.jar djricardo.jar
ENTRYPOINT ["java","-jar","djricardo.jar"]