package romannumerals.generic;

import romannumerals.RomanNumeral;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static romannumerals.generic.RomanNumeralValues.M;

class RomanNumeralsGeneric implements RomanNumeral {

    private final int MAX_SUPPORTED_NUMBER = M.value() - 1;

    private final Map<Integer, String> values = new HashMap<>();
    private final int decimalNumber;

    private RomanNumeralsGeneric(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    static RomanNumeral from(int decimalNumber) {
        return new RomanNumeralsGeneric(decimalNumber).convert();
    }

    @Override
    public RomanNumeral convert() {
        if (decimalNumber < 0 || decimalNumber > MAX_SUPPORTED_NUMBER) {
            throw new IllegalArgumentException(decimalNumber + " is not in supported range 0 - 999");
        }
        Arrays.stream(RomanNumeralGroups.values())
                .forEach(group -> values.put(group.decimalPosition(), group.romanDigit(getNthDigit(group.decimalPosition()))));
        return this;
    }

    private int getNthDigit(int position) {
        return (int) ((decimalNumber / Math.pow(10, position - 1)) % 10);
    }

    @Override
    public String value() {
        return values.keySet().stream().sorted(Comparator.reverseOrder()).map(values::get).collect(Collectors.joining());
    }

}
