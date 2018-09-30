import java.util.Scanner;

public class Reader {

	private Scanner scanner = new Scanner(System.in);

	public String setExpression() {
		boolean check = false;
		String expression = "";

		while (!check) {
			System.out.print("Enter your expression: ");
			expression = scanner.nextLine();
			check = StringValidator.checkExpression(expression);
			if(!check) {
				Helper.printAlert();
			}
		}
		return expression;
	}

	public String setNumberLine() {
		boolean check = false;
		String numberLine = "";

		System.out.print("Enter the line uses divide sign ' ': ");
		while (!check) {
			numberLine = scanner.nextLine();
			check = StringValidator.checkNumberLine(numberLine);
		}
		return numberLine;
	}
}
