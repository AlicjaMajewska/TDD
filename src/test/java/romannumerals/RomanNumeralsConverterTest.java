package romannumerals;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RomanNumeralsConverterTest {


    private RomanNumeralsConverter converter;

    @BeforeEach
    void setUp() {
        converter = new RomanNumeralsConverter();
    }

    @Test
    void should_generate_1_to_I() {
        // given
        int number = 1;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("I");
    }

    @Test
    void should_generate_2_to_II() {
        // given
        int number = 2;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("II");
    }

    @Test
    void should_generate_3_to_III() {
        // given
        int number = 3;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("III");
    }

    @Test
    void should_generate_4_to_IV() {
        // given
        int number = 4;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("IV");
    }

    @Test
    void should_generate_5_to_V() {
        // given
        int number = 5;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("V");
    }

    @Test
    void should_generate_6_to_VI() {
        // given
        int number = 6;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("VI");
    }


    @Test
    void should_generate_8_to_VIII() {
        // given
        int number = 8;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("VIII");
    }

    @Test
    void should_generate_9_to_IX() {
        // given
        int number = 9;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("IX");
    }

    @Test
    void should_generate_10_to_X() {
        // given
        int number = 10;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("X");
    }


    @Test
    void should_generate_11_to_XI() {
        // given
        int number = 11;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("XI");
    }

    @Test
    void should_generate_19_to_XIX() {
        // given
        int number = 19;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("XIX");
    }

    @Test
    void should_generate_21_to_XXI() {
        // given
        int number = 21;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("XXI");
    }

    @Test
    void should_generate_39_to_XXXIX() {
        // given
        int number = 39;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("XXXIX");
    }


    @Test
    void should_generate_40_to_XL() {
        // given
        int number = 40;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("XL");
    }

    @Test
    void should_generate_49_to_XLIX() {
        // given
        int number = 49;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("XLIX");
    }

    @Test
    void should_generate_50_to_L() {
        // given
        int number = 50;

        // when
        RomanNumeral romanNumeral = converter.toRoman(number);

        // then
        assertThat(romanNumeral.value()).isEqualTo("L");
    }

}