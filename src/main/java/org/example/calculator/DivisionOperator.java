package org.example.calculator;

public class DivisionOperator implements NewArithmticOperator {
    @Override
    public Boolean support(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(int operand1, int operand2) {
        if(operand1 == 0 || operand2 == 0) {
            throw new IllegalArgumentException("0으로서는 나눌수 없습니다!");
        }
        return operand1 / operand2;
    }
}
