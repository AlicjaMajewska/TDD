package romannumerals.incremental;

import romannumerals.RomanNumeral;

import static romannumerals.incremental.RomanNumeralValues.*;


class RomanNumeralIncremental implements RomanNumeral {

    private String value;

    /**
     * max number is 500
     */
    static RomanNumeral from(int number) {
        return new RomanNumeralIncremental("").convert(number);
    }

    @Override
    public RomanNumeral convert(int number) {

        if (number >= L.value()) {
            return new RomanNumeralIncremental(L.name() + RomanNumeralIncremental.upToForthyNine(number % L.value()).value());
        }
        return RomanNumeralIncremental.upToForthyNine(number);
    }


    private RomanNumeralIncremental(String value) {
        this.value = value;
    }

    private static RomanNumeral upToForthyNine(int number) {
        if (number >= L.value() - X.value()) {
            return new RomanNumeralIncremental(X.name() + L.name() + upToNine(number % X.value()).value());
        }

        if (number >= X.value()) {
            return new RomanNumeralIncremental(X.name().repeat(number / X.value()) + upToNine(number % X.value()).value());
        }
        return upToNine(number);
    }

    private static RomanNumeral upToNine(int number) {
        if (number == X.value() - I.value()) {
            return new RomanNumeralIncremental(I.name() + X.name());
        }

        if (number >= V.value()) {
            return new RomanNumeralIncremental(V.name() + upToThree(number));
        }
        if (number == V.value() - I.value()) {
            return new RomanNumeralIncremental(I.name() + V.name());
        } else {
            return new RomanNumeralIncremental(upToThree(number));
        }
    }

    private static String upToThree(int number) {
        return I.name().repeat(number % V.value());
    }


    @Override
    public String value() {
        return value;
    }

}
