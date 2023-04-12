package org.example;

import org.assertj.core.api.Assertions;
import org.example.makepassword.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class UserTest {
    @DisplayName("password를 초기화 한다.")
    @Test
    void passwordTest() {
        //gieven
        User user = new User();

        //When
//        user.initPassword(new CourrectFixedPasswordGenerator());
        user.initPassword(() -> "acefyfgh");

        //than
        Assertions.assertThat(user.getPassword()).isNotNull();

    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화 되지 않는다.")
    @Test
    void passwordTest2() {
        //gieven
        User user = new User();

        //When
//        user.initPassword(new WrongFixedPasswordGenerator());
        user.initPassword(() -> "ab");

        // Than
        Assertions.assertThat(user.getPassword()).isNull();

    }
}