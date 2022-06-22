FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/Timesheet-devops-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Timesheet-devops-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Timesheet-devops-0.0.1-SNAPSHOT.jar"]