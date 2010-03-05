Assignment Directory Structure
==============================

============================== =================================================
Node            Purpose
============================== =================================================
/                              Homework root
/Assignment\_\d+               The actual assignments
/Assignment\_\d+/exercises.rst Non-programming exercises
/Assignment\_\d+/.*?/OUTPUT    The output of the programming exercise, e.g::
                               
                                  javac Main.java && java Main > OUTPUT
============================== =================================================

Run ::

    ./build.sh $assignment_number

from homework root to generate a PDF of the assignment.
Expects OUTPUT files to already be created.
