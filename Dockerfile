FROM openjdk:18
ADD target/propertysearchsystem-0.0.1-SNAPSHOT.jar propertysearchsystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /propertysearchsystem-0.0.1-SNAPSHOT.jar"]