package lab.exceptions.tests;

import org.junit.Assert;
import org.junit.Test;
//import static org.assertj.core.api.Assertions.assertThat;

public class ThrowerTest {

    private Thrower thrower = new Thrower();

    /** Standard test with try-catch idiom.
     *  This test will fail when no exception is thrown and the exception
     *  itself is verified in a catch clause.
     *  Drawbacks:
     *  1- extra code needs to be created; we always need to remember to fail the test if no exception is thrown.
     *  2- if other than expected exception is thrown the test will fail but not with the assertion error as we would expect
     */
    @Test
    public void throwException(){
        try {
            thrower.throwsRuntime();
            Assert.fail("Expected exception to be thrown");
        } catch (MyRuntimeException e) {
           //Sys
            System.out.println("");
            Assert.assertEquals("My custom runtime exception",e.getMessage());
        }
    }

    /**
     * case 2 of above
     */
    @Test
    public void throwsDifferentExceptionThanExpected() {
        try {
            thrower.throwsRuntimeInsteadOfChecked();
            Assert.fail("Expected exception to be thrown");
        } catch (MyCheckedException e) {
            System.out.println("");
            Assert.assertEquals("My custom runtime exception",e.getMessage());
        }
    }

}
