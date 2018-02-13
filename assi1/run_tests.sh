#!/bin/sh

mkdir build

javac -d /app/build -cp /app/junit/junit-4.12.jar /app/tests/*.java /app/src/*.java

java -cp /app/build:/app/junit/junit-4.12.jar:/app/junit/hamcrest-core-1.3.jar TestRunner

rm -rf build
