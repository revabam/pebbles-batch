FROM java:8
ADD ./batch-service.jar .
EXPOSE 9997
CMD java -jar -Xmx512M batch-service.jar
