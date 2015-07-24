

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {
	public ButtonHandler() {

	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_W:
			Stuff.charater.setUp(false);
			break;
		case KeyEvent.VK_A:
			Stuff.charater.setLeft(false);
			break;
		case KeyEvent.VK_S:
			Stuff.charater.setDown(false);
			break;
		case KeyEvent.VK_D:
			Stuff.charater.setRight(false);
			break;
		}
	}

	public void keyPressed(KeyEvent key) {
		switch (key.getKeyCode())

		{
		case KeyEvent.VK_W:
			Stuff.charater.setUp(true);
			break;
		case KeyEvent.VK_A:
			Stuff.charater.setLeft(true);
			break;
		case KeyEvent.VK_S:
			Stuff.charater.setDown(true);
			break;
		case KeyEvent.VK_D:
			Stuff.charater.setRight(true);
			break;
		}
	}
}
