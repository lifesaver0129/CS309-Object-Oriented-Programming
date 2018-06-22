package lab10_original;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperate implements FileOperateInterfaceV1 {

	@Override
	public List<StaffModel> readStaffFile() {
		List<StaffModel> list = new ArrayList<StaffModel>();
		File file = new File("staff.txt");
		if (!file.exists()) {
			System.out.println("File " + file.getName() + " does not exist");
			System.exit(0);
		}
		try {
			// Create input file
			Scanner input = new Scanner(file);
			// Read file
			while (input.hasNext()) {
				String line = input.nextLine();
				String lineArray[] = line.split(" ");
				StaffModel stuffModel = new StaffModel(lineArray[0],
						lineArray[1], Integer.parseInt(lineArray[2]));
				list.add(stuffModel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("finish reading");
		return list;
	}

	@Override
	public void printStaffFile(List<StaffModel> list) {
		if (list.size()==0) {
			System.out.println("no staff information");
		} else {
			for (StaffModel s : list) {
				System.out.println(s);
			}
		}

	}

	@Override
	public void writeStaffFile(List<StaffModel> list) {
		try {
			if(list.size()==0){
				System.out.println("No information to be written");
				return;
			}
			FileWriter f = new FileWriter("staff.txt");
			BufferedWriter bufw = new BufferedWriter(f);
			String str = "";
			for (StaffModel s : list) {
				str = s.getName() + " " + s.getSex() + " "
						+ Integer.toString(s.getSalary());
				bufw.write(str);
				bufw.newLine();
			}
			bufw.flush();
			bufw.close();
			System.out.println("finish writing");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
