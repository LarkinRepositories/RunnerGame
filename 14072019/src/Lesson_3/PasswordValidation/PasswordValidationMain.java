package Lesson_3.PasswordValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidationMain {
    public static void main(String[] args) {
        String password = "vjAYqksUs89%1";
        String password1 = "ghayqoeld^1";
        String passwordThatMatches = "UapKifL1";

        System.out.println("Вызываем собственный метод validatePassword():");

        System.out.println(validatePassword(password));
        System.out.println(validatePassword(password1));
        System.out.println(validatePassword(passwordThatMatches));

        System.out.println("Используем метод matches(), класса стринг, чтобы не изобретать велоспипед:");

        System.out.println(password.matches("[a-zA-Z0-9_-]{8}"));
        System.out.println(password1.matches("[a-zA-Z0-9_-]{8}"));
        System.out.println(passwordThatMatches.matches("[a-zA-Z0-9_-]{8}"));
    }

    private static boolean validatePassword(String password) {
       Pattern pattern = Pattern.compile("[a-zA-Z0-9_-]{8}");
       Matcher passwordMatcher = pattern.matcher(password);
       return  passwordMatcher.matches();
    }
}
