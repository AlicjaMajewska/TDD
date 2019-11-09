package money;

import org.junit.jupiter.api.Test;

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
        Money reduced = Bank.create().reduce(expression, "USD");

        // then
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

//    5$ + 10 CHF = 0 $ -> rate 2:1
    @Test
    void testAddingDifferentCurrencies() {
        // given
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(5);
        Bank bank = Bank.create();
        bank.addRate("CHF", "USD", 2);

        // when
        Money reduced = bank.reduce(franc.plus(dollar), "USD");

        // then
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    void testSumTimes() {
        // given
        Expression franc = Money.franc(10);
        Expression dollar = Money.dollar(5);
        Bank bank = Bank.create();
        bank.addRate("CHF", "USD", 2);

        // when
        Money reduced = bank.reduce(franc.plus(dollar).times(2), "USD");

        // then
        assertThat(reduced).isEqualTo(Money.dollar(20));
    }

    @Test
    void testConversion() {
        Money reduced = Bank.create().reduce(Money.dollar(5), "USD");

        assertThat(reduced).isEqualTo(Money.dollar(5));
    }

    @Test
    void testConversionToOtherCurrency() {
        Bank bank = Bank.create();
        bank.addRate("CHF", "USD", 2);
        Money reduced = bank.reduce(Money.franc(10), "USD");
        assertThat(reduced).isEqualTo(Money.dollar(5));
    }
}
