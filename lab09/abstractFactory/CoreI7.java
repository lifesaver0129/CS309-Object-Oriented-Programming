package abstractFactory;

public class CoreI7 implements CPU {
    private String name;
	
	public CoreI7(){
		this.name="CPU: CoreI7";
	}

	@Override
	public void displayCPUInfo() {
		System.out.println("DellXps15:"+this.name);
	}

}
