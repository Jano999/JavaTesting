package Test;

import java.util.Random;

public class RandomStringGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String CHAR_DIGITS = "0123456789";
    private static final String CHAR_SPECIAL = "!@#$%^&*()_+-=[]?";
    private static final String CHAR_ALL = CHAR_LOWER + CHAR_UPPER + CHAR_DIGITS + CHAR_SPECIAL;

    private static Random random = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        // add one uppercase character
        sb.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));

        // add one digit
        sb.append(CHAR_DIGITS.charAt(random.nextInt(CHAR_DIGITS.length())));

        // add one special character
        sb.append(CHAR_SPECIAL.charAt(random.nextInt(CHAR_SPECIAL.length())));

        // add the rest of the characters
        for (int i = 3; i < length; i++) {
            sb.append(CHAR_ALL.charAt(random.nextInt(CHAR_ALL.length())));
        }

        return sb.toString();
    }
}
