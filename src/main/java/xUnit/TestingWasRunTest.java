package xUnit;

class TestingWasRunTest implements TestingTests {

    @Override
    public void test() {

        WasRunTest wasRunTest = new WasRunTest(TestFactory.INSTANCE.testReport());

        wasRunTest.run();

        assert wasRunTest.testWasRun;
        assert wasRunTest.setUpWasRun;
        assert wasRunTest.tearDownWasRun;
    }

}
