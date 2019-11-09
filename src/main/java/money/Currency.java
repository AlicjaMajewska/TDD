package money;

enum Currency {

    FRANC("CHF"), DOLLAR("USD");

    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    String symbol() {
        return symbol;
    }
}
