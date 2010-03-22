#! /usr/bin/env python

import sys
from glob import glob

source = "Assignment_%s" % (sys.argv[1],)

print open(".build/header.rst").read(),

print "=" * len(source)
print source
print "=" * len(source)

print "\nProblems\n========\n"

print open("%s/exercises.rst" % (source,)).read(),

print "Programming Exercises\n=====================\n"

for exercise in glob("%s/*" % (source,)):
    if "exercise" in exercise:
        continue
    
    ex_title = exercise[exercise.rfind("/")+1:]
    
    print "-" * len(ex_title)
    print ex_title
    print "-" * len(ex_title)
    
    for code in glob("%s/*" % (exercise,)):
        if "~" not in code and ".java" in code:
            #print "\nCode\n----"
            print ".. code-block:: java\n    "
            f = open(code)
            for line in f:
                print "    %s" % (line,),
            f.close()
    
    for output in glob("%s/OUTPUT" % (exercise,)):
        print "\nOutput\n------\n::\n    "
        f = open(output)
        for line in f:
            print "    %s" % (line,),
        f.close()
    
    print ""

