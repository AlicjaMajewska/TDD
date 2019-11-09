package money;

import java.util.Objects;

final class Pair {
    final String first;
    final String second;

    private Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    static Pair of(String first, String second) {
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
