/**
 * Created by lifesaver on 30/11/2017.
 */
public class ArtDesignerFactory implements ITStaffFactoryInterface {
    @Override
    public ITStaff creatITStaff() {
        return new ArtDesigner();
    }

}