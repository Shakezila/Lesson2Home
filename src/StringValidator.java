import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {

	static boolean checkExpression(String ex) {
		Pattern p = Pattern.compile("^[0-9*-/=]{4,1000}$");
		Matcher m = p.matcher(ex);
		return m.matches();
	}

	static boolean checkNumberLine(String line) {
		Pattern p = Pattern.compile("^[0-9 ]{1,100}$");
		Matcher m = p.matcher(line);
		return m.matches();
	}

	static boolean checkSign(String sign) {
		Pattern p = Pattern.compile("^[*-/=]{1,1}$");
		Matcher m = p.matcher(sign);
		return m.matches();
	}

	static boolean checkVariable(String var) {
		Pattern p = Pattern.compile("^[0-9]{1,10}$");
		Matcher m = p.matcher(var);
		return m.matches();
	}

	static boolean expressionValidator(String expression) {
		boolean process = true;
		int last = expression.length() - 1;
		for (int i = 0; i < expression.length(); i++) {
			String converItem = Character.toString(expression.charAt(i));
			if (i == 0) {
				if (!checkVariable(converItem)) {
					process = checkVariable(converItem);
					break;
				}
			} else if (expression.charAt(last) != '=') {
				process = false;
				break;
			} else {
				break;
			}
		}
		return process;
	}
}
