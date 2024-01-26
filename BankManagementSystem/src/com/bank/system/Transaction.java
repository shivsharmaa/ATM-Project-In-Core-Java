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

public class Transaction extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton deposite , withdrawl, fastCash , miniStatement , pinChange ,balanceEnquiry, exit;
	
	public Transaction(String pinnumber) {
		this.pinnumber = pinnumber;
		setLayout(null);
		setTitle("Transaction Page");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		// Label
		JLabel text = new JLabel("Please Select your Transaction");
		text.setForeground(Color.WHITE);
		text.setBounds(200, 250, 700, 35);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		deposite = new JButton("Deposite");
		deposite.setBounds(170, 370, 150, 28);
		deposite.addActionListener(this);
		image.add(deposite);
		
		withdrawl= new JButton("Cash Withdrawl");
		withdrawl.setBounds(355, 370, 150, 28);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170, 400, 150, 28);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355, 400, 150, 28);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(170, 430, 150, 28);
		pinChange.addActionListener(this);
		image.add(pinChange);

		balanceEnquiry= new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(355, 430, 150, 28);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);

		exit = new JButton("Exit");
		exit.setBounds(355, 460, 150, 28);
		exit.addActionListener(this);
		image.add(exit);

		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
		// unimplemented method of ActionListner
		
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource()== exit) {
				System.exit(0);
			
				
			}
		}
		
	
	
	public static void main(String[] args) {
		
		new Transaction("");
	}
}
