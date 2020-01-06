package fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FibonacciTest {

    // 0 1 1 2 3 5 ...

    @Test
    void should_return_0_for_0() {
        assertThat(Fibonacci.of(0)).isEqualTo(0);
    }

    @Test
    void should_return_1_for_1() {
        assertThat(Fibonacci.of(1)).isEqualTo(1);
    }

    @Test
    void should_return_1_for_2() {
        assertThat(Fibonacci.of(2)).isEqualTo(1);
    }

    @Test
    void should_return_2_for_3() {
        assertThat(Fibonacci.of(3)).isEqualTo(2);
    }

    @Test
    void should_return_3_for_4() {
        assertThat(Fibonacci.of(4)).isEqualTo(3);
    }
}
