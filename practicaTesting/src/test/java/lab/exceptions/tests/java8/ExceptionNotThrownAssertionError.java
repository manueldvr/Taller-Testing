package lab.exceptions.tests.java8;

public class ExceptionNotThrownAssertionError extends AssertionError {

    public static final String EXPECTED_EXCEPTION_WASNT_FOUND = "Expected exception was not found";

    public ExceptionNotThrownAssertionError() {
        super(EXPECTED_EXCEPTION_WASNT_FOUND);
    }
}
