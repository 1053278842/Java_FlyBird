package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 * 将方法定义为静态方法
 * 异常处理return正确返回值
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
