package romannumerals.generic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RomanNumeralsGenericTest {

    @Test
    void should_convert_from_one_digit_number() {
        assertThat(RomanNumeralsGeneric.from(1).value()).isEqualTo("I");
    }

    @Test
    void should_convert_from_two_digits_number() {
        assertThat(RomanNumeralsGeneric.from(12).value()).isEqualTo("XII");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1000})
    void should_throw_when_value_not_in_supported_range(int number) {
        assertThat(catchThrowable(() -> RomanNumeralsGeneric.from(number)))
                .hasMessage(number + " is not in supported range 0 - 999")
                .isInstanceOf(IllegalArgumentException.class);
    }

}
