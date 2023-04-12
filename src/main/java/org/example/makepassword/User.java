package org.example.makepassword;

public class User {
    private String password;

    /**
     * 비밀번호가 8자 이상 12자 이하이어야 한다.
     */
    public void initPassword(PasswordGenerator passwordGenerator) {
//        RandomPasswordGendertor randomPasswordGendertor = new RandomPasswordGendertor();
        String passowrd =  passwordGenerator.generatePassword();

        if(passowrd.length() >= 8 && passowrd.length()  <= 12 ) {
            this.password = passowrd;
        }
    }

    public String getPassword() {
        return password;
    }
}
