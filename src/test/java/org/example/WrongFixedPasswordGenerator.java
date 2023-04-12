package org.example;

import org.example.makepassword.PasswordGenerator;

public class WrongFixedPasswordGenerator implements PasswordGenerator {


    @Override
    public String generatePassword() {
        return "ab"; //8글자
    }
}
