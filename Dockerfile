FROM eclipse-temurin:22-jdk

RUN java -version

RUN apt update
RUN apt -y install tesseract-ocr

# copy the backend
COPY apiro-app/target/apiro-app.jar /app/app.jar

COPY etc/maven396 /maven

RUN mkdir /apirowork

ENTRYPOINT exec sh -c "java --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/java.math=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.io=ALL-UNNAMED --add-exports=jdk.unsupported/sun.misc=ALL-UNNAMED $JVM_OPTS -jar /app/app.jar"
