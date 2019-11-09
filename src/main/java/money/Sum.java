package money;

class Sum implements Expression {

    private final Expression augend;
    private final Expression addend;

    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Bank bank, Currency to) {
        return new Money(augend.reduce(bank, to).amount() + addend.reduce(bank, to).amount(), to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}

