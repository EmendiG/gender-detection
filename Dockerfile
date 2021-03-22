FROM adoptopenjdk/openjdk11:alpine-slim

ENV LANG C.UTF-8
ENV LANGUAGE C.UTF-8
ENV LC_ALL C.UTF-8

ARG WORK_DIR=/app
WORKDIR ${WORK_DIR}
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ${WORK_DIR}/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/app/app.jar"]