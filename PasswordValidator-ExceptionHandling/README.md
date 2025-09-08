# Password Validation Tool (Java)

A small console app that validates passwords using custom exceptions and try-with-resources logging.

## Features
- Enforces strong password rules:
    - Length: 8–20
    - At least one uppercase, one lowercase, one digit, and one special char (`!@#$%^&*()-+`)
- Confirms password equals confirm-password
- Custom checked exceptions:
    - `WeakPasswordException`
    - `PasswordMismatchException`
- Structured logging via `ValidationLogger` (implements `AutoCloseable`)
- Ensures only one completion message per validation attempt

## Project Structure
- `WeakPasswordException` – custom exception for weak passwords
- `PasswordMismatchException` – custom exception for mismatched confirm-password
- `PasswordValidator` – contains the validation logic
- `ValidationLogger` – logs SUCCESS/FAILURE and prints a single completion message in `close()`
- `UserRegistration` – orchestrates validation + logging using try-with-resources
- `Main` – simple console UI

## Example
Enter Password: Strong@123
Confirm Password: Strong@123
Status: SUCCESS | Message: The password meets all security criteria.
Status: INFO | Message: Password validation process completed.

## Notes
- The logger uses a static flag to print the completion message only once per run.

