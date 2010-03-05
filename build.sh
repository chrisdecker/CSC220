#! /bin/bash

basedir=`pwd $0`

# Source and target directories/files
source="Assignment_$1"
rst="$source/$source.rst"
pdf="$source/$source.pdf"

# Compile all exercises
for jv in `ls $source/*/*.java`; do
    javac $jv
done;

# Build header (clobber the file to begin fresh)
cat .build/header.rst > $rst
echo "=================================================================" >> $rst
echo "Assignment $1" >> $rst
echo "=================================================================" >> $rst

# Run the programming exercises and append the output
echo "" >> $rst
echo "Programming Exercises" >> $rst
echo "=====================" >> $rst
for f in `ls $source/*/OUTPUT`; do
    echo "" >> $rst
    echo $f | sed "s/$source\///g" | sed 's/\/OUTPUT$//g' >> $rst
    echo "-------------------------------------------------------------" >> $rst
    echo -e "::\n    \n" >> $rst
    
    cat $f | while read line
    do
        echo -e "    $line" >> $rst
    done
done;

cd "$basedir"

# Append the non-programming exercises
echo "" >> $rst
echo "Exercises" >> $rst
echo "=========" >> $rst
cat $source/exercises.rst >> $rst

# Convert to PDF
rst2pdf $rst -o $pdf
