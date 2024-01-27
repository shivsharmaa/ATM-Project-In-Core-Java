package com.bank.system;

import java.awt.Color;
import java.awt.Font;
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

public class FastCash extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton withrawHundred, withrawFiveThousand, withrawFiveHundred, withrawOneThousand, withrawTwoThousand, withrawTenThousand, back;
	
	public FastCash(String pinnumber) {
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
		JLabel text = new JLabel("Select withdrawl ammount");
		text.setForeground(Color.WHITE);
		text.setBounds(200, 250, 700, 35);
		text.setFont(new Font("Raleway", Font.BOLD, 16));
		image.add(text);
		
		withrawHundred = new JButton("Rs 100");
		withrawHundred.setBounds(170, 370, 150, 28);
		withrawHundred.addActionListener(this);
		image.add(withrawHundred);
		
		withrawFiveHundred= new JButton("Rs 500");
		withrawFiveHundred.setBounds(355, 370, 150, 28);
		withrawFiveHundred.addActionListener(this);
		image.add(withrawFiveHundred);
		
		withrawOneThousand = new JButton("Rs 1000");
		withrawOneThousand.setBounds(170, 400, 150, 28);
		withrawOneThousand.addActionListener(this);
		image.add(withrawOneThousand);
		
		withrawTwoThousand = new JButton("Rs 2000");
		withrawTwoThousand.setBounds(355, 400, 150, 28);
		withrawTwoThousand.addActionListener(this);
		image.add(withrawTwoThousand);
		
		withrawFiveThousand = new JButton("Rs 5000");
		withrawFiveThousand.setBounds(170, 430, 150, 28);
		withrawFiveThousand.addActionListener(this);
		image.add(withrawFiveThousand);

		withrawTenThousand= new JButton("Rs 10000");
		withrawTenThousand.setBounds(355, 430, 150, 28);
		withrawTenThousand.addActionListener(this);
		image.add(withrawTenThousand);

		back = new JButton("BACK");
		back.setBounds(355, 460, 150, 28);
		back.addActionListener(this);
		image.add(back);

		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(900, 900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
		// unimplemented method of ActionListner
		
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource()== back) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
			else if(ae.getSource() == withrawHundred) {
				setVisible(false);
				new Deposit(pinnumber).setVisible(true);
			
			}else { 
/*				String ammount =((JButton) ae.getSource()).getText(); in this line getText 
				take a Rs 500 or other text from the other buttuon text  */
				
				
				String ammount =((JButton) ae.getSource()).getText().substring(3); /* but this line with 
				substring(3) remove first 3 character like Rs and one space so, we will get only numerical 
				value like 500, 100, 2000 and so on*/
			
			Connect c = new Connect();
			try {
				String query="select * from bank where pin = '"+pinnumber+"'";
				ResultSet rs = c.s.executeQuery(query);
				
				int balance=0;
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance +=Integer.parseInt(rs.getString("ammount")); /* this line return string so 
																			  we have to convert in Integer */
					
					}else {
						balance -= Integer.parseInt(rs.getString("ammount"));
					}
				}
				
				if(ae.getSource() != back && balance < Integer.parseInt(ammount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query1="insert into bank values('"+pinnumber+"', '"+date+"', 'withdrawl', '"+ammount+"')";
				c.s.executeUpdate(query1);
				
				JOptionPane.showMessageDialog(null, "Rs "+ammount+" Debited Successfully");
				
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			
			}
		}
		
	
	
	public static void main(String[] args) {
		
		new FastCash("");
	}
}
