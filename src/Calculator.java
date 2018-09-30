
public class Calculator {

	private Operation operation = new Operation();
	private Reader reader = new Reader();
	private String expression;
	private String numberOrder;
	private String signs;
	private double[] array;
	private double[] dVariables;

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

	public void quadraticEquation() {
		int a, b, c, D;
		double x1 = 0, x2 = 0;
		String parameter = "number";

		do {
			System.out.print("Enter the number: ");
			while (!reader.scanner.hasNextInt()) {
				reader.scanner.next();
				Helper.printNumberAllert();
			}
			a = reader.scanner.nextInt();
		} while (a < 0);

		b = reader.readeValue(parameter + " b");
		c = reader.readeValue(parameter + " c");

		D = (int) Math.pow(b, 2) - 4 * a * c;

		if (D > 0) {
			x1 = ((b * -1) + Math.sqrt(D)) / 2 * a;
			x2 = ((b * -1) - Math.sqrt(D)) / 2 * a;
		} else if (D == 0) {
			x1 = ((b * -1) + Math.sqrt(D)) / 2 * a;
			x2 = x1;
		} else if (D < 0) {
			System.out.println("This equartion doesn't have any roots!");
		}

		System.out.printf("x1 = %.2f, x2 = %.2f", x1, x2);
	}

	public void run() {
		boolean check = false;
		do {
			this.expression = reader.setExpression();
			this.expression.trim();
			check = StringValidator.expressionValidator(expression);
			if (check) {
				createDVariables(Helper.getArraySize(expression));
				this.signs = Helper.collectSign(expression);
				Helper.setArrayFromLine(this.dVariables, expression);
				calculate(this.dVariables, this.signs);
			} else {
				Helper.printAlert();
			}
		} while (!check);
	}

	public void findMinMax() {
		this.numberOrder = reader.setNumberLine();
		this.numberOrder.trim();
		createArray(Helper.getArraySize(numberOrder));
		Helper.setArrayFromLine(array, numberOrder);
		operation.findMinMax(array);
	}

	public void checkIntervals() {
		int n;
		int i1 = 0;
		int i2 = 0;
		int inCounter = 0;

		n = reader.readeValue("number");

		while (inCounter < 2) {
			System.out.print("Enter the interval: ");
			if (inCounter == 0) {
				while (!reader.scanner.hasNextInt()) {
					reader.scanner.next();
					Helper.printNumberAllert();
				}
				i1 = reader.scanner.nextInt();
				inCounter++;
			} else {
				while (!reader.scanner.hasNextInt()) {
					reader.scanner.next();
					Helper.printNumberAllert();
				}
				i2 = reader.scanner.nextInt();
				inCounter++;
			}
		}

		if (n > i1 && n < i2) {
			System.out.printf("%d belongs (%d,%d)\n", n, i1, i2);
		} else if (n >= i1 && n < i2) {
			System.out.printf("%d belongs [%d,%d)\n", n, i1, i2);
		} else if (n > i1 && n <= i2) {
			System.out.printf("%d belongs (%d,%d]\n", n, i1, i2);
		} else if (n >= i1 && n <= i2) {
			System.out.printf("%d belongs [%d,%d]\n", n, i1, i2);
		}
	}

	public void printMatrix() {
		int n, square;
		int i = 1;

		do {
			System.out.print("Enter the number: ");
			while (!reader.scanner.hasNextInt()) {
				reader.scanner.next();
				Helper.printNumberAllert();
			}
			n = reader.scanner.nextInt();
			break;
		} while (true);

		square = (int) Math.sqrt(n);

		while (i <= n) {
			System.out.printf("%5d ", i);
			if (i % square == 0) {
				System.out.println("");
			}
			i++;
		}
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
