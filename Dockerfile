FROM openjdk:17-jdk-slim

WORKDIR /usr/src

COPY src /usr/src

RUN javac hr/bulb/tech/Main.java

CMD ["java", "hr.bulb.tech.Main"]
