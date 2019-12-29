package xUnit;


class WasRunTest extends TestCase {

    boolean testWasRun = false;
    boolean setUpWasRun = false;
    boolean tearDownWasRun = false;

    public WasRunTest(TestReport testReport) {
        super(testReport);
    }


    @TearDown
    void tearDown() {
        tearDownWasRun = true;
    }

    @SetUp
    void setUp() {
        setUpWasRun = true;
    }

    @Test
    void test() {
        testWasRun = true;
    }

}
