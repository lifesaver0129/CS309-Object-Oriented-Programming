package abstractFactory;

/**
 * Created by lifesaver on 10/12/2017.
 */
public class XPS15 implements ComputerFactory {

    private static XPS15 instance = null;

    private CPU cpu;
    private GraphicCard gCard;

    public XPS15(){
    }

    public static synchronized XPS15 getInstance() {
        if (instance == null) {
            instance = new XPS15();
        }else{
            System.out.println("DellXps15Factory has been created!");
        }
        return instance;
    }

    @Override
    public CPU makeCPU() {
        this.cpu = new CoreI7();
        return this.cpu;
    }

    @Override
    public GraphicCard makeGPU() {
        this.gCard =new NVDIA940();
        return this.gCard;
    }
}
