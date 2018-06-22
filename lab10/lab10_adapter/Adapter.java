package lab10_adapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Adapter implements FileOperateInterfaceV2 {
    private FileOperateInterfaceV1 adaptee;
    private ManageStaffInterface adaptee2;

    public Adapter(FileOperateInterfaceV1 adaptee, ManageStaffInterface adaptee2) {
        this.adaptee = adaptee;
        this.adaptee2 = adaptee2;
    }

    @Override
    public List<StaffModel> readAllStaff() {
        List<StaffModel> list = adaptee.readStaffFile();
        return list;
    }

    @Override
    public void listAllStaff(List<StaffModel> list) {
        Collections.sort(list, new CompbyName());
        adaptee.printStaffFile(list);
    }

    @Override
    public void writeByName(List<StaffModel> list) {
        Collections.sort(list, new CompbyName());
//        list.sort(Comparator.comparing(StaffModel::getName));
//        list.sort((StaffModel s1, StaffModel s2) -> s1.getName().compareTo(s2.getName()));
        adaptee.writeStaffFile(list);
    }


    class CompbyName implements Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {
            StaffModel p1 = (StaffModel) o1;
            StaffModel p2 = (StaffModel) o2;
            if (p1.getName().compareTo(p2.getName()) < 0)
                return -1;
            return 1;
        }
    }

    @Override
    public void writeBySalary(List<StaffModel> list) {
        Collections.sort(list, new CompbySal());
        adaptee.writeStaffFile(list);
    }


    class CompbySal implements Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {
            StaffModel p1 = (StaffModel) o1;
            StaffModel p2 = (StaffModel) o2;
            if (p1.getSalary() - p2.getSalary() < 0)
                return -1;
            return 1;
        }
    }

    @Override
    public void addStaff (List<StaffModel> list){
        adaptee2.addingStaff(list);
    }

    @Override
    public void removeStaff (List<StaffModel> list){
        String name = "";
        int minSal = Integer.MAX_VALUE;;
        for (StaffModel e : list) {
            if (e.getSalary()<minSal) {
                name = e.getName();
                minSal= e.getSalary();
            }
        }
        adaptee2.removeStaff(list,name);
    }
}
