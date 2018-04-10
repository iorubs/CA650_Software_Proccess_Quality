#!/bin/bash

mvn test

mvn pitest:mutationCoverage
