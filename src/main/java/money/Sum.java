package money;

class Sum implements Expression {

    private Money augend;
    private Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(String to) {
        return new Money(augend.amount + addend.amount, to);
    }
}
