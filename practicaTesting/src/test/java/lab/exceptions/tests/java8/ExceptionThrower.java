package lab.exceptions.tests.java8;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}
