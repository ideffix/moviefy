package com.moviefy.backend.utilityClass;

import java.util.Random;

public class RandomToken {
    public static String getToken(int tokenLength) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int length = tokenLength;
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
