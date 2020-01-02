package romannumerals.generic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RomanNumeralGroupsTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII",
            "8, VIII",
            "9, IX",
    })
    void should_convert_up_to_ten(int number, String expected) {
        assertThat(RomanNumeralGroups.UP_TO_TEN.romanDigit(number)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "10, X",
            "20, XX",
            "30, XXX",
            "40, XL",
            "50, L",
            "60, LX",
            "70, LXX",
            "80, LXXX",
            "90, XC",
    })
    void should_convert_up_to_hundred(int number, String expected) {
        assertThat(RomanNumeralGroups.UP_TO_HUNDRED.romanDigit(number / 10)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "100, C",
            "200, CC",
            "300, CCC",
            "400, CD",
            "500, D",
            "600, DC",
            "700, DCC",
            "800, DCCC",
            "900, CM",
    })
    void should_convert_up_to_thousand(int number, String expected) {
        assertThat(RomanNumeralGroups.UP_TO_THOUSAND.romanDigit(number / 100)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "should throw IllegalArgException when {0}")
    @ValueSource(ints = {-1, 10, Integer.MIN_VALUE, Integer.MAX_VALUE})
    void should_throw_when_argument_is_not_a_digit(int arg) {
        assertThat(catchThrowable(() -> RomanNumeralGroups.UP_TO_THOUSAND.romanDigit(arg)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Digit " + arg + " is not a correct digit!");

    }
}