package com.taran.navitex.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositiveNumberValidator {
    private static final Pattern VALIDATE_PATTERN = Pattern.compile("\\d+");

    private PositiveNumberValidator() {
    }

    public static boolean validate(String value) {
        if (value == null) {
            return false;
        }
        Matcher matcher = VALIDATE_PATTERN.matcher(value);
        return matcher.matches();
    }
}
