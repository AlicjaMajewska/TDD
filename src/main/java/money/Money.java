package money;

class Money implements Expression {

    int amount;
    private String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Money) {
            final Money that = (Money) obj;
            return this.amount == that.amount && this.currency.equals(that.currency);
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);

        return new Money(amount / rate, to);
    }
}
