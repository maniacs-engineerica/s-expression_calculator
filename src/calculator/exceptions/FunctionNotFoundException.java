package calculator.exceptions;

public class FunctionNotFoundException extends RuntimeException {
	
	public FunctionNotFoundException(String function) {
		super("Function '" + function + "' is not defined");
	}

}
