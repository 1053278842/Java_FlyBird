package game;

/**
 * ������
 * @author Administrator
 *
 */
public class Column extends GameShape {
	int distance;		//�������ҵļ��
	int rd;//���¼��
	int rd_y;//��ʼ������Ӹߵ�λ��
	public Column(int num,int index,int rd,int rd_y) {//num=���£�Index���ֵڶ���
		distance=250;
		x=400;//��һ�����ӵĳ�ʼ����
		if(index!=1) {
			x=x+distance;
		}
		if(num==1) {
			img=App.getImage("/Img/column1.png");
			w=img.getWidth()/2;
			h=img.getHeight()/2;
			y=rd_y-rd/4;
		}else {
			img=App.getImage("/Img/column2.png");
			w=img.getWidth()/2;
			h=img.getHeight()/2;
			y=rd_y+h+rd/4;
		}
//		System.out.println("��ʼ��ʱrd"+rd);
	}
	//�ƶ�
	public void ClMove(Column cl,Column BeforCl) {
		x--;
		cl.x--;
		if(x==-w) {
			rd=(int) (60*Math.random())+140;
//			System.out.println("����ʱrd"+rd);
			rd_y=-((int) (100*Math.random())+60);
			x=BeforCl.x+distance;
			cl.x=BeforCl.x+distance;
			y=rd_y-rd/2;
			cl.y=y+h+rd/2;
//			System.out.println(rd);
			}
		}
}
