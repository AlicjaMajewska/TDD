package fizzbuzz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class FizzBuzzTest {

    @Test
    void shouldReturnOneFor_1() {
        // given
        List<Integer> input = IntStream.of(1).boxed().collect(Collectors.toList());

        // when
        List<String> result = FizzBuzzGame.create().play(input);

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    void shouldReturnOneTwoFor_1_2() {
        // given
        List<Integer> input = IntStream.of(1, 2).boxed().collect(Collectors.toList());

        // when
        List<String> result = FizzBuzzGame.create().play(input);

        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void shouldReturnOneTwo___FizzFor_1_5() {
        // given
        List<Integer> input = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());

        // when
        List<String> result = FizzBuzzGame.create().play(input);

        // then
        assertThat(result).containsExactly("1", "2", "3", "4", "fizz");
    }

    @Test
    void shouldContainFizzAndBuzzFor_1_7() {
        // given
        List<Integer> input = IntStream.rangeClosed(1, 7).boxed().collect(Collectors.toList());

        // when
        List<String> result = FizzBuzzGame.create().play(input);

        // then
        assertThat(result).containsExactly("1", "2", "3", "4", "fizz", "6", "buzz");
    }

    @Test
    void shouldContain_6_Fizz_4_Buzz_1_FizzBuzz_For_1_35() {
        // given
        List<Integer> input = IntStream.rangeClosed(1, 35).boxed().collect(Collectors.toList());

        // when
        List<String> result = FizzBuzzGame.create().play(input);

        // then
        assertThat(result).filteredOn(s -> s.equals("fizz")).hasSize(6);
        assertThat(result).filteredOn(s -> s.equals("buzz")).hasSize(4);
        assertThat(result).filteredOn(s -> s.equals("fizzbuzz")).hasSize(1);
    }

    @Test
    void shouldSkipNullNumbersInInput() {
        // given
        final List<Integer> input = Arrays.asList(2, 3, null);

        // when
        List<String> result = FizzBuzzGame.create().play(input);

        // then
        assertThat(result).containsExactly("2", "3");
    }

    @Test
    void shouldThrowNullPointerExceptionWithMessageWhenNullInput() {
        // given
        final List<Integer> input = null;

        // when
        final Throwable thrown = catchThrowable(() -> FizzBuzzGame.create().play(input));

        // then
        assertThat(thrown).isInstanceOf(NullPointerException.class)
                          .hasNoCause()
                          .hasMessage("Received null input for FizzBuzzGame");
    }
}
