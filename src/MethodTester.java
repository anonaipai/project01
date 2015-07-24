

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MethodTester {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		for (int[] etc :Stuff.TMObject.getMap(1)) {
			for (int number : etc) {
				System.out.print(number + " ");
			}
			System.out.print("\n");
		}
	}

}
