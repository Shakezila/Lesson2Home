
public class Helper {

	static int getArraySize(String line) {
		int size = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ' ' || line.charAt(i) == '-' || line.charAt(i) == '+' || line.charAt(i) == '*'
					|| line.charAt(i) == '/') {
				size++;
			}
		}
		return size;
	}

	static void setArrayFromLine(double[] array, String line) {
		int counter = 0;
		for (int j = 0; j < array.length; j++) {
			String partLine = "";
			for (int i = counter; i < line.length(); i++) {
				if (StringValidator.checkVariable(Character.toString(line.charAt(counter)))) {
					partLine += line.charAt(i);
					counter++;
				} else if (counter == line.length() && line.charAt(counter) != '=') {
					array[j] = Double.parseDouble(partLine);
					break;
				} else {
					array[j] = Double.parseDouble(partLine);
					counter++;
					break;
				}
			}
		}
	}

	static String collectSign(String string) {
		String signs = "";
		for(int i = 0; i < string.length();i++ ) {
			if(StringValidator.checkSign(Character.toString(string.charAt(i)))){
				signs+=Character.toString(string.charAt(i));
			}
		}
		return signs;
	}
	
	static void printResult(double result) {
		System.out.printf("result: %.2f%n", result);
	}

	static void printAlert() {
		System.out.println("You entered invalid expession!");
	}
}
