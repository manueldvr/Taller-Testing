package lab.exceptions.tests;

public class DummyClass {

    public static final String RUNTIME_EXCEPTION_OCCURED = "Runtime exception occurred";
    public static final String ILLEGAL_STATE = "Illegal state";


    public void someMethod() {
        throw new RuntimeException(RUNTIME_EXCEPTION_OCCURED);
    }

    public void  someOtherMethod(boolean bool) {
        throw new IllegalStateException(RUNTIME_EXCEPTION_OCCURED,
                new IllegalStateException(ILLEGAL_STATE));
    }
}
