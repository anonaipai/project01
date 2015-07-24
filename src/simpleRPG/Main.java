package simpleRPG;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Engine RPG = new Engine();
		new Thread(RPG).start();
	}
}
