FROM java:8
ADD ./pebbles-batch.jar .
EXPOSE 9997
CMD java -jar -Xmx512M pebbles-batch.jar
