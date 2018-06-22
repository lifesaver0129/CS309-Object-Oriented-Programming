/**
 * Created by lifesaver on 30/11/2017.
 */
public class ITStaffFactory {

    public static ITStaff createITStaff(String type) throws Exception{
        if(type.equals("M")){
            return new ITManager();
        }else if(type.equals("D")){
            return new Developer();
        }else if(type.equals("T")){
            return new Tester();
        }else{
            throw new Exception();
        }
    }
}
