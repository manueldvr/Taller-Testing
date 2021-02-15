package lab.exceptions.tests;

public class DummyClassTwo {

    public static final String CONSTRUCTOR_EXCEPTION_OCCURRED = "Constructor exception occurred";


    public void DummyClassTwo() throws Exception {
        throw new Exception(CONSTRUCTOR_EXCEPTION_OCCURRED);
    }

    public void DummyClassTwo(boolean dummyParam) throws Exception {
        throw new Exception(CONSTRUCTOR_EXCEPTION_OCCURRED);
    }
}
