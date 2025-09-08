public class UserRegistration {

    /**
     * Orchestrates the validation flow and logging using try-with-resources.
     * Ensures only one completion message thanks to ValidationLogger.close().
     */
    public void registerUser(String password, String confirmPassword) {
        try (ValidationLogger logger = new ValidationLogger()) {
            try {
                PasswordValidator validator = new PasswordValidator();
                validator.validatePassword(password, confirmPassword);
                logger.logSuccess();
            } catch (WeakPasswordException | PasswordMismatchException e) {
                logger.logFailure(e.getMessage());
            }
        }
    }
}
