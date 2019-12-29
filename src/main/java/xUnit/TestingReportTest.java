package xUnit;

class TestingReportTest implements TestingTests {

    @Override
    public void test() {

        String summary = "TestReportTest Run - 2 Failed - 0" + System.lineSeparator() +
                "All run tests - 2. All failed tests - 0" + System.lineSeparator() + System.lineSeparator();
        String expectedReportForTest1 =
                "Set up test1." + System.lineSeparator() +
                        "Run test1." + System.lineSeparator() +
                        "Tear down test1." + System.lineSeparator();

        String expectedReportForTest2 =
                "Set up test2." + System.lineSeparator() +
                        "Run test2." + System.lineSeparator() +
                        "Tear down test2." + System.lineSeparator();

        TestCase test = new TestReportTest(new TestReport());

        test.run();

        assert test.testReport().contains(summary);
        assert test.testReport().contains(expectedReportForTest1);
        assert test.testReport().contains(expectedReportForTest2);
    }
}
