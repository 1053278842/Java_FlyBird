package game;

import java.awt.image.BufferedImage;

/**
 * ����ƶ������� shift+alt+j �ĵ�ע��
 * @author Administrator
 *ʵ�ֵ����ƶ�
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
