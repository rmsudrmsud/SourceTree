package master;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MasterService ms = new MasterService();
		//ms.getAll();
		ms.editSports(sc);
	}

}
