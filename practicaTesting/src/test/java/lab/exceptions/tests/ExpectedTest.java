package lab.exceptions.tests;

import org.junit.Test;

public class ExpectedTest {

    private Thrower thrower = new Thrower();


    @Test(expected = MyRuntimeException.class)
    public void throwsException() { // will pass
        thrower.throwsRuntime();
        System.out.println("I am here!"); // never gets executed
    }

    @Test(expected = MyCheckedException.class) // will fail
    public void throwsDifferentExceptionThanExpected() throws MyCheckedException {
        thrower.throwsRuntimeInsteadOfChecked();
    }

    @Test(expected = MyRuntimeException.class)
    public void noExceptionThrown() { // will fail
    }

    @Test(expected = RuntimeException.class)
    public void misleading() { // will pass
        thrower.throwsRuntime(); // assume this is an unexpected exception
        throw new RuntimeException(); // never executed!
    }
}
