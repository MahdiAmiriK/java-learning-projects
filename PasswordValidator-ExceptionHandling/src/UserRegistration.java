public class UserRegistration {
    public void registerUser (String password, String confirmPassword) {
        try (ValidationLogger logger = new ValidationLogger()) {
            PasswordValidator passValid = new PasswordValidator();
            passValid.validatePassword(password, confirmPassword);
            logger.logSuccess();
        } catch (WeakPasswordException | PasswordMismatchException e){
            try (ValidationLogger logger = new ValidationLogger()){
                logger.logFailure(e.getMessage());
            }
        } finally {
            try (ValidationLogger logger = new ValidationLogger()) {
                logger.close();
            }
        }
    }
}
