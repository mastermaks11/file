package by.itacademy.reflection.generator;

import java.util.Random;

/**
 * Created by user on 30.06.2018.
 */
public class RandomString {

    public static String random() {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String s = "";
        Random random = new Random();
        int randomLen = 1 + random.nextInt(9);
        for (int i = 0; i < randomLen; i++)

        {
            char c = alphabet.charAt(random.nextInt(26));
            s += c;
        }
        return s;
    }
}

