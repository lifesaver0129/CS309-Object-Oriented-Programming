package lab10_original;

import java.util.List;
import java.util.Scanner;

public class ManageStaff implements ManageStaffInterface {
    Scanner input = new Scanner(System.in);

    @Override
    public void addingStaff(List<StaffModel> list) {
        System.out.println("Input name, sex, salary:");
        StaffModel s = new StaffModel(input.next(), input.next(), input.nextInt());
        list.add(s);
    }

    @Override
    public void removeStaff(List<StaffModel> list, String name) {
        for (StaffModel e : list) {
            if (e.getName().equals(name)) {
                list.remove(e);
                break;
            }
        }
        System.out.println("success to remove " + name);
    }

}
