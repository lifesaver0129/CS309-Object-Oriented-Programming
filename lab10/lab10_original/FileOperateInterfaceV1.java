package lab10_original;

import java.util.List;

public interface FileOperateInterfaceV1 {
    public List<StaffModel> readStaffFile();

    public void printStaffFile(List<StaffModel> list);

    public void writeStaffFile(List<StaffModel> list);
}
