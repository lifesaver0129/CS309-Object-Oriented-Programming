package abstractFactory;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<ComputerFactory> computers = new ArrayList<>();
        int op = -1;
        System.out.println("Input 1 or 2 to create DellXps12Factory or DellXps15Factory respectively\n");
        do {
            try {
                op = input.nextInt();
                switch (op) {
                    case 1:
                        XPS12.getInstance();
                        break;
                    case 2:
                        XPS15.getInstance();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception:" + e);
                input.nextLine();
            }
        } while (op != 0);
        op = -1;
		System.out.println("Please create computer:");
		do {
			try {
				op = input.nextInt();
				switch (op) {
				case 1:
					computers.add(new XPS12());
					break;
				case 2:
					computers.add(new XPS15());
					break;
				case 3:
					for (ComputerFactory e : computers) {
						e.makeCPU().displayCPUInfo();
						System.out.println();
						e.makeCPU().displayCPUInfo();
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
