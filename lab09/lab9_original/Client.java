package lab9_original;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Engineer engineer = new Engineer();
		ArrayList<Computer> computers = new ArrayList<Computer>();
		int op = -1;
		System.out.println("Please create computer:");
		do {
			try {
				op = input.nextInt();
				switch (op) {
				case 1:
					computers.add(engineer.makeComputer(1, 1));
					break;
				case 2:
					computers.add(engineer.makeComputer(2, 2));
					break;
				case 3:
					for (Computer e : computers) {
						e.display();
						System.out.println();
					}
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Exception:" + e);
				input.nextLine();
			}
		} while (op != 0);

	}
}
