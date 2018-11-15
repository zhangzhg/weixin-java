package com.hsm.pay.common.util;

public class EncryptNumberUtil {
    public static String encrypt(String word) {
        int lengSize = word.length()-4;
        return word.replaceAll("\\d{"+lengSize+"}(\\w{4})", "****$1");
    }
}
