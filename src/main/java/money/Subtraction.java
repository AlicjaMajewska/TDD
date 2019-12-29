package money;

class Subtraction implements Expression {

    private final Expression minuend;
    private final Expression subtrahend;

    Subtraction(Expression minuend, Expression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public Money reduce(Bank bank, Currency to) {
        return new Money(minuend.reduce(bank, to).amount() - subtrahend.reduce(bank, to).amount(), to);
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }

    @Override
    public Expression times(int multiplier) {
        return null;
    }

    // TODO dodać Subtraction do interfejsu expression
}
