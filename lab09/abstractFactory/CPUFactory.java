package abstractFactory;

public class CPUFactory {
	
	public CPU createCPU(int type){
		switch(type){
		case 1: return new CoreI5();
		case 2: return new CoreI7();
		}
		return null;
	}
}
