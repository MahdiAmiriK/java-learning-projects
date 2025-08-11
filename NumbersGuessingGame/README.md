# Number Guessing Game

A simple Java console game where the computer guesses the number you are thinking of between 1 and 100 using a binary search algorithm.

## How to Run
1. Compile the code:
   javac Main.java
2. Run the program:
   java Main

## How it Works
- You think of a number between 1 and 100.
- The program guesses a number and asks if it's correct (`c`), higher (`h`), or lower (`l`).
- It narrows down the range using binary search until it finds your number.