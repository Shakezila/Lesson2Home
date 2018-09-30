
public class Operation {

	public double doPlus(double x, double y) {
		double result = x + y;
		return result;
	}

	public double doMinus(double x, double y) {
		double result = x - y;
		return result;
	}

	public double doMultiply(double x, double y) {
		double result = x * y;
		return result;
	}

	public double doDevision(double x, double y) {
		double result = x / y;
		return result;
	}

	public void findMinMax(double[] array) {
		double minVal = array[0];
		double maxVal = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < minVal) {
				minVal = array[i];
			}
			if (array[i] > maxVal) {
				maxVal = array[i];
			}
		}
		System.out.printf("Min value = %.2f Max value = %.2f\n\n", minVal, maxVal);
	}

}
