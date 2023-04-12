package org.example.enumcalculator;

import java.util.Arrays;

public enum ArithmticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalcuator(int operand1, int operand2) {
            return operand1 + operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalcuator(int operand1, int operand2) {
            return operand1 / operand2;
        }
    }, MULTIPLTION("*"){
        @Override
        public int arithmeticCalcuator(int operand1, int operand2) {
            return operand1 * operand2;
        }
    }, SUBTRTION("-") {
        @Override
        public int arithmeticCalcuator(int operand1, int operand2) {
            return operand1 - operand2;
        }
    };

    private final String operator;

    ArithmticOperator(String operator) {
        this.operator = operator;
    }

    public static int calculate(int operant, String operator, int operant2) {
        ArithmticOperator arithmticOperator = Arrays.stream(values())
                .filter(v -> v.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmticOperator.arithmeticCalcuator(operant, operant2);
    }

    public abstract int arithmeticCalcuator(final int operand1, final int operand2);
}
