/**
 * Created by lifesaver on 30/11/2017.
 */
public class ITManagerFactory implements ITStaffFactoryInterface {
    @Override
    public ITStaff creatITStaff() {
        return new ITManager();
    }

}
