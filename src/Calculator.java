
public class Calculator {

	Operation operation = new Operation();
	Reader reader = new Reader();
	String expression;
	String numberOrder;
	String signs;
	double[] array;
	double[] dVariables;

	public String getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(String numberOrder) {
		this.numberOrder = numberOrder;
	}

	public double[] getArray() {
		return array;
	}

	public void createArray(int size) {
		this.array = new double[size];
	}

	public double[] getDVariables() {
		return dVariables;
	}

	public void createDVariables(int size) {
		this.dVariables = new double[size];
	}

	public String getDevisions() {
		return signs;
	}

	public void setDevisions(String devisions) {
		this.signs = devisions;
	}

	public void run() {
		boolean check = false;
		do {
			this.expression = reader.setExpression();
			this.expression.trim();
			check = StringValidator.expressionValidator(expression);
			if (check) {
				createArray(Helper.getArraySize(expression));
				this.signs = Helper.collectSign(expression);
				Helper.setArrayFromLine(this.array, expression);
				calculate(this.array, this.signs);
			} else {
				Helper.printAlert();
			}
		} while (!check);
	}

	private void calculate(double[] array, String signs) {
		double result = array[0];
		int counter = 1;
		for (int j = 0; j < signs.length(); j++) {
			for (int i = counter; i < array.length; i++) {
				if (signs.charAt(j) == '+') {
					result = operation.doPlus(result, array[i]);
					counter++;
					break;
				} else if (signs.charAt(j) == '-') {
					result = operation.doMinus(result, array[i]);
					counter++;
					break;
				} else if (signs.charAt(j) == '/') {
					result = operation.doDevision(result, array[i]);
					counter++;
					break;
				} else if (signs.charAt(j) == '*') {
					result = operation.doMultiply(result, array[i]);
					counter++;
					break;
				}
			}
		}
		Helper.printResult(result);
	}
}
