import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class RoundedMondrian extends Mondrian {

	public RoundedMondrian(double pixels) {
		super(pixels);
	}
	
	protected void createRectangle(Graphics2D g2,double x, double y,double width,double height){
		g2.setStroke(new BasicStroke((float)3.0));
		g2.setPaint(Color.black);
		g2.draw(new RoundRectangle2D.Double(x,y,width,height,5,5));
	   	g2.setPaint(super.randomColor());
		g2.fill(new RoundRectangle2D.Double(x,y,width,height,5,5));
	}

}
