# Email Validator

A simple Java program that checks if an email address is valid based on basic rules.

## How to Run
1. Compile the program:
   javac Main.java
2. Run the program:
   java Main
3. Enter an email address to check if it is valid.

## Validation Rules
- Email must contain exactly one '@'
- '@' cannot be the first or last character
- '.' cannot be the last character
- At least one '.' must appear after '@'
- No spaces allowed in the email
- No consecutive '.' or multiple '@'