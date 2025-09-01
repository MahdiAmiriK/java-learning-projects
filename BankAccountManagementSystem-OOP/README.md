# Bank Account Management System

## Overview
A **Java console-based banking system** built with **Object-Oriented Programming (OOP)** principles.  
It allows users to create accounts, deposit and withdraw money, check balances, and view transaction history.

---

## Features
- Create **Savings Account** (minimum balance rule $100)
- Create **Current Account** (overdraft limit up to -$500)
- Deposit money safely
- Withdraw money with rules based on account type
- Check account balance
- View transaction history
- Menu-driven console interface

---

## Project Structure
src/
├── BankAccount.java                 # Abstract base class
├── SavingsAccount.java              # Extends BankAccount (minimum balance rule)
├── CurrentAccount.java              # Extends BankAccount (overdraft rule)
├── BankService.java                 # Manages accounts & operations
├── InputUtils.java                  # Handles user input
└── BankAccountManagementSystem.java # Main class with menu UI

---

## OOP Concepts Used
- **Encapsulation** → private fields with getters/setters
- **Inheritance** → `SavingsAccount` and `CurrentAccount` extend `BankAccount`
- **Abstraction** → `BankAccount` is abstract with `withdraw()` implemented by subclasses
- **Polymorphism** → Different `withdraw()` behavior in subclasses

---

## How to Run
1. Compile all files:
   javac *.java

2. Run the main program:
   java BankAccountManagementSystem

---

## Sample Menu
*** Welcome to the 'Bank Account Management System' ***
Menu:
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Transaction History
6. Exit

---

## Example Usage
- Create a **Savings Account** with $200 → Account created
- Deposit $50 → Balance becomes $250
- Withdraw $120 → Allowed (balance = $130)
- Withdraw $50 → Blocked (would drop below $100)  