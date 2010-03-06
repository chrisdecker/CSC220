==================================
CSC220 - Advanced Java Programming
==================================

Homework repository for Erik Youngren <artanis.00@gmail.com>, specifically the
CSC220 programming class.

Assignment Directory Structure
==============================

================================= ==============================================
Node                              Purpose
================================= ==============================================
/                                 Homework root
/Assignment\\\_\\d+               An assignment
/Assignment\\\_\\d+/exercises.rst Non-programming exercises in in the assignment.
/Assignment\\\_\\d+/.*?           A programming exercise.
/Assignment\\\_\\d+/.*?/OUTPUT    The output of the programming exercise, e.g::
                                  
                                      $ javac Main.java
                                      $ java Main > OUTPUT
                                  
                                  Used by the PDF builder script to assemble the
                                  print-out and turn-in portion of assignments.
================================= ==============================================

Generate PDF for Turn-in
========================

Run the following from homework root to generate a PDF of the assignment
(expects OUTPUT files to already be created)::

    ./build.sh $assignment_number
