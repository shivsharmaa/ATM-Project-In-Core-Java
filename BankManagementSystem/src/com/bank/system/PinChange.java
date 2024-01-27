package com.bank.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener{
	
	JPasswordField pinTextField, repinTextField;
	JButton change, back;
	
	String pinnumber;
	//Constructor
	public PinChange(String pinnumber) {
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		// Jlabel
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		text.setBounds(250, 260, 400, 30);
		image.add(text);
		
		
		
		// Jlabel New Pin
		JLabel pinText = new JLabel("New PIN:");
		pinText.setForeground(Color.WHITE);
		pinText.setFont(new Font("Raleway", Font.BOLD, 16));
		pinText.setBounds(165, 320, 180, 25);
		image.add(pinText);
		
		pinTextField = new JPasswordField();
		pinTextField.setFont(new Font("Raleway", Font.BOLD, 16));
		pinTextField.setBounds(330, 320, 180, 25);
		image.add(pinTextField);
		
		
// JLABLE Re Enter Pin
		
		JLabel reEnterPinText = new JLabel("Re-Enter New PIN");
		reEnterPinText.setForeground(Color.WHITE);
		reEnterPinText.setFont(new Font("Raleway", Font.BOLD, 16));
		reEnterPinText.setBounds(165, 360, 180, 25);
		image.add(reEnterPinText);

		repinTextField = new JPasswordField();
		repinTextField.setFont(new Font("Raleway", Font.BOLD, 16));
		repinTextField.setBounds(330, 355, 180, 25);
		image.add(repinTextField);

		// JButton 
		change = new JButton("CHANGE");
		change.setBounds(360, 420, 150, 30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("BACK");
		back.setBounds(360, 455, 150, 30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900, 900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==change) {
		try {
			String pin = pinTextField.getText();
			String repin = repinTextField.getText();
			
			if(!pin.equals(repin)) {
				JOptionPane.showMessageDialog(null, "Enter Pin does not match");
				return;
			}
			
			if(pin.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter new PIN");
				return;
			}

			if(repin.equals("")) {
				JOptionPane.showMessageDialog(null, "please re enter new PIN");
				return;
			}
			
			Connect c = new Connect();
			
			// Update queries
			String query1 = "update bank set pin = '" + repin + "' where pin = '" + pinnumber + "'";
			String query2 = "update login set pin = '" + repin + "' where pin = '" + pinnumber + "'";
			String query3 = "update signupthree set pin = '" + repin + "' where pin = '" + pinnumber + "'";

			
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			c.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN Changed succesfully");
			
			setVisible(false);
			new Transaction(repin).setVisible(true);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
		else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
	}
}
	
	public static void main(String[] args) {
		
		new PinChange("").setVisible(true);
	}


	
}
