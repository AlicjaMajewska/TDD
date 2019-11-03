package money;


class Bank {

    static Bank create() {
        return new Bank();
    }

    Money reduce(Expression source, String to) {
        return source.reduce(to);
    }
}
