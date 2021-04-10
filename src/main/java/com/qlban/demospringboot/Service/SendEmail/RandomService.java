package com.qlban.demospringboot.Service.SendEmail;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomService {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();

    private static final String DATA_FOR_RANDOM_STRING = CHAR_UPPER;
    private static SecureRandom random = new SecureRandom();

    public String randomCharat(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);

        }
        return sb.toString();
    }
}
