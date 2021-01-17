FROM java:8
WORKDIR /
RUN echo "Asia/Colombo" | tee /etc/timezone
RUN dpkg-reconfigure --frontend noninteractive tzdata
ADD department-0.0.1-SNAPSHOT.jar department-0.0.1-SNAPSHOT.jar
EXPOSE 5060
ENTRYPOINT ["java","-jar","department-0.0.1-SNAPSHOT.jar", "--server.servlet.context-path=/dp", "--server.port=5060"]
