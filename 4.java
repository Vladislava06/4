class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

public class Main {
    public static boolean validateCredentials(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Login length should be less than 20 characters");
        }

        if (password.length() >= 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password should be less than 20 characters and match the confirm password");
        }

        return true;
    }

    public static void main(String[] args) {
        String login = "username";
        String password = "password";
        String confirmPassword = "password";

        try {
            boolean isValid = validateCredentials(login, password, confirmPassword);
            System.out.println("Credentials are valid: " + isValid);
        } catch (WrongLoginException e) {
            System.out.println("Wrong login: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Wrong password: " + e.getMessage());
        }
    }
}