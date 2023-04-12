package org.example;

import org.example.makepassword.PasswordGenerator;

public class CourrectFixedPasswordGenerator implements PasswordGenerator {


    @Override
    public String generatePassword() {
        return "acedgesf"; //8글자
    }
}
