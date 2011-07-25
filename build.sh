#!/bin/bash
CLASSPATH=./lib/craftbukkit-0.0.1-SNAPSHOT.jar

rm -rf bin
mkdir bin
javac -classpath $CLASSPATH -d bin src/com/hexbit/moar/*.java

cd bin
cp ../src/plugin.yml .
jar cf ../Moar.jar ./*
