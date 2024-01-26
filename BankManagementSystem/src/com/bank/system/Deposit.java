package com.bank.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener{
	
	String pinnumber;
	JTextField ammount;
	JButton deposit, back;
	public Deposit(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		setTitle("Deposite Page");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		
		// JLabel
		JLabel text = new JLabel("Enter the Ammount you want to Deposite");
		text.setFont(new Font("Raleway", Font.BOLD, 15));
		text.setForeground(Color.WHITE);
		text.setBounds(180, 260, 400,20);
		image.add(text);
		
		//JTextField
		
		ammount = new JTextField();
		ammount.setFont(new Font("Raleway", Font.BOLD, 22));
		ammount.setBounds(170, 300, 320, 25);
		image.add(ammount);
		
		// JButton
		
		deposit = new JButton("Deposite");
		deposit.setBounds(360, 428, 150, 28);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(360, 460, 150, 28);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		
		
		setSize(900,900);
		setLocation(300, 0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== deposit) {
			
			String number = ammount.getText();
			Date date = new Date();
			
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "please enter the ammount");
			}
			else {
				try {

					Connect c = new Connect();
				String query ="insert into bank values('"+pinnumber+"', '"+date+"','Deposit','"+number+"' )";
				
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");

					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				
				} catch (SQLException e) {

					e.printStackTrace();
				}
				
			}

		}
		else if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
			
	}

	
	public static void main(String[] args) {
		new Deposit("");
	}
}
