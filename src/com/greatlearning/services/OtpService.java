package com.greatlearning.services;

public class OtpService {

    public int generateOtp() {
        return (int)(Math.random()*1000);
    }
}
