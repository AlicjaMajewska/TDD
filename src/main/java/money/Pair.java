package money;

import java.util.Objects;

final class Pair {
    
    private final Currency first;
    private final Currency second;

    private Pair(Currency first, Currency second) {
        this.first = first;
        this.second = second;
    }

    static Pair of(Currency first, Currency second) {
        return new Pair(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
