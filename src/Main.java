import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		Scanner scanner = new Scanner(System.in);
		String menu = "";
		boolean check = false;

		while (menu != "q") {
			System.out.println("==========MENU===========");
			System.out.println("1 - Calculator");
			System.out.println("2 - Find min max");
			System.out.println("3 - Intervals");
			System.out.println("4 - Quadratic equation");
			System.out.println("5 - Print maxtrix");
			System.out.println("6 - Month");
			System.out.println("q - to quit");
			System.out.print("choose:");

			while (!check) {
				menu = scanner.nextLine();
				check = StringValidator.checkMenu(menu);
			}

			switch (menu) {
			case "1": {
				calculator.run();
				break;
			}
			case "2": {
				calculator.findMinMax();
				break;
			}
			case "3": {
				calculator.checkIntervals();
				break;
			}
			case "5": {
				calculator.printMatrix();
				break;
			}
			case "4": {
				calculator.quadraticEquation();
				break;
			}
			}

		}
		scanner.close();
	}
}
