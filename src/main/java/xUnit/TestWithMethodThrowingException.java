package xUnit;

class TestWithMethodThrowingException extends TestCase {

    TestWithMethodThrowingException(TestReport testReport) {
        super(testReport);
    }

    @SetUp
    void setUp() {
    }

    @Test
    void test1() {
    }

    @Test
    void test2() {
        throw new IllegalArgumentException("Wrong!");
    }

    @TearDown
    void tearDown() {
    }
}
