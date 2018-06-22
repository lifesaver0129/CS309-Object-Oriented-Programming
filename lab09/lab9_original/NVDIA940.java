package lab9_original;

public class NVDIA940 implements GraphicCard {
	private String name;
	public NVDIA940(){
		this.name="GPU: NVDIA 940";
	}
	@Override
	public void displayGPUInfo() {
		System.out.println("DellXps15:"+this.name);
	}

}
