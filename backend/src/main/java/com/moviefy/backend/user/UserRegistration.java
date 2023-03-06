package com.moviefy.backend.user;

import com.moviefy.backend.validators.Validators;
import com.moviefy.backend.utilityClass.PasswordHashUtility;

public class UserRegistration {
    public static String registration(String password, String email) {
        if(!Validators.checkSpecialSing(password)) {
            throw new RuntimeException("No special character!");
        }
        else if(!Validators.checkCapitalLetters(password)) {
            throw new RuntimeException("No capital letter!");
        }
        else if(!Validators.checkNumber(password)) {
            throw new RuntimeException("No number!");
        }
        if (!Validators.checkAt(email) || !Validators.checkDot(email)) {
            throw new RuntimeException("Wrong email provided!");
        }
        return PasswordHashUtility.hashPassword(password);
    }
    
    public static String hashPassword(String password) {
        return PasswordHashUtility.hashPassword(password);
    }
}
