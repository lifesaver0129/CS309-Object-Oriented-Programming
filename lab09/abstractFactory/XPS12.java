package abstractFactory;

/**
 * Created by lifesaver on 10/12/2017.
 */
public class XPS12 implements ComputerFactory {

    private static XPS12 instance = null;

    private CPU cpu;
    private GraphicCard gCard;

    public XPS12() {
    }

    public static synchronized XPS12 getInstance() {
        if (instance == null) {
            instance = new XPS12();
        }else{
            System.out.println("DellXps12Factory has been created!");
        }
        return instance;
    }

    @Override
    public CPU makeCPU() {
        this.cpu = new CoreI5();
        return this.cpu;
    }

    @Override
    public GraphicCard makeGPU() {
        this.gCard = new AMDR2();
        return this.gCard;
    }
}
