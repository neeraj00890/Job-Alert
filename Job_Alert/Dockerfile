# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.8.1-jdk-11 AS MAVEN_BUILD

# copy the pom and src code to the container\
COPY Job_Alert/mvnw Job_Alert/pom.xml ./
COPY . .
RUN mysql --version
RUN cd common\
    && mvn install

# package our application code
RUN cd Job_Alert\
    && mvn install
#RUN mvn install

RUN echo 'Clean package'
# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:11-jre-alpine3.9

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD . ./

RUN ls
# set the startup command to execute the jar
CMD ["java", "-jar", "./Job_Alert/target/Job_Alert-0.0.1-SNAPSHOT.war"]