package Original;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op = -1;
		CompareSalary salary = new CompareSalary();
		CompareWork work=new CompareWork();
		List<ITStaff> staffList = new ArrayList<ITStaff>();
		do {
			try {
				op = input.nextInt();
				switch (op) {
				case 1:
					staffList.add(new ITManager());
					break;
				case 2:
					staffList.add(new Developer());
					break;
				case 3:
					staffList.add(new Tester());
					break;
				case 4:
				System.out.println("All information:");
					Collections.sort(staffList, salary);
					for (ITStaff e : staffList) {
						System.out.println(e);
					}
					break;
				case 5:
					System.out.println("All name:");
					Collections.sort(staffList,work);
					for(ITStaff e:staffList){
						System.out.println(e.working());
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

class CompareSalary implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		ITStaff s1 = (ITStaff) o1;
		ITStaff s2 = (ITStaff) o2;
		if (s1.getSalary() > s2.getSalary())
			return 1;
		else
			return -1;
	}
}
class CompareWork implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		ITStaff s1 = (ITStaff) o1;
		ITStaff s2 = (ITStaff) o2;
		if (s1.working().compareTo(s2.working())>0)
			return 1;
		else
			return -1;
	}
	
}
