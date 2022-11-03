package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

/*
 * 1���̳�JPanel
 * 2����ʼ�����췽��
 * 3����main��ʵ��������
 * 4����������ӵ���������С�frame.add��panel��
 */
public class GamePanel extends JPanel {
	int score;
	int rd,rd_y;
	Ground gd;
	Bird bird =new Bird();
	//��Ϸ״̬
	boolean GameOver=false;
	boolean start=false;
	Column cl1,cl2;
	Column cl3,cl4;
	public GamePanel() {
		setBackground(Color.black);
		//UI
		reposition();
		
		start=false;
		//mouse������
		/*
		 * ����MouseAdapter ��ļ�����
		 * ����Ĭ�Ϸ���mouseCliked()
		 * ��ӵ�Panel�У�this.addMouseListener(adpater)
		 */
		MouseAdapter adapter =new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(start==true) {
					bird.moveUp();
				}
				else {
					start=true;
					start();
				}
				if(GameOver==true) {
					replay();
				}
					//���������һ�����⣬start()��һ����ѭ���� �����޷�ִ��iftrue;�߳̿ɽ��
			}
		};
		this.addMouseListener(adapter);
	}
	private void reposition() {
		rd=(int) (50*Math.random())+140;
		rd_y=-((int) (100*Math.random())+60);
		gd=new Ground();
		cl1=new Column(1,1,rd, rd_y);
		cl2=new Column(2,1, rd, rd_y);
		rd=(int) (50*Math.random())+140;
		rd_y=-((int) (100*Math.random())+60);
		cl3=new Column(1,2, rd, rd_y);
		cl4=new Column(2,2, rd, rd_y);
	}
	protected void replay() {
		reposition();
		start=false;
		GameOver=false;
		score=0;
		bird.x=200-bird.w/2;
		bird.y=300-bird.h/2;
		repaint();
	}
	//��Ϸ��ʼ�ķ���
	public void start() {
		myThread mt=new myThread();
		Thread t=new Thread(mt);
		t.start();//����CPU���Ը�����̷߳���ʱ��Ƭ��
	}
	public void addScore() {
		if(bird.x==cl1.x+cl1.w||bird.x==cl3.x+cl3.w) {
			score++;
			repaint();
		}
	}
	@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(App.getImage("/Img/bg.jpg"), 0, 0, null);
			//4������
			g.drawImage(cl1.img, cl1.x, cl1.y, cl1.w,cl1.h,null);
			g.drawImage(cl2.img, cl2.x, cl2.y, cl2.w,cl2.h,null);
			g.drawImage(cl3.img, cl3.x, cl3.y, cl3.w,cl3.h,null);
			g.drawImage(cl4.img, cl4.x, cl4.y, cl4.w,cl4.h,null);
			//
			g.drawImage(gd.img, gd.x, gd.y, gd.w,gd.h,null);
			g.drawImage(bird.img,bird.x,bird.y,bird.w,bird.h,null);
			//��������
			Font f=new Font("swfit_slm_fw",0,10);
			g.setColor(Color.white);
			g.setFont(f);
			g.drawString("Score:  "+score, 10, 20);
			if(start==false) {
				f=new Font("swfit_slm_fw",Font.BOLD,20);
				g.setFont(f);
				g.drawString("Any Key Start", 100, 120);
			}else if(GameOver==true){
				f=new Font("swfit_slm_fw",Font.BOLD,30);
				g.setFont(f);
				g.drawString("Game Over", 90, 100);
				f=new Font("swfit_slm_fw",0,16);
				g.setFont(f);
				g.drawString("Any Key Continue", 100, 500+f.getSize()+10);
			}
		}
	
	//�߳���
	class myThread implements Runnable{
		/*
		 * ����һ����ʵ��Runable�ӿ�
		 * ����run����  run������ִ����Ҫ���Ķ���
		 */
		@Override
		public void run() {
			//�ƶ�����
			while(!GameOver) {
				gd.GroundMove();
				cl1.ClMove(cl2,cl3);
				cl3.ClMove(cl4,cl1);
				bird.flyAnimation();
				bird.move();
				addScore();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
				//��ײ���
				boolean test ;
				test=bird.hit();
				if(test==true) {
					GameOver=true;
				}
				test=bird.hit(cl1, 1)||bird.hit(cl2, 2)||bird.hit(cl3, 1)||bird.hit(cl4, 2);
				if(test==true) {
					GameOver=true;
				}
			}
		}	
	}
}
