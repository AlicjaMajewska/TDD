package romannumerals;

import static romannumerals.RomanNumeralValues.*;

class RomanNumeral {

    private String value;

    private RomanNumeral(String value) {
        this.value = value;
    }

    /**
     * max number is 500
     */
    static RomanNumeral from(int number) {

        if (number >= L.value()) {
            return new RomanNumeral(L.name() + upToForthyNine(number % L.value()).value());
        }
        return upToForthyNine(number);

    }

    private static RomanNumeral upToForthyNine(int number) {
        if (number >= L.value() - X.value()) {
            return new RomanNumeral(X.name() + L.name() + upToNine(number % X.value()).value());
        }

        if (number >= X.value()) {
            return new RomanNumeral(X.name().repeat(number / X.value()) + upToNine(number % X.value()).value());
        }
        return upToNine(number);
    }

    private static RomanNumeral upToNine(int number) {
        if (number == X.value() - I.value()) {
            return new RomanNumeral(I.name() + X.name());
        }

        if (number >= V.value()) {
            return new RomanNumeral(V.name() + upToThree(number));
        }
        if (number == V.value() - I.value()) {
            return new RomanNumeral(I.name() + V.name());
        } else {
            return new RomanNumeral(upToThree(number));
        }
    }

    private static String upToThree(int number) {
        return I.name().repeat(number % V.value());
    }


    String value() {
        return value;
    }

}
