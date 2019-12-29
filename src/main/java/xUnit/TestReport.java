package xUnit;

import java.util.*;
import java.util.stream.Collectors;

class TestReport {

    private StringBuilder builder = new StringBuilder();

    private Map<Class<? extends TestCase>, Integer> runTests = new HashMap<>();
    private Map<Class<? extends TestCase>, List<String>> failures = new HashMap<>();

    void append(String value) {
        builder.append(value).append(System.lineSeparator());
    }

    void addRunTest(Class<? extends TestCase> runClass) {
        Integer counter = runTests.getOrDefault(runClass, 0);
        runTests.put(runClass, counter + 1);

    }

    void addFailure(Class<? extends TestCase> failedClass, String exceptionMessage) {
        List<String> failuresInClass = failures.getOrDefault(failedClass, new ArrayList<>());
        failuresInClass.add(exceptionMessage);
        failures.put(failedClass, failuresInClass);
    }


    String report() {
        addSummary();
        return addSummary() + builder.toString();
    }

    private String addSummary() {

        StringBuilder summary = new StringBuilder();

        int allRunTests = 0;
        int allFailedTest = 0;
        for (Class<? extends TestCase> runClass : runTests.keySet()) {
            Integer runTestInAClass = runTests.get(runClass);
            allRunTests += runTestInAClass;

            List<String> failedTestInAClass = failures.getOrDefault(runClass, Collections.emptyList());
            allFailedTest += failedTestInAClass.size();

            summary.append(runClass.getSimpleName())
                    .append(" Run - ").append(runTestInAClass)
                    .append(" Failed - ").append(failedTestInAClass.size())
                    .append(System.lineSeparator());

            String collectedErrors = failedTestInAClass.stream().collect(Collectors.joining(System.lineSeparator(), System.lineSeparator(), System.lineSeparator()));
            if (!collectedErrors.isBlank()) {
                summary.append(collectedErrors);
            }

        }
        summary.append("All run tests - ").append(allRunTests)
                .append(". All failed tests - ").append(allFailedTest)
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        return summary.toString();
    }
}
