package ra.edu.btvn05;

public class Validation {
    public static boolean validateEmail(String email){
        String regexEmail = "^[\\w.-]+@[\\w.-]+\\.(com|vn)$";
        if (email == null) {
            return false;
        }
        return email.matches(regexEmail);
    }
    public static boolean validatePassword(String password){
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+]).{8,}$";
        if (password == null) {
            return false;
        }
        return password.matches(regexPassword);
    }
}
