package calculator.functions.impl;

import calculator.exceptions.InvalidArgumentException;
import calculator.functions.Function;

public class Multiply implements Function {

	@Override
	public int evaluate(int[] args) {
		if (args.length < 2) {
			throw new InvalidArgumentException("Function'multiply' requires at least 2 arguments");
		}
		int product = args[0];
		for(int i = 1; i < args.length; i++){
			product *= args[i];
		}
		return product;
	}

}
