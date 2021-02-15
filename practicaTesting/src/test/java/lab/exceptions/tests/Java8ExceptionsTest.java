package lab.exceptions.tests;

import org.junit.Test;
import static lab.exceptions.tests.java8.ThrowableAssertion.assertThrown;

public class Java8ExceptionsTest {


    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new DummyClass()::someMethod).// method reference
                // assertions:
                isInstanceOf(RuntimeException.class).
                hasMessage("Runtime exception occurred").
                hasNoCause();
    }

    /**
     * Use of lambda expression
     */
    @Test
    public void verifyCauseType() {
        assertThrown(
                () -> new DummyClass().someOtherMethod(true))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseInstanceOf(IllegalStateException.class);
    }
}
