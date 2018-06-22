/**
 * Created by lifesaver on 30/11/2017.
 */
public class TesterFactory implements ITStaffFactoryInterface {
    @Override
    public ITStaff creatITStaff() {
        return new Tester();
    }

}