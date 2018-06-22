package lab9_original;

public class CoreI5 implements CPU {
	private String name;
	
	public CoreI5(){
		this.name="CPU: CoreI5";
	}
	@Override
	public void displayCPUInfo() {
		System.out.println("DellXps12: "+this.name);
	}

}
