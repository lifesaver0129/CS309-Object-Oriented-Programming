package abstractFactory;

/**
 * Created by lifesaver on 10/12/2017.
 */
public interface ComputerFactory {
    public CPU makeCPU();
    public GraphicCard makeGPU();

}
