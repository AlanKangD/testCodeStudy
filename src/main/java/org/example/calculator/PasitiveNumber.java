package org.example.calculator;

public class PasitiveNumber {
    private final int value;


    public PasitiveNumber(int value) {
        valiate(value);
        this.value = value;
    }

    private void valiate(int value) {
        if(isNegertiveNumver(value)) {
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegertiveNumver(int value) {
        return value <= 0;
    }

    private int toInt(int value) {
        return value;
    }

    public int toInt() {
        return value;
    }
}
