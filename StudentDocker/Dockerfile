FROM openjdk:24-jdk
ADD target/student-app.jar student-app.jar
ENTRYPOINT ["java","-jar","/student-app.jar"]

#
#version: "3.7"
#
#services:
#
#  app:
#    build: .
#    ports:
#      - "8080:8080"
#    networks:
#      - s-network
#
#  mysql:
#    image: mysql:latest
#    environment:
#      MYSQL_DATABASE: 'spring'
#      MYSQL_USER: 'root2'
#      MYSQL_PASSWORD: '1234'
#      MYSQL_ROOT_PASSWORD: '1234'
#    ports:
#    - 3307:3306
#    networks:
#    - s-network
#
#networks:
#  s-network:
#    driver: bridge