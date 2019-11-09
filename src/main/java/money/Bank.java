package money;


import java.util.HashMap;
import java.util.Map;

class Bank {

    private Map<Pair, Integer> rates = new HashMap<>();

    static Bank create() {
        return new Bank();
    }

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    void addRate(String from, String to, int rate) {
        rates.put(Pair.of(from, to), rate);
    }

    int rate(String rate, String to) {
        if (rate.equals(to)) {
            return 1;
        }
        return rates.get(Pair.of(rate, to));
    }
}
