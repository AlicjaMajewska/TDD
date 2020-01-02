package romannumerals.generic;

import romannumerals.RomanNumeral;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static romannumerals.generic.RomanNumeralValues.M;

class RomanNumeralsGeneric implements RomanNumeral {

    private final Map<Integer, String> values = new HashMap<>();

    private final int MAX_SUPPORTED_NUMBER = M.value() - 1;

    static RomanNumeral from(int i) {
        return new RomanNumeralsGeneric().convert(i);
    }

    @Override
    public RomanNumeral convert(int number) {
        if (number < 0 || number > MAX_SUPPORTED_NUMBER) {
            throw new IllegalArgumentException(number + " is not in supported range 0 - 999");
        }
        Arrays.stream(RomanNumeralGroups.values())
                .forEach(group -> values.put(group.decimalPosition(), group.romanDigit(getNthDigit(number, group.decimalPosition()))));
        return this;
    }

    private int getNthDigit(int number, int position) {
        return (int) ((number / Math.pow(10, position - 1)) % 10);
    }

    @Override
    public String value() {
        return values.keySet().stream().sorted(Comparator.reverseOrder()).map(values::get).collect(Collectors.joining());
    }

}
