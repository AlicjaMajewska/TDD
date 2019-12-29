package xUnit;

import java.util.List;

class Main {

    public static void main(String[] args) {
        List.of(
                new TestingWasRunTest(),
                new TestingReportTest(),
                new TestingReportTestWithThrowingMethod()
        ).forEach(TestingTests::test);

    }
}
