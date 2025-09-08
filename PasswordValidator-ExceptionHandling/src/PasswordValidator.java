public class PasswordValidator {


    public void validatePassword(String password, String confirmPassword) throws WeakPasswordException, PasswordMismatchException{
        if(password.length() < 8){
            throw new WeakPasswordException("Password must be at least 8 chars long.");
        }

        if (password.length() > 20){
            throw new WeakPasswordException("Password must not exceed 20 chars.");
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-+";

        for (char ch: password.toCharArray()){
            if(Character.isUpperCase(ch)){
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if (specialChars.indexOf(ch) >= 0){
                hasSpecialChar = true;
            }
        }

        if (!hasUppercase || !hasLowercase || !hasNumber || !hasSpecialChar) {
            throw new WeakPasswordException("Password must contain at least one uppercase letter, one lowercase letter, one number, and one special char.");
        }


        if(!password.equals(confirmPassword)){
            throw new PasswordMismatchException("Passwords do not match.");
        }
    }


}
