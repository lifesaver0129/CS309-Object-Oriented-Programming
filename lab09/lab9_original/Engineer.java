package lab9_original;

public class Engineer {
	CPUFactory cpufactory=new CPUFactory();
	GPUFactory gpufactory=new GPUFactory();
	public Computer makeComputer(int cpuType, int gputype){
		CPU cpu=cpufactory.createCPU(cpuType);
		GraphicCard gpu=gpufactory.createGPU(gputype);
		Computer computer=new Computer(cpu,gpu);
		return computer;
	}

	
}
