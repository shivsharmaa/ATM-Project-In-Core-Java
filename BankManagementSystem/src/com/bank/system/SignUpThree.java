package com.bank.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUpThree extends JFrame implements ActionListener{
	String formno;
	JButton submit, cancel;
	JRadioButton saving, fixed, current, recurring;
	JCheckBox atm, declaration, chequeBook, internetBanking, mobileBanking, smsAlert, eStatement;
	
	
	SignUpThree(String formno){
		
		this.formno=formno;
		
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Accounts Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(250, 40, 400, 40);
		add(l1);
	
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD, 20));
		type.setBounds(100, 140, 200, 30);
		add(type);
	
		saving = new JRadioButton("Saving Account");
		saving.setFont(new Font("Raleway", Font.BOLD, 16));
		saving.setBackground(Color.WHITE);
		saving.setBounds(100, 180, 200, 20);
		add(saving);
		
		fixed= new JRadioButton("Fixed Deposite Account");
		fixed.setFont(new Font("Raleway", Font.BOLD, 16));
		fixed.setBackground(Color.WHITE);
		fixed.setBounds(350, 180, 250, 20);
		add(fixed);
		
		current= new JRadioButton("Current Account");
		current.setFont(new Font("Raleway", Font.BOLD, 16));
		current.setBackground(Color.WHITE);
		current.setBounds(100, 220, 200, 20);
		add(current);
		
		recurring= new JRadioButton("Recurring Deposite Account");
		recurring.setFont(new Font("Raleway", Font.BOLD, 16));
		recurring.setBackground(Color.WHITE);
		recurring.setBounds(350, 220, 250, 20);
		add(recurring);
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(saving);
		buttonGroup.add(current);
		buttonGroup.add(fixed);
		buttonGroup.add(recurring);
		
		
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 20));
		card.setBounds(100, 270, 200, 30);
		add(card);
		
		JLabel cardDetails = new JLabel("Your 16 digit Card Number");
		cardDetails.setFont(new Font("Raleway", Font.BOLD, 10));
		cardDetails.setBounds(100, 300, 200, 20);
		add(cardDetails);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raleway", Font.BOLD, 20));
		number.setBounds(330, 270, 300, 30);
		add(number);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 340, 200, 30);
		add(pin);
		
		JLabel pinDetails = new JLabel("Your 4 digit Password");
		pinDetails.setFont(new Font("Raleway", Font.BOLD, 10));
		pinDetails.setBounds(100, 370, 200, 20);
		add(pinDetails);
		
		JLabel pinNumber = new JLabel("XXXX");
		pinNumber.setFont(new Font("Raleway", Font.BOLD, 20));
		pinNumber.setBounds(330, 340, 300, 30);
		add(pinNumber);
		

	// Check box create and values
		
		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Raleway", Font.BOLD, 20));
		services.setBounds(100, 400, 300, 30);
		add(services);
		

		atm = new JCheckBox("ATM CARD");
		atm.setFont(new Font("Raleway",Font.BOLD, 16));
		atm.setBounds(100, 450, 200, 30);
		atm.setBackground(Color.WHITE);
		add(atm);

		internetBanking = new JCheckBox("Internet Banking");
		internetBanking.setFont(new Font("Raleway",Font.BOLD, 16));
		internetBanking.setBounds(350, 450, 200, 30);
		internetBanking.setBackground(Color.WHITE);
		add(internetBanking);
		
		mobileBanking = new JCheckBox("Mobile Banking");
		mobileBanking.setFont(new Font("Raleway",Font.BOLD, 16));
		mobileBanking.setBounds(100, 500, 200, 30);
		mobileBanking.setBackground(Color.WHITE);
		add(mobileBanking);
		
		smsAlert = new JCheckBox("Email and Sms alerts");
		smsAlert.setFont(new Font("Raleway",Font.BOLD, 16));
		smsAlert.setBounds(350, 500, 200, 30);
		smsAlert.setBackground(Color.WHITE);
		add(smsAlert);
		
		chequeBook = new JCheckBox("Cheque Book");
		chequeBook.setFont(new Font("Raleway",Font.BOLD, 16));
		chequeBook.setBounds(100, 550, 200, 30);
		chequeBook.setBackground(Color.WHITE);
		add(chequeBook);

		eStatement = new JCheckBox("E Statement");
		eStatement.setFont(new Font("Raleway",Font.BOLD, 16));
		eStatement.setBounds(350, 550, 200, 30);
		eStatement.setBackground(Color.WHITE);
		add(eStatement);
		
		declaration = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge");
		declaration.setFont(new Font("Raleway",Font.BOLD, 12));
		declaration.setBounds(100, 620, 600, 30);
		declaration.setBackground(Color.WHITE);
		add(declaration);
		
		//Button
		submit = new JButton("Submit");
		submit.setBackground(Color.BLUE);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway",Font.BOLD, 14));
		submit.setBounds(250, 660, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLUE);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway",Font.BOLD, 14));
		cancel.setBounds(420, 660, 100, 30);
		cancel.addActionListener(this);
		add(cancel);

		
		
		getContentPane().setBackground(Color.WHITE);		
		setSize(800, 820);
		setLocation(350, 0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == submit) {
				
				String accountType ="";
				if(saving.isSelected()) {
					accountType = "Saving Account";
				}
				else if(current.isSelected()) {
					accountType="Current Account";
				}
				else if(fixed.isSelected()) {
					accountType="Fixed Desposite Account";
				}
				else if(recurring.isSelected()) {
					accountType="Recurring Deposite Account";
				}
				
				Random random = new Random();
				String cardnumber = ""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
				String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
				
				String facility ="";
				if(atm.isSelected()) {
					facility = facility + "ATM CARD";
				
				}else if(mobileBanking.isSelected()) {
					facility = facility +"Mobile Banking";
				
				}else if(smsAlert.isSelected()) {
					facility = facility +"Email and Sms alert";
				
				}else if(internetBanking.isSelected()) {
					facility = facility + "Internet Banking";
				
				}else if(chequeBook.isSelected()) {
					facility=facility+"Cheque Book";
				
				}else if(eStatement.isSelected()){
					facility=facility+ " EStatement";
				
				}

				
				try {
					if(accountType.equals("")) {
						JOptionPane.showMessageDialog(null, "Account Type is Required");
					}else {
						
						
						// Queries
						Connect c = new Connect();
						String query = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"' ,'"
										+pinnumber+"','"+facility+"')";
						
						String query1 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
						
						//Exceute query
						c.s.executeUpdate(query);
						c.s.executeUpdate(query1);

						
						
						JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n Pin: "+pinnumber);
					
						setVisible(false);
						new Deposit(pinnumber).setVisible(false);
					
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(ae.getSource() == cancel) {
				setVisible(false);
				new Login().setVisible(true);
			}
	}
	
	public static void main(String[] args) {
		
		new SignUpThree("");
	}

} 
