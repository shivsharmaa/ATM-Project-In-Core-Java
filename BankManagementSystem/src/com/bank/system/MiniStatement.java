package com.bank.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.cj.protocol.Resultset;

public class MiniStatement extends JFrame implements ActionListener{

	String pinnumber;
	JButton back;
	public MiniStatement(String pinnumber) {
			this.pinnumber=pinnumber;
		
			setTitle("Mini Statement");
			setLayout(null);
			
			
			
			JLabel mini = new JLabel();
			mini.setBounds(20, 140, 400, 200);
			add(mini);
			
			JLabel bank = new JLabel("Inidan Bank");
			bank.setBounds(150, 20, 100, 20);
			add(bank);
			
			JLabel card = new JLabel("Card Number");
			card.setBounds(20, 80, 300, 20);
			add(card);
			
			
			JLabel balance = new JLabel();
			balance.setBounds(20, 400, 300, 20);
			add(balance);
			
			 back = new JButton("BACK");
			back.setBounds(150, 450, 150, 30);
			back.addActionListener(this);
			add(back);
			
			try {
			
				Connect c = new Connect();
				ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
				
				while(rs.next()) {
					card.setText("Card number: "+rs.getString("cardnumber").substring(0, 4)+
							"XXXXXXXX"+rs.getString("cardnumber").substring(12));
					
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			try {
				Connect c = new Connect();
				int bal=0;
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				
				
			
				
				String str ="<html>";
				while(rs.next()) {
					str+= "" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
				rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("ammount")+"<br><br> ";
				
					
					if(rs.getString("type").equals("Deposit")) {
						bal +=Integer.parseInt(rs.getString("ammount")); /* this line return string so 
																			  we have to convert in Integer */
					
					}else {
						bal -= Integer.parseInt(rs.getString("ammount"));
					}
				}
				
				str+="</html>";
				mini.setText(str);
				balance.setText("Your current account balance is Rs "+bal);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			
			
			getContentPane().setBackground(Color.WHITE);;
			setSize(400, 600);
			setLocation(20, 20);
			setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		
		new MiniStatement("");
	}


}

