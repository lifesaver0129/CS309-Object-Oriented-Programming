/**
 * Created by lifesaver on 30/11/2017.
 */
public class DeveloperFactory implements ITStaffFactoryInterface {
    @Override
    public ITStaff creatITStaff() {
        return new Developer();
    }

}