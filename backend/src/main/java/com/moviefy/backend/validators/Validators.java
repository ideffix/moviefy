package com.moviefy.backend.validators;

public class Validators {
    public static boolean checkSpecialSing(String password) {
        boolean isOneSpecialSign = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(c >= 33  && c <= 47) {
                isOneSpecialSign = true;
                break;
            }
        }
        return isOneSpecialSign;
    }

    public static boolean checkCapitalLetters(String password) {
        boolean isOneGreatChar = false;
        for(int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ( c >= 'A' && c <= 'Z') {
                isOneGreatChar = true;
                break;
            }
        }
        return isOneGreatChar;
    }

    public static boolean checkNumber(String password) {
        boolean isOneGreatChar = false;
        for(int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ( c >= '0' && c <= '9') {
                isOneGreatChar = true;
                break;
            }
        }
        return isOneGreatChar;
    }

    public static boolean checkAt(String email) {
        boolean isOneGreatChar = false;
        for(int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if ( c == '@') {
                isOneGreatChar = true;
                break;
            }
        }
        return isOneGreatChar;
    }

    public static boolean checkDot(String email) {
        boolean isOneGreatChar = false;
        for(int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if ( c >= '.') {
                isOneGreatChar = true;
                break;
            }
        }
        return isOneGreatChar;
    }
}
