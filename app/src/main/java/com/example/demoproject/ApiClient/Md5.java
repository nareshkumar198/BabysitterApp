package com.example.demoproject.ApiClient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    private String hashedPassword;

    public Md5(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getMd5(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(hashedPassword.getBytes());
            BigInteger number = new BigInteger(1 , messageDigest);
            String hashText = number.toString(16);
            while (hashText.length()<32){
                hashText ="0"+hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
}