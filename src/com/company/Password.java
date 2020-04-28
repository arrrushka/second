package com.company;

public class Password {
    // passwordStr // it should contain uppercase and lowercase letters and digits
    // and its length must be more than 9 symbols

    private String password;

    public Password(String password) {
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean check(User user) {
        Password password = user.getPassword();
        String userPassword = password.getPassword();

        boolean hasDigit = false,
                hasUpperCase = false,
                hasLowerCase = false;

        if (userPassword.length() >= 9) {
            for (int i = 0; i < userPassword.length(); i++) {
                Character c = userPassword.charAt(i);
                if (Character.isDigit(c)) {
                    hasDigit = true;
                }
                if (c >= 65 && c <= 90) {
                    hasUpperCase = true;
                }
                if (c >= 97 && c <= 122) {
                    hasLowerCase = true;
                }
            }
            return hasDigit && hasLowerCase && hasUpperCase;
        } else {
            return false;
        }
    }
}
