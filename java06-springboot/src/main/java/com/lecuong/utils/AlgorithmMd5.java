package com.lecuong.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class AlgorithmMd5 {

    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] messageDigset = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigset);
            String hashText = no.toString(16);
            return hashText.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getMd5("123456"));
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }
}
