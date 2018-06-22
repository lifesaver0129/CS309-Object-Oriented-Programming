package lab9_original;

public class GPUFactory {
	public GraphicCard createGPU(int type){
		switch(type){
		case 1: return new AMDR2();
		case 2: return new NVDIA940();
		}
		return null;
	}
}
