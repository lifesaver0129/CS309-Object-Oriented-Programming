package lab10_original;

import java.util.List;

public interface ManageStaffInterface {
    public void addingStaff(List<StaffModel> list);

    public void removeStaff(List<StaffModel> list, String name);
}
