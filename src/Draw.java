

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Draw {

	Image charater;

	JFrame frame;
	Canvas canvas;

	BufferStrategy bufferStrategy;

	private int WIDTH = 640;
	private int HEIGHT = 480;

	Draw() {
		Stuff.deck = new card[5];
		for (int i = 0; i < 5; i++) {
		    card noCard = new card("null");
		    Stuff.deck[i] = noCard;
		}
		
		charater = Stuff.TMObject.cleanImage("charater");
		frame = new JFrame("Simple RPG");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setLayout(null);

		canvas = new Canvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		canvas.setIgnoreRepaint(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		frame.setResizable(false);
		frame.setVisible(true);

		// this will add the canvas to our frame
		panel.add(canvas);
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();

		// This will make sure the canvas has focus, so that it can take input
		// from mouse/keyboard
		canvas.requestFocus();
		canvas.setBackground(Color.pink);
		canvas.addKeyListener(new ButtonHandler());

		Stuff.currentMap = Stuff.TMObject.getMap(0);
		Stuff.TMObject.renderMap((Graphics2D) bufferStrategy.getDrawGraphics(), Stuff.currentMap);
	}

	void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		render(g);
		g.dispose();
		bufferStrategy.show();
	}

	protected void render(Graphics2D g) {
		Stuff.TMObject.renderTile(g, Stuff.previousTile[0], Stuff.previousTile[1], Stuff.previousTile[2]);
		g.drawImage(charater, Stuff.charater.getX(), Stuff.charater.getY(), null);
	}

}
