Rock, Paper, Scissors game
=========================

About
--------------------

Write a program that plays Rock, Paper, Scissors against a human. Try to exploit that humans are very bad at generating random numbers

How to compile
--------------------

Project uses Gradle standard repository, so you can easily use 

    gradle clean build

How to run it
--------------------

To start game just compile it, run 

    sh run.sh

and follow further instruction

Example of usage
--------------------

    andrey@dell:~/Projects/game$ sh run.sh 
    How to use:
	  E, e	-	 for exit game;
	  R, r	-	 for rock;
	  P, p	-	 for paper;
	  S, s	-	 for sci ssors.


    Please enter your choice: 
    [R, P, S]: r
    My move was: p, you: LOSS
    [R, P, S]: r
    My move was: s, you: WIN
    [R, P, S]: r
    My move was: p, you: LOSS
    [R, P, S]: r
    My move was: p, you: LOSS
