package game;

import javax.swing.JFrame;

//����
/*
 * 1���̳�JFrame
 * 2����ʼ�����췽��
 * 3��ʵ������
 * 4��������.setVisible(true)	//��ʾ
 * 		setSize();							//���ڴ�С
 * 		setLocationRelativeTO(null)�����Ͻ�Ϊ�������
 * 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳�ʱ�رճ���
 * 		setTile();���ñ���
 * 		setIconImage(img)								//����ͼ��
 * 			img=ImgeIO.read(path)					//����·������ͼ��,ioʵ��
 * 			path=this.getClass.getResource(../img/xxx.png);  		//��ȡ��ǰ��ĵ�ַ������һ����ַ�������ҵ�ͼƬ��ַ
 */
public class GameFrame extends JFrame{
	int w=400,h=600;
	public GameFrame(){
		setSize(w,h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("for(��{}");
		setIconImage(App.getImage("/Img/bird1.png"));
	}
	
	public static void main(String[] args) {
		//��������
		GameFrame frame=new GameFrame();
		GamePanel panel=new GamePanel();
		//Panel
		frame.add(panel);
		frame.setVisible(true);
//		panel.start();
	}
}
