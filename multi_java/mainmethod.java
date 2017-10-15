import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainmethod {

	public static void main(String[] args) {
		JFrame f= new JFrame("Modrian demo");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new FlowLayout());
        JPanel m= new Mondrian(5000);
        m.add(new JButton("Mondrian"));// I'm using button only for ease of reading of the tag
        f.add(m);
        JPanel dm10= new DirectedMondrian(5000,10);
        dm10.add(new JButton("Directed mondrian 10%"));
        f.add(dm10);
        JPanel dm90= new DirectedMondrian(5000,90);
        dm90.add(new JButton("Directed mondrian 90%"));
        f.add(dm90);
        JPanel Rm= new RoundedMondrian(5000);
        Rm.add(new JButton("Rounded mondrian "));
        f.add(dm90);
        JPanel Sm= new SquareMondrian(5000);
        Sm.add(new JButton("Squared mondrian "));
        f.add(Sm);
        JPanel Mm= new MazeMondrian(5000);
        Mm.add(new JButton("Maze mondrian "));
        f.add(Mm);
        f.pack();
        f.setVisible(true);
        
	}

}
