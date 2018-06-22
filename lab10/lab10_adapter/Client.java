package lab10_adapter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {
        List<StaffModel> list = new ArrayList<StaffModel>();
        ManageStaffInterface staffManager = new ManageStaff();
        FileOperateInterfaceV1 fileOperater = new FileOperate();
        FileOperateInterfaceV2 fO2 = new Adapter(fileOperater,staffManager);
        Scanner input = new Scanner(System.in);
        System.out.println("Please select operation: 1.readFile 2.listFile 3.writeFileByName " +
                "4.wirteFileBySalary 5.addStaff 6.removeStaff");
        int op = 0;
        do {
            try {
                op = input.nextInt();
                switch (op) {
                    case 1:
                        list = fO2.readAllStaff();
                        break;
                    case 2:
                        fO2.listAllStaff(list);
                        break;
                    case 3:
                        fO2.writeByName(list);
                        break;
                    case 4:
                        fO2.writeBySalary(list);
                        break;
                    case 5:
                        fO2.addStaff(list);
                        break;
                    case 6:
                        fO2.removeStaff(list);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception:" + e);
                input.nextLine();
            }
        } while (op != 0);

    }

}
