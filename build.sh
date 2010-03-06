#! /bin/bash

# Source and target directories/files
source="Assignment_$1"
rst="$source/$source.rst"
pdf="$source/$source.pdf"

# Build header (clobber the file to begin fresh)
cat .build/header.rst > $rst
echo "=================================================================" >> $rst
echo "Assignment $1" >> $rst
echo "=================================================================" >> $rst

# Append the non-programming exercises
echo "" >> $rst
echo "Problems" >> $rst
echo "========" >> $rst
cat $source/exercises.rst >> $rst

echo -e "\n.. raw:: pdf\n    \n    PageBreak\n" >> $rst

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
    echo -e "\n.. raw:: pdf\n    \n    PageBreak\n" >> $rst
done;

echo ""

# Convert to PDF
rst2pdf $rst -o $pdf
