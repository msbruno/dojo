FROM openjdk:17-jdk-slim
RUN mkdir /app
WORKDIR /app
COPY . /app
RUN ls
RUN javac App.java
ENTRYPOINT [ "java", "com.exemplo.App" ]

