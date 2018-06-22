package lab10_original;

public class StaffModel {
    private String name;
    private String sex;
    private int salary;


    public StaffModel(String name, String sex, int salary) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "StaffModel [name=" + name + ", sex=" + sex + ", salary="
                + salary + "]";
    }
}
