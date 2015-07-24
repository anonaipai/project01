

public class Charater {
	private int xCoord, yCoord;
	private boolean left, right, up, down;

	public int getX() {
		return xCoord;
	}

	public int getY() {
		return yCoord;
	}

	public void setRight(boolean d) {
		right = d;
	}

	public void setLeft(boolean d) {
		left = d;
	}

	public void setUp(boolean d) {
		up = d;
	}

	public void setDown(boolean d) {
		down = d;
	}

	public void update() {
		move();
	}

	public void move() {
		Stuff.previousTile[0] = Stuff.currentMap[yCoord / Stuff.tileSize][xCoord / Stuff.tileSize];
		Stuff.previousTile[1] = xCoord;
		Stuff.previousTile[2] = yCoord;
		switch(Stuff.currentTile){
		case 1:
		up = false;
			break;
		case 2:
		right = false;
			break;
		case 3:
		down = false;
			break;
		case 4:
		left = false;
			break;
		case 6:
		up = false;
		left = false;
			break;
		case 7:
		up = false;
		right = false;
			break;
		case 8:
		down = false;
		right = false;
			break;
		case 9:
		down = false;
		left = false;
			break;
		case 11:
		left = false;
		right = false;
			break;
		case 12:
		up= false;
		down = false;
			break;
		}
		if (left) {
			xCoord -= Stuff.tileSize;
		}
		if (right) {
			xCoord += Stuff.tileSize;
		}
		if (down) {
			yCoord += Stuff.tileSize;
		}
		if (up) {
			yCoord -= Stuff.tileSize;
		}
		if (xCoord < 0) xCoord = 600;
		if (xCoord > 600) xCoord = 0;
		if (yCoord < 0) yCoord = 440;
		if (yCoord > 460) yCoord = 0;
		Stuff.currentTile = Stuff.currentMap[yCoord / Stuff.tileSize][xCoord / Stuff.tileSize];

	}

	public void changeMap() {
	}
}
