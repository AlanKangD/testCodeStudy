package org.example;

import org.example.calculator.*;
import org.example.enumcalculator.ArithmticOperator;

import java.util.List;

public class Calculator {
    private static final List<NewArithmticOperator> artithmeticOperators
            = List.of(new AdditionOperator(), new DivisionOperator(), new SubtractionOperator(), new MultiplationOperator());

    public static int enumcalculate(int operant, String operator, int operant2) {
        return ArithmticOperator.calculate(operant , operator, operant2);
    }
    public static int calculate(int operant, String operator, int operant2) {
        return artithmeticOperators.stream()
                .filter(artithmeticOperators -> artithmeticOperators.support(operator))
                .map(artithmeticOperators -> artithmeticOperators.calculate(operant, operant2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
