FROM openjdk:latest
#рабочая директория
WORKDIR /usr/src/app
#копируем код
COPY ./src/main/java .
#компилируем Java
RUN javac -sourcepath . -d out ./org/example/lesson/Test.java
# теперь рабочая директория - директория с файлами .class
WORKDIR /usr/src/app/out

#CMD java -classpath . org.example.Main
ENTRYPOINT ["java", "org.example.lesson.Test"]