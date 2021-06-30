package calculator;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Invalid arguments");
			return;
		}
		String expression = args[0];
		Calculator calculator = new Calculator();
		try {
		String result = calculator.evaluate(expression);
		System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
