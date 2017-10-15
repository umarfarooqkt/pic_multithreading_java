import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.EOFException;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class Mondrian extends JPanel {
	
	//fields
	protected double size;
	private static Color palette[]={Color.RED,Color.BLUE,Color.WHITE,Color.yellow};
	private Random rng= new Random();
	protected boolean Mazecheck=false;
	// constructor
	public Mondrian(double pixels){
		this.addMouseListener(new MyAdapter());
		this.setPreferredSize(new Dimension(500,500));
		this.size=pixels;
	}
	
	//methods 
	
	   protected void rectangularArt(Graphics2D g2, double x, double y, double width, double height){
		double w;
		double h;
		double checkSize=width*height;
		double i;
		double j;
		if(size>=checkSize){
			createRectangle(g2,x,y,width,height);
		}
		else{
			Point2D.Double rP=randomPoint(x,y,width,height);
			
			if(coinToss()){
				i=rP.getX();
				w=i-x; //starting point - ending point
			rectangularArt(g2,x,y,w,height);
			w=width-w;
			rectangularArt(g2,i,y,w,height);
			maze(g2,i-5,y,10,height);
			
			}
			else{
				j=rP.getY();
				h=j-y;
				rectangularArt(g2,x,y,width,h);
				h=height-h;
				rectangularArt(g2,x,j,width,h);
				maze(g2,x,j-5,width,10);
			}
		}
	}
	
	////maze converter////
	   protected void maze(Graphics2D g2, double x,double y,double width,double height){
		   if (Mazecheck){
			   g2.setPaint(Color.lightGray);
			   g2.fill(new Rectangle2D.Double(x,y,width,height));
		   }
	   }
	//////making a rectangle////
	   
	protected void createRectangle(Graphics2D g2,double x, double y,double width,double height){
		g2.setStroke(new BasicStroke((float)3.0));
		g2.setPaint(Color.black);
		g2.draw(new Rectangle2D.Double(x,y,width,height));
	   	g2.setPaint(randomColor());
		g2.fill(new Rectangle2D.Double(x,y,width,height));
	}
	   
	/////Random Color method////
	protected Color randomColor(){
		Random rnd = new Random();
		int rndout=rnd.nextInt(4);
		return palette[rndout];
	}
	//////////////painter///////
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
			rectangularArt(g2,0,0,this.getWidth(),this.getHeight());
		   
	}
	/////////coin toss//////////
	protected boolean coinToss(){
		if(Math.random() < 0.5){
			return true;
		}
		else{
			return false;
		}
	    }
	/////// random Point ///////
	protected Point2D.Double randomPoint (double x, double y, double width, double height){
		int pointX = (int) (x+rng.nextInt((int)width+1));
		int pointY = (int) (y+rng.nextInt((int)height+1));
		return new Point2D.Double(pointX,pointY);
	}
	
	///// nested class for mouse click////
	class MyAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
          repaint();
        }
    }
}
