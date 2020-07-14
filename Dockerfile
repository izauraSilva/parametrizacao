FROM nexus.original.com.br:5000/jdk:11.0.3
COPY /target/*.jar /usr/app/app.jar
ENV profile=""
ENV password=""
ENV algorithm=PBEWITHMD5ANDDES
WORKDIR /usr/app
EXPOSE 8413
ENTRYPOINT ["java", "-Dspring.profiles.active=${profile}","-Duser.timezone=America/Sao_Paulo", "-jar", "app.jar"]
