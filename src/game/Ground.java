package game;

import java.awt.image.BufferedImage;

/**
 * 光标移动到类名 shift+alt+j 文档注释
 * @author Administrator
 *实现地面移动
 */
public class Ground {
	int x,y;
	BufferedImage img;
	int w,h;
	public Ground() {
		img=App.getImage("/Img/ground.jpg");
		x=0;
		w=img.getWidth();
		h=img.getHeight();
		y=600-140;
	}
	public void GroundMove() {
		x--;
		if(x<=-400) {
			x=0;
		}
	}
}
