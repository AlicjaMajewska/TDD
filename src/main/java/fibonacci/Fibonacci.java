package fibonacci;

class Fibonacci {

    static int of(int i) {
        if (i == 0) { return 0; }
        if (i == 1) { return 1; }
        return of(i - 1) + of(i - 2);
    }
}
