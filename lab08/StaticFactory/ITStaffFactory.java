/**
 * Created by lifesaver on 30/11/2017.
 */
public class ITStaffFactory {
    public static ITStaff createITManager() {
        return new ITManager();
    }

    public static ITStaff createDeveloper() {
        return new Developer();
    }

    public static ITStaff createTester() {
        return new Tester();
    }
}
