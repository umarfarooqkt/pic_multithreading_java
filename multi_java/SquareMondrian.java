import java.awt.geom.Point2D;

public class SquareMondrian extends Mondrian {

	public SquareMondrian(double pixels) {
		super(pixels);
	}
	
	@Override
	protected Point2D.Double randomPoint(double x, double y, double width, double height){
	double pointX= width/2;
	pointX=pointX+x;
	double pointY= height/2;
	pointY=pointY+y;
	return new Point2D.Double(pointX,pointY);
	}

}
