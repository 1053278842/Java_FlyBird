package game;

import javax.swing.JFrame;

//窗体
/*
 * 1、继承JFrame
 * 2、初始化构造方法
 * 3、实例化类
 * 4、对象名.setVisible(true)	//显示
 * 		setSize();							//窗口大小
 * 		setLocationRelativeTO(null)；左上角为基点居中
 * 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口退出时关闭程序
 * 		setTile();设置标题
 * 		setIconImage(img)								//设置图标
 * 			img=ImgeIO.read(path)					//根据路径创建图标,io实现
 * 			path=this.getClass.getResource(../img/xxx.png);  		//获取当前类的地址，的上一级地址，从中找到图片地址
 */
public class GameFrame extends JFrame{
	int w=400,h=600;
	public GameFrame(){
		setSize(w,h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("for(）{}");
		setIconImage(App.getImage("/Img/bird1.png"));
	}
	
	public static void main(String[] args) {
		//创建窗体
		GameFrame frame=new GameFrame();
		GamePanel panel=new GamePanel();
		//Panel
		frame.add(panel);
		frame.setVisible(true);
//		panel.start();
	}
}
