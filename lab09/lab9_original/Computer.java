package lab9_original;

public class Computer {
	private CPU cpu;
	private GraphicCard gCard;
	
	public Computer(CPU cpu,GraphicCard gCard){
		this.cpu=cpu;
		this.gCard=gCard;
	}
	
	public void display(){
		cpu.displayCPUInfo();
		gCard.displayGPUInfo();
	}
}
