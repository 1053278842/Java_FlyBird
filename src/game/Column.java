package game;

/**
 * 柱子类
 * @author Administrator
 *
 */
public class Column extends GameShape {
	int distance;		//柱子左右的间距
	int rd;//上下间距
	int rd_y;//初始随机柱子高低位置
	public Column(int num,int index,int rd,int rd_y) {//num=上下，Index区分第二套
		distance=250;
		x=400;//第一个管子的初始距离
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
//		System.out.println("初始化时rd"+rd);
	}
	//移动
	public void ClMove(Column cl,Column BeforCl) {
		x--;
		cl.x--;
		if(x==-w) {
			rd=(int) (60*Math.random())+140;
//			System.out.println("重置时rd"+rd);
			rd_y=-((int) (100*Math.random())+60);
			x=BeforCl.x+distance;
			cl.x=BeforCl.x+distance;
			y=rd_y-rd/2;
			cl.y=y+h+rd/2;
//			System.out.println(rd);
			}
		}
}
