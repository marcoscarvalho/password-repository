FROM openjdk:17
MAINTAINER marcoscarvalho.com
WORKDIR /usr/src/app
COPY ./target/password-validator.jar /usr/src/app/password-validator.jar
ENTRYPOINT [ "java", "-jar", "password-validator.jar" ]

