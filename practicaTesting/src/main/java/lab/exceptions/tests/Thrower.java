package lab.exceptions.tests;

public class Thrower {

    public void throwsRuntime() {
        throw new MyRuntimeException();
    }

    public void throwsRuntimeWithCause(){
        throw  new MyRuntimeException(new IllegalStateException("Illegal state"));
    }

    public void throwsRuntimeWithCode(int code){
        throw new MyRuntimeException(code);
    }

    public void throwsRuntimeInsteadOfChecked() throws MyCheckedException {
        throw new MyRuntimeException();
    }
}
