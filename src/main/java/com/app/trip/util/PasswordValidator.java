package com.app.trip.util;

import java.util.regex.Pattern;

public class PasswordValidator {
    private static final String REGEX = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$";

    public static boolean isValid(String password) {
        return Pattern.matches(REGEX, password);
    }
}