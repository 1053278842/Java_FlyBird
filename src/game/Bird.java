package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Bird extends GameShape {
	List<BufferedImage>list;//�洢����
	double v0;//���ٶ�
	double t;//time
	double s;//����
	double g;//����
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
	//ɿ������
	int index=0;
	public void flyAnimation() {
		img=list.get(index%list.size());
		index++;
	}
	//��������(��ѧ��ʾ)
	public void move() {
		//1��������ֻ��һ�Σ�
		s=t*v0;
		//�õ�С�����׵���ֵ��y����
		y=(int) (y-s);
		//2�����ٶ�����(v2)
		double v2=v0-g*t;
		v0=v2;
	}
	//����
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
		if(x>=cl.x-w&&y<=cl.y+cl.h&&index==1&&x<=cl.x+cl.w) {//��
//			System.out.print("��");
			return true;
		}
		if(x>=cl.x-w&&y>=cl.y-h&&index==2&&x<=cl.x+cl.w) {//��
//			System.out.print("��");
			return true;
		}
		return false;
	}
}
