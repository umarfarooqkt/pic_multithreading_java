public class DirectedMondrian extends Mondrian{

	private double proba;
	
	public DirectedMondrian(double pixels,int prob) {
		super(pixels);
		this.proba=(double)prob/100;
	}
 
	@Override
	protected boolean coinToss(){
		if(Math.random() >proba){
			return true;
		}
		else{
			return false;
		}
	    }
}
