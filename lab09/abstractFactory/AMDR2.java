package abstractFactory;

public class AMDR2 implements GraphicCard{
	private String name;
	public AMDR2(){
		this.name="GPU: AMD R2";
	}
	
	@Override
	public void displayGPUInfo() {
		System.out.println("DellXps12: "+this.name);
	}
}
