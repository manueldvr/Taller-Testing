package lab.exceptions.tests;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.startsWith;

/**
 * Introducing ExpectedException rule
 *
 * In JUnit, rule (@Rule) can be used as an alternative or an additional to fixture setup and cleanup methods.
 * ExpectedException rule is a meant for verification that a cade throws a specific exception. The rule must be
 * declared as public field annotated with @Rule annotation.
 */
public class Junit4RuleEsceptionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private  Thrower thrower = new Thrower();


    @Test
    public void verifiesTypeAndMessage() {
        thrown.expect(MyRuntimeException.class);
        thrown.expectMessage("My custom runtime exception");
        thrower.throwsRuntime();
    }

    @Test
    public void throwsDifferentExceptionThanExpected() throws MyCheckedException {
        thrown.expect(MyCheckedException.class);
        thrown.expectMessage("Expected exception to be thrown");
        thrower.throwsRuntimeInsteadOfChecked();
    }

    @Test
    public void doesNotThrowExpectedException() {
        thrown.expect(MyRuntimeException.class);
    }


    @Test
    public void verifiesMessageStartsWith() {
        thrown.expect(RuntimeException.class);
        thrown.expectMessage(startsWith("My custom runtime"));

        thrower.throwsRuntime();
    }


    /**
     * We can verify the cause with a custom Hamcrest matchers
     *
     *  usually used built-in matchers as they provide most of the basic and more advanced matchers.
     *  Custom matchers can be used for some special cases like for example verifying more complex exception
     *  objects with come custom fields etc.
     */
    @Test
    public void verifiesCauseTypeAndAMessage() {
        thrown.expect(RuntimeException.class);
        thrown.expectCause(new MyCauseMatcher(IllegalStateException.class, "Illegal state"));

        thrower.throwsRuntimeWithCause();
    }

    private class MyCauseMatcher implements Matcher {
        public MyCauseMatcher(Class<IllegalStateException> illegalStateExceptionClass, String illegal_state) {
        }

        @Override
        public boolean matches(Object item) {
            return false;
        }

        @Override
        public void describeMismatch(Object item, Description mismatchDescription) {

        }

        @Override
        public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

        }

        @Override
        public void describeTo(Description description) {

        }
    }
}
