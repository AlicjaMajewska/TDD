package fizzbuzz;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class FizzBuzzGame {

    static FizzBuzzGame create() {
        return new FizzBuzzGame();
    }

    List<String> play(List<Integer> input) {
        Objects.requireNonNull(input, "Received null input for FizzBuzzGame");

        return input.stream()
                .filter(Objects::nonNull)
                .map(this::response)
                .collect(Collectors.toList());
    }

    private String response(Integer number) {
        if (number % 35 == 0 ) {
            return "fizzbuzz";
        }
        if (number % 5 == 0) {
            return "fizz";
        }
        if (number % 7 == 0) {
            return "buzz";
        }
        return number.toString();
    }
}
