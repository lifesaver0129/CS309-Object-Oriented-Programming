package lab10_adapter;

import java.util.List;

public interface FileOperateInterfaceV2 {
    public List<StaffModel> readAllStaff();

    public void listAllStaff(List<StaffModel> list);

    public void writeByName(List<StaffModel> list);

    public void writeBySalary(List<StaffModel> list);

    public void addStaff (List<StaffModel> list);

    public void removeStaff (List<StaffModel> list);
}
