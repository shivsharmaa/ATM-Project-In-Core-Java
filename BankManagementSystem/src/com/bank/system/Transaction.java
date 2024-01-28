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
	JButton deposit , withdrawl, fastCash , miniStatement , pinChange ,balanceEnquiry, exit;
	
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
		
		deposit = new JButton("Deposite");
		deposit.setBounds(170, 370, 150, 28);
		deposit.addActionListener(this);
		image.add(deposit);
		
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
			else if(ae.getSource() == deposit) {
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);
			
			}else if(ae.getSource() == withdrawl) {
				setVisible(false);
				new Withdrawl(pinnumber).setVisible(true);
			
			} else if(ae.getSource() == fastCash) {
					
				setVisible(false);
				new FastCash(pinnumber).setVisible(true);
			}
			
			else if(ae.getSource() == pinChange) {
				
				setVisible(false);
				new PinChange(pinnumber).setVisible(true);
			
			}
			else if(ae.getSource() == balanceEnquiry) {
				
				setVisible(false);
				new BalanceEnquiry(pinnumber).setVisible(true);
			}
			
			else if(ae.getSource() == miniStatement) {
				setVisible(false);
				new MiniStatement(pinnumber).setVisible(true);
			}
		}
		
	
	
	public static void main(String[] args) {
		
		new Transaction("");
	}
}
