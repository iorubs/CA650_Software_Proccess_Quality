#!/bin/bash

mvn test

mvn org.pitest:pitest-maven:mutationCoverage
