package com.bank.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton back;
	
	
	public BalanceEnquiry(String pinnumber) {
			this.pinnumber=pinnumber;
			
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(365, 450, 150, 30);
		back.addActionListener(this);
		image.add(back);
		

		
		Connect c = new Connect();
		
		int balance=0;
		try {
			String query="select * from bank where pin = '"+pinnumber+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance +=Integer.parseInt(rs.getString("ammount")); /* this line return string so 
																		  we have to convert in Integer */
				
				}else {
					balance -= Integer.parseInt(rs.getString("ammount"));
				}
			}
			
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your Current balance is "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(170, 300, 400, 30);
		image.add(text);
		
		
		setSize(900,900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new BalanceEnquiry("");
	}
}
