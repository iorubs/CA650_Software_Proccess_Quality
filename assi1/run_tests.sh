#!/bin/sh

javac -d /app/src -cp /app/junit-4.12.jar /app/tests/TestStack.java

java -cp /app/src:/app/junit/junit-4.12.jar:/app/junit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore TestStack
