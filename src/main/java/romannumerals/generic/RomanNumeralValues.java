package romannumerals.generic;


enum RomanNumeralValues {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private int value;

    RomanNumeralValues(int value) {
        this.value = value;
    }

    int value() {
        return value;
    }
}
