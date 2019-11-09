package money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static money.Currency.DOLLAR;
import static money.Currency.FRANC;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void testMultiplication() {
        // given
        final Money dollar = Money.dollar(5);

        assertThat(dollar.times(2)).isEqualTo(Money.dollar(10));
        assertThat(dollar.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    void testEquality() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(6)).isNotEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.franc(5));
        assertThat(Money.dollar(6)).isNotEqualTo(null);
    }

    @Test
    void testAddingSameCurrencies() {
        // given
        Expression expression = Money.dollar(5).plus(Money.dollar(5));

        // when
        Money reduced = Bank.create().reduce(expression, DOLLAR);

        // then
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    @DisplayName("5$ + 10 CHF = 0 $ -> rate 2:1")
    void testAddingDifferentCurrencies() {
        // given
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(5);
        Bank bank = Bank.create();
        bank.addRate(FRANC, DOLLAR, 2);

        // when
        Money reduced = bank.reduce(franc.plus(dollar), DOLLAR);

        // then
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    void testSumTimes() {
        // given
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(5);
        Bank bank = Bank.create();
        bank.addRate(FRANC, DOLLAR, 2);

        // when
        Money reduced = bank.reduce(franc.plus(dollar).times(2), DOLLAR);

        // then
        assertThat(reduced).isEqualTo(Money.dollar(20));
    }

    @Test
    void testConversion() {
        // given
        Money dollar = Money.dollar(5);

        // when
        Money reduced = Bank.create().reduce(dollar, DOLLAR);

        // then
        assertThat(reduced).isEqualTo(Money.dollar(5));
    }

    @Test
    void testConversionToOtherCurrency() {
        // given
        Bank bank = Bank.create();
        bank.addRate(FRANC, DOLLAR, 2);

        // when
        Money reduced = bank.reduce(Money.franc(10), DOLLAR);

        // then
        assertThat(reduced).isEqualTo(Money.dollar(5));
    }

    @Test
    @DisplayName("10$ - 5$ = 5$")
    void testSubtractionOfSameCurrencies() {
        // given
        final Money dollars10 = Money.dollar(10);
        final Money dollars5 = Money.dollar(5);
        final Bank bank = Bank.create();

        // when
        final Money result = bank.reduce(dollars10.minus(dollars5), DOLLAR);

        // then
        assertThat(result).isEqualTo(Money.dollar(5));
    }
}
