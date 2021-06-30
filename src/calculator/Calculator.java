package calculator;

import java.util.Arrays;
import java.util.HashMap;

import calculator.exceptions.FunctionNotFoundException;
import calculator.exceptions.InvalidArgumentException;
import calculator.exceptions.InvalidFormatException;
import calculator.functions.Function;
import calculator.functions.impl.Add;
import calculator.functions.impl.Multiply;

public class Calculator {

	private HashMap<String, Function> functions = new HashMap<>() {{
		put("add", new Add());
		put("multiply", new Multiply());
	}};
	
	public void addFunction(String name, Function function) {
		functions.put(name, function);
	}
	
	public String evaluate(String expression) {
		return simplify(expression);
	}
	
	private String simplify(String expression) {
		if (Utils.isInteger(expression)) {
			return expression;
		}
		
		int startingPos = expression.lastIndexOf('(');
		if (startingPos < 0) {
			throw new InvalidFormatException("Opening '(' is missing");
		}
		int endingPos = expression.indexOf(')', startingPos);
		if (endingPos < 0) {
			throw new InvalidFormatException("Enclosing ')' is missing");
		}
		String token = expression.substring(startingPos+1, endingPos);
		
		int result = evaluateToken(token);
		
		expression = expression.substring(0, startingPos) + result + expression.substring(endingPos+1);
		
		return simplify(expression);
	}
	
	private int evaluateToken(String token) {
		String[] tokenComps = token.split(" ");
		if (tokenComps.length < 1) {
			throw new InvalidFormatException("Expression function is missing");
		}
		String functionName = tokenComps[0];
		Function function = functions.get(functionName.toLowerCase());
		if (function == null) {
			throw new FunctionNotFoundException(functionName);
		}
		int[] args = new int[tokenComps.length-1];
		for (int i = 1; i < tokenComps.length; i++) {
			String arg = tokenComps[i];
			try {
				args[i-1] = Integer.parseInt(arg);
		    } catch (NumberFormatException e) {
		        throw new InvalidArgumentException("Invalid argument '" + arg + "'");
		    }
		}
		return function.evaluate(args);
	}
	
}
