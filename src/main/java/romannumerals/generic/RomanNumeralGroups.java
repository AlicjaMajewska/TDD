package romannumerals.generic;

import static romannumerals.generic.RomanNumeralValues.*;

enum RomanNumeralGroups {

    UP_TO_TEN(I, V, X),
    UP_TO_HUNDRED(X, L, C),
    UP_TO_THOUSAND(C, D, M);

    private RomanNumeralValues increment;
    private RomanNumeralValues half;
    private RomanNumeralValues max;

    RomanNumeralGroups(RomanNumeralValues increment, RomanNumeralValues half, RomanNumeralValues max) {
        this.increment = increment;
        this.half = half;
        this.max = max;
    }

    String romanDigit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("Digit " + digit + " is not a correct digit!");
        }

        if (digit < 4) {
            return increment.name().repeat(digit);
        }
        if (digit == 4) {
            return increment.name() + half.name();
        }
        if (digit < 9) {
            return half.name() + increment.name().repeat(digit % 5);
        }
        // digit == 9
        return increment.name() + max.name();
    }

    int decimalPosition() {
        return (int) Math.log10(max.value());
    }

}
