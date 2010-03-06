Assignment Directory Structure
==============================

============================== =================================================
Node                           Purpose
============================== =================================================
/                              Homework root
/Assignment\_\d+               The actual assignments
/Assignment\_\d+/exercises.rst Non-programming exercises
/Assignment\_\d+/.*?           A programming exercise.
/Assignment\_\d+/.*?/OUTPUT    The output of the programming exercise, e.g::
                               
                                  $ javac Main.java
                                  $ java Main > OUTPUT
                               
                               Used by the PDF builder script to assemble the
                               Print-out and turn-in portion of assignments.
============================== =================================================

Run the following from homework root to generate a PDF of the assignment
(expects OUTPUT files to already be created)::

    ./build.sh $assignment_number
