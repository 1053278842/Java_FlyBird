package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bird extends GameShape {
	List<BufferedImage>list;//存储动画
	double v0;//初速度
	double t;//time
	double s;//距离
	double g;//重力
	public Bird() {
		v0=10;
		t=0.2;
		s=0;
		g=4.3;
		img=App.getImage("/Img/bird1.png");
		w=img.getWidth();
		h=img.getHeight();
		x=200-w/2;
		y=300-h/2;
		list=new ArrayList<BufferedImage>();
		for(int i=1;i<=2;i++) 
			list.add(App.getImage("/img/bird"+i+".png"));
	}
	//煽动方法
	int index=0;
	public void flyAnimation() {
		img=list.get(index%list.size());
		index++;
	}
	//自由落体(数学公示)
	public void move() {
		//1、上升（只有一次）
		s=t*v0;
		//得到小鸟上抛到峰值的y坐标
		y=(int) (y-s);
		//2、加速度下落(v2)
		double v2=v0-g*t;
		v0=v2;
	}
	//上抛
	public void moveUp() {
		v0=10;
	}
	
	public boolean hit() {
		if(y<=0||y>=600-h-140) {
			return true;
		}
		return false;
	}
	public boolean hit(Column cl,int index) {
		if(x>=cl.x-w&&y<=cl.y+cl.h&&index==1&&x<=cl.x+cl.w) {//上
//			System.out.print("上");
			return true;
		}
		if(x>=cl.x-w&&y>=cl.y-h&&index==2&&x<=cl.x+cl.w) {//下
//			System.out.print("下");
			return true;
		}
		return false;
	}
}
