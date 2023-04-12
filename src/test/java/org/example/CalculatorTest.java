package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 *
 요구사항
 간단한 사칙연산을 할 수 있다.
 양수로만 계산할 수 있다.
 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */
public class CalculatorTest {

    // 1 + 2  ---> Calculator 전달
    //   3   <--- return 해주는 로직
    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {

       int result =  Calculator.calculate(1, "+", 2 );

       assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void additionTest2() {

       int result =  Calculator.calculate(1, "-", 2 );

       assertThat(result).isEqualTo(-1);
    }
///////////////////////////////////////////////////////////////////////////////
    @DisplayName("뺄셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest1(int operant1 , String operator, int operant2, int result) {

        int calculateResult = Calculator.enumcalculate(operant1, operator, operant2);

        assertThat(calculateResult).isEqualTo(result);
    }
    @DisplayName("뺄셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest2(int operant1 , String operator, int operant2, int result) {

        int calculateResult = Calculator.calculate(operant1, operator, operant2);

        assertThat(calculateResult).isEqualTo(result);
    }
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculatorExeceptionTest() {

        assertThatCode(() -> Calculator.calculate(10 , "/", 0) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌수 없습니다");

    }
    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }
}
