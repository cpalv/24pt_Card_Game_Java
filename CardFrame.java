package adt_project3;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Represents the CardFrame
 * @author Richard A. Bravo
 * @version 1.0
 */
public class CardFrame extends JFrame {
	/**
	 * The default constructor for CardFrame.
	 * @param message
	 */
	public CardFrame(String title){
		this.setTitle(title);
		this.setLocation(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new CardControl();
		this.getContentPane().add(p);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);	
	}
}
