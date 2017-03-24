FROM strictlybusiness/oracle-java8
MAINTAINER Khimin
VOLUME /tmp
#copy the project files
#build the project
ENV JAVA_OPTS=""
ADD target/spring-project-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
# mvn package && java -jar target/spring-project-0.0.1-SNAPSHOT.jar
#spring-project-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
