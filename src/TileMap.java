

import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import java.awt.*;

public class TileMap {
	Scanner mapReader;

	public TileMap() {
		try {
			mapReader = new Scanner(new File("maps"));
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Image cleanImage(String imageName) {
		Image img = getImage(imageName);
		img = makeColorTransparent(img, Color.white);
		return img;
	}

	public BufferedImage getImage(String imageName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imageName + ".png"));
		}
		catch (IOException e) {
			System.out.println("Looks like we couldn't find the image:" + imageName + ".png");
		}
		return img;
	}

	public static Image makeColorTransparent(Image im, final Color color) {
		ImageFilter filter = new RGBImageFilter() {
			// the color we are looking for... Alpha bits are set to opaque
			public int markerRGB = color.getRGB() | 0xFF000000;

			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					// Mark the alpha bits as zero - transparent
					return 0x00FFFFFF & rgb;
				} else {
					// nothing to do
					return rgb;
				}
			}
		};

		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

	public void renderMap(Graphics2D g, int[][] map) {
		Stuff.currentMap = map;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				g.drawImage(Stuff.TMObject.getImage("" + map[i][j]), j * Stuff.tileSize, i * Stuff.tileSize, null);
			}
		}
	}

	public void renderTile(Graphics2D g, int tileID, int xCoord, int yCoord) {
		g.drawImage(Stuff.TMObject.getImage("" + tileID), xCoord, yCoord, null);
	}

	public int[][] getMap(int mapNumber) {
		for (int n = 0; n < mapNumber * 12 * 16; n++) {
			mapReader.nextInt();
		}
		int[][] tempArray = new int[12][16];
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = 0; j < tempArray[0].length; j++) {
				tempArray[i][j] = mapReader.nextInt();
			}
		}
		return tempArray;
	}

	public static int nthIndexOf(String source, String sought, int n) {
		int index = source.indexOf(sought);
		if (index == -1) return -1;

		for (int i = 1; i < n; i++) {
			index = source.indexOf(sought, index + 1);
			if (index == -1) return -1;
		}
		return index;
	}

}
