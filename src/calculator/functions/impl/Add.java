package calculator.functions.impl;

import calculator.exceptions.InvalidArgumentException;
import calculator.functions.Function;

public class Add implements Function {

	@Override
	public int evaluate(int[] args) {
		if (args.length < 2) {
			throw new InvalidArgumentException("Function 'add' requires at least 2 arguments");
		}
		int sum = 0;
		for(int i = 0; i < args.length; i++){
			sum += args[i];
		}
		return sum;
	}

}
