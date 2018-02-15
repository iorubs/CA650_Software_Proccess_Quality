#!/bin/sh

mkdir build

javac -d /app/build -cp /app/junit/junit-4.12.jar /app/tests/*.java /app/src/*.java

java -jar /app/junit/jcov.jar Instr build/Stack.class

java -cp /app/build:/app/junit/junit-4.12.jar:/app/junit/hamcrest-core-1.3.jar:/app/junit/jcov_file_saver.jar TestRunner

java -jar /app/junit/jcov.jar RepGen -o report result.xml

rm -rf build result.xml template.xml
