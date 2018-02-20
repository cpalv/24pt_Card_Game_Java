package adt_project3;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.text.IconView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * Represents a CardControl panel
 * @author Richard A. Bravo
 * @version 1.0
 */
public class CardControl extends JPanel{
	/**
	 * The verify button of this CardControl.
	 */
	private JButton verify;
	/**
	 * The suspend button of this CardControl
	 */
	private JButton refresh;
	/**
	 * The NPanel of this CardControl.
	 */
	private JPanel NPanel;
	/**
	 * The SPanel of this CardControl.
	 */
	private JPanel SPanel;
	/**
	 * The MPanel of this CardControl.
	 */
	private JPanel MPanel;
	/**
	 * The textfield of this CardControl.
	 */
	private JTextField textfield;
	/**
	 * The card1 of this CardControl.
	 */
	public JLabel card1;
	/**
	 * The card2 of this CardControl.
	 */
	public JLabel card2;
	/**
	 * The card3 of this CardControl.
	 */
	public JLabel card3;
	/**
	 * The card4 of this CardControl.
	 */
	public JLabel card4;
	/**
	 * The msg of this CardControl.
	 */
	private JLabel msg;
	/**
	 * An ArrayList cardHolder of this CardControl.
	 */
	private ArrayList<ImageIcon> cardHolder = new ArrayList<ImageIcon>();

	/**
	 * The default constructor for CardControl.
	 */
	public CardControl(){
		//Sets up the size and layout of the main panel
		this.setPreferredSize(new Dimension(410, 190));
		this.setLayout(new BorderLayout());
		
		for(int i = 1; i <= 52; i++){
			cardHolder.add(new ImageIcon("image/card/"+ i + ".png", "" + i));
		}
		
		//Sets up the north panel
		this.NPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		this.refresh = new JButton("Refresh");
		this.refresh.addActionListener(new ButtonActionListener(this));
		NPanel.add(this.refresh);
		
		
		//Sets up the south panel 
		this.SPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.verify = new JButton("Verify");
		this.verify.addActionListener(new ButtonActionListener(this));
		this.msg = new JLabel("Enter an expression:");
		this.textfield = new JTextField(20);
		SPanel.add(msg, BorderLayout.WEST);
		SPanel.add(textfield, BorderLayout.CENTER);
		SPanel.add(verify, BorderLayout.EAST);
		
		//Sets up the middle panel
		this.MPanel = new JPanel();
		this.card1 = new JLabel();
		this.card2 = new JLabel();
		this.card3 = new JLabel();
		this.card4 = new JLabel();
		this.card1.setIcon(cardHolder.get(0));
		this.card2.setIcon(cardHolder.get(1));
		this.card3.setIcon(cardHolder.get(2));
		this.card4.setIcon(cardHolder.get(3));
		MPanel.add(card1);
		MPanel.add(card2);
		MPanel.add(card3);
		MPanel.add(card4);
		
		//Adds the panels into the main panel
		this.add(this.MPanel, BorderLayout.CENTER);
		this.add(this.NPanel, BorderLayout.NORTH);
		this.add(this.SPanel, BorderLayout.SOUTH);	
	}
	
	/**
	 * Returns the verify button of this CardControl.
	 * @return A reference to the verify button of this CardControl.
	 */
	public JButton getVerify(){
		return this.verify;
	}
	
	/**
	 * Returns the refresh button of this CardControl.
	 * @return A reference to the refresh button of this CardControl.
	 */
	public JButton getRefresh(){
		return this.refresh;
	}
	
