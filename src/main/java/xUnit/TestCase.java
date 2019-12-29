package xUnit;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

class TestCase {

    private TestReport testReport;

    TestCase(TestReport testReport) {
        this.testReport = testReport;
    }

    void run() {
        invokeMethodsWithAnnotation(Test.class, this::invokeTestMethodWithSetUpAndTearDown);
        System.out.println(testReport.report());
    }

    private void invokeTestMethodWithSetUpAndTearDown(Method testMethod) {
        invokeSetUp(testMethod);
        invokeTestMethod(testMethod);
        invokeTearDown(testMethod);
    }

    private void invokeTestMethod(Method testMethod) {
        testReport.append("Run " + testMethod.getName() + ".");
        try {
            testReport.addRunTest(this.getClass());
            invokeMethod(testMethod);
        } catch (Exception e) {
            testReport.addFailure(this.getClass(), testMethod.getName() + " " + e.getLocalizedMessage());
            System.out.println(e);
        }
    }

    private void invokeMethod(Method method) {
        try {
            method.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeSetUp(Method testMethod) {
        testReport.append("Set up " + testMethod.getName() + ".");
        invokeMethodsWithAnnotation(SetUp.class, this::invokeMethod);
    }

    private void invokeTearDown(Method testMethod) {
        testReport.append("Tear down " + testMethod.getName() + ".");
        invokeMethodsWithAnnotation(TearDown.class, this::invokeMethod);
    }

    private <T extends Annotation> void invokeMethodsWithAnnotation(Class<T> annotation, Consumer<Method> methodToInvoke) {
        Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(methodHasAnnotation(annotation))
                .forEach(methodToInvoke);
    }

    private <T extends Annotation> Predicate<Method> methodHasAnnotation(Class<T> annotation) {
        return m -> m.getAnnotation(annotation) != null;
    }

    String testReport() {
        return testReport.report();
    }

}
