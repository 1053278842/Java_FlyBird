package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 * ����������Ϊ��̬����
 * �쳣����return��ȷ����ֵ
 */
public class App {
	public static BufferedImage getImage(String path) {
		BufferedImage img;
		try {
			img = ImageIO.read(App.class.getResource(path));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
