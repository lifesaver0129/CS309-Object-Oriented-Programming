package lab10_original;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		List<StaffModel> list=new ArrayList<StaffModel>();
		FileOperateInterfaceV1 fileOperater=new FileOperate();
		Scanner input=new Scanner(System.in);
		System.out.println("Please select operation: 1.readFile 2.listFile 3. writeFile:");
		int op = 0;
		do {
			try {
				op = input.nextInt();
				switch (op) {
				case 1:
					list=fileOperater.readStaffFile();
					break;
				case 2:
					fileOperater.printStaffFile(list);
					break;
				case 3:
					fileOperater.writeStaffFile(list);
				}
			} catch (InputMismatchException e) {
				System.out.println("Exception:" + e);
				input.nextLine();
			}
		} while (op != 0);

	}

}
