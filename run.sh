#!/bin/bash

cd ./Spreadsheet
javac edu/pitt/guandaw/spreadsheet/model/*.java edu/pitt/guandaw/spreadsheet/parser/*.java edu/pitt/guandaw/spreadsheet/processor/*.java

jar cvfm Spreadsheet.jar MANIFEST.MF *

mv Spreadsheet.jar ..

cd ..
java -jar Spreadsheet.jar

while read line
do
        echo "$line"
done < result.csv
