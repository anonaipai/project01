

public class Engine implements Runnable {
	@Override
	public void run() {
		Draw drawing = new Draw();
		while (true) {
			Stuff.charater.update();
			drawing.render();
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