	/**
	 * The verify method for this CardControl.
	 */
	public void verify(){
		String input = textfield.getText();
		Expression exp = new Expression();
		ArrayList<String> convertedHolder = new ArrayList<String>();
		convertedHolder = exp.infixToPostfix(input);
		int result = exp.evaluate(convertedHolder);
		ArrayList<String> userValues = new ArrayList<String>();
		ArrayList<String> cardValues = new ArrayList<String>();
		String operators = "(+-*/)";
		String[] nums = input.split(operators);
		for(int i = 1; i < nums.length; i++) {
			userValues.add(nums[i]);
		}
		
		//Gets cards and converts them into their appropriate values.
		String cardValue1 = cardHolder.get(0).getDescription();
		String cardValue2 = cardHolder.get(1).getDescription();
		String cardValue3 = cardHolder.get(2).getDescription();
		String cardValue4 = cardHolder.get(3).getDescription();
		String newCardValue1 = cardValue(cardValue1);
		String newCardValue2 = cardValue(cardValue2);
		String newCardValue3 = cardValue(cardValue3);
		String newCardValue4 = cardValue(cardValue4);
		cardValues.add(0,newCardValue1);
		cardValues.add(1,newCardValue2);
		cardValues.add(2,newCardValue3);
		cardValues.add(3,newCardValue4);
		
		if(userValues.size() != 4 || !userValues.contains(cardValues.get(0)) || !userValues.contains(cardValues.get(1)) || !userValues.contains(cardValues.get(2)) || !userValues.contains(cardValues.get(3))) {
			JOptionPane.showMessageDialog(textfield, "Error: The numbers entered in the expression do not equal the card numbers displayed",
					"Message", JOptionPane.ERROR_MESSAGE);
		}
		else {
			int displayMsg = exp.evaluate(convertedHolder);
			
			if(displayMsg != 24) {
				JOptionPane.showMessageDialog(textfield, "Incorrect", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else {
				JOptionPane.showMessageDialog(textfield, "Correct", "Message", JOptionPane.INFORMATION_MESSAGE);
			}
	}
}
	
	
	/**
	 * The refresh method for this CardControl.
	 */
	public void refresh(){
		Collections.shuffle(cardHolder);
		this.card1.setIcon(cardHolder.get(0));
		this.card2.setIcon(cardHolder.get(1));
		this.card3.setIcon(cardHolder.get(2));
		this.card4.setIcon(cardHolder.get(3));
		
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String cardValue(String s){
		String value = "";
		if(s.equals("1") || s.equals("14") || s.equals("27") || s.equals("40")){
			value = "1";
			return value;
		}
		else if(s.equals("2") || s.equals("15") || s.equals("28") || s.equals("41")){
			value = "2";
			return value;
		}
		else if(s.equals("3") || s.equals("16") || s.equals("29") || s.equals("42")){
			value = "3";
			return value;
		}
		else if(s.equals("4") || s.equals("17") || s.equals("30") || s.equals("43")){
			value = "4";
			return value;
		}
		else if(s.equals("5") || s.equals("18") || s.equals("31") || s.equals("44")){
			value = "5";
			return value;
		}
		else if(s.equals("6") || s.equals("19") || s.equals("32") || s.equals("45")){
			value = "6";
			return value;
		}
		else if(s.equals("7") || s.equals("20") || s.equals("33") || s.equals("46")){
			value = "7";
			return value;
		}
		else if(s.equals("8") || s.equals("21") || s.equals("34") || s.equals("47")){
			value = "8";
			return value;
		}
		else if(s.equals("9") || s.equals("22") || s.equals("35") || s.equals("48")){
			value = "9";
			return value;
		}
		else if(s.equals("10") || s.equals("23") || s.equals("36") || s.equals("49")){
			value = "10";
			return value;
		}
		else if(s.equals("11") || s.equals("24") || s.equals("37") || s.equals("50")){
			value = "11";
			return value;
		}
		else if(s.equals("12") || s.equals("25") || s.equals("38") || s.equals("51")){
			value = "12";
			return value;
		}
		else{
			value = "13";
			return value;
		}
	}

/**
 * 	
 * @author Richard A. Bravo
 * @version 1.0
 */
public class ButtonActionListener implements ActionListener{
		/**
		 * The actionPanel of this ButtonActionListener.
		 */
		private JPanel actionPanel;
		/**
		 * The default constructor for ButtonActionListener.
		 * @param actionPanel A reference to the actionPanel of this ButtonActionListener.
		 */
		public ButtonActionListener(JPanel actionPanel){
			this.actionPanel = actionPanel;
		}
		
		/**
		 * Sets up the listeners for refresh and verify.
		 */
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == refresh){
				if(this.actionPanel instanceof CardControl){
				((CardControl)this.actionPanel).refresh();
				}	
			
				else if(e.getSource() == verify){
					if(this.actionPanel instanceof CardControl){
						((CardControl)this.actionPanel).verify();
					}
				}
			
			}
		}
	}
}
	


