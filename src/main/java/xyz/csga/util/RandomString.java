package xyz.csga.util;

import java.util.Random;

public class RandomString {
    private final static String[] CHARS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static String create(int length){
        StringBuilder sb = new StringBuilder();
        int i = length;
        Random random = new Random(System.currentTimeMillis());
        while(i-->0){
            sb.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return sb.toString();
    }
}
