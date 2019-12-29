package xUnit;

enum TestFactory {

    INSTANCE;

    private TestReport testReport = new TestReport();

    TestReport testReport() {
        return testReport;
    }
}
