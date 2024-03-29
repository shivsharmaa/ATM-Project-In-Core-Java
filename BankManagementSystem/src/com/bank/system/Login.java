package com.bank.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
//JFRAME is a frame in which we are showing our data
	// Action Listner is a interface in which we perform action through the button

	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login(){
		setTitle("Automatic Teller Machine");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); 
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 90, 90);
		add(label);

		// Text format
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 250, 30);
		add(cardno);
		
		//Text field Name
		cardTextField = new JTextField();
		cardTextField.setBounds(300, 150, 230, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField );
		
		JLabel pin = new JLabel("PIN");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(120, 220, 250, 30);
		add(pin);

		//Input field
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300, 220, 230, 30);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField );

		
		// creating SIGN IN button
		login = new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);

		// creating Clear Button buttoon
		clear = new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);		
		add(clear);

		// creating SIGN UP Button buttoon
		signup = new JButton("SIGN UP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		// for JFRAME Color
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true); // by default visible is hidden or false
		setLocation(350, 150);

	}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == clear) {
				cardTextField.setText("");
				pinTextField.setText("");
			}
			else if(ae.getSource() == login) {
				Connect c = new Connect();
				String cardnumber = cardTextField.getText();
				String pinnumber = pinTextField.getText();
				
				String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
				
				try {
					ResultSet rs = c.s.executeQuery(query);
					
					if(rs.next()) {
						setVisible(false);
						new Transaction(pinnumber).setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Card Number and Pin");
					}
					
					
					
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(ae.getSource() == signup) {
				setVisible(false);
				new SignUpOne().setVisible(true);
			}
		}
		
		
	public static void main(String[] args) {
		 new Login();
	}
		
	}

