package money;


import java.util.HashMap;
import java.util.Map;

class Bank {

    private Map<Pair, Integer> rates = new HashMap<>();

    static Bank create() {
        return new Bank();
    }

    Money reduce(Expression source, Currency to) {
        return source.reduce(this, to);
    }

    void addRate(Currency from, Currency to, int rate) {
        rates.put(Pair.of(from, to), rate);
    }

    int rate(Currency rate, Currency to) {
        if (rate == to) {
            return 1;
        }
        return rates.get(Pair.of(rate, to));
    }
}
