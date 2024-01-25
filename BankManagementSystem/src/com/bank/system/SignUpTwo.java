package com.bank.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpTwo extends JFrame implements ActionListener{
	String formno;
	JTextField  panNumberTextField, aadharTextField;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	
	JComboBox jreligion, jcategory,jincome,jeducation,joccupation;
	
	public SignUpTwo(String formno) {
		this.formno=formno;
		
		setLayout(null);
		setTitle("New Account Application Form - Page 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
 		additionalDetails.setBounds(290, 60, 400, 30);
		add(additionalDetails);
		
		JLabel religion = new JLabel("Religion: ");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		// Religion Dropdown
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
		jreligion = new JComboBox(valReligion);
		jreligion.setBounds(300, 140, 400, 30);
		jreligion.setBackground(Color.WHITE);
		add(jreligion); 
				
		
				
		JLabel category= new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);
		add(category);

		// category dropdown
		String valCategory[]= { "General", "OBC","SC","ST","Other"};
		jcategory = new JComboBox(valCategory);
		jcategory.setBounds(300, 190, 400, 30);
		jcategory.setBackground(Color.WHITE);
		add(jcategory);
		

	
		JLabel income= new JLabel("Income");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		// Income dropdown
		String valIncome[]= { "Null", "<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		jincome= new JComboBox(valIncome);
		jincome.setBounds(300, 240, 400, 30);
		jincome.setBackground(Color.WHITE);
		add(jincome);

				
		JLabel educational= new JLabel("Educational");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 290, 200, 30);
		add(educational);
		
		JLabel qualification= new JLabel("Qaulification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);

		// Education dropdown
		String educationValues[]= { "Non-Graduation", "Graduate","Post-Graduation","Doctrate","Masters", "Other"};
		jeducation= new JComboBox(educationValues);
		jeducation.setBounds(300, 300, 400, 30);
		jeducation.setBackground(Color.WHITE);
		add(jeducation);

		
		JLabel occupation= new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 360, 200, 30);
		add(occupation);

		// occupation dropdown
		String occupationValues[]= { "Student", "Salried","Self-employed","Business","Retired", "Other"};
		joccupation= new JComboBox(occupationValues);
		joccupation.setBounds(300, 365, 400, 30);
		joccupation.setBackground(Color.WHITE);
		add(joccupation);
		
		JLabel panNumber= new JLabel("Pan Number:");
		panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
		panNumber.setBounds(100, 440, 200, 30);
		add(panNumber);
		
		//JTextField
		panNumberTextField = new JTextField();
		panNumberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panNumberTextField.setBounds(300, 440, 400, 30);
		add(panNumberTextField);

		
		JLabel city= new JLabel("Aadhar Number:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		// JTextField
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);

		
		JLabel seniorCitizen= new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorCitizen.setBounds(100, 540, 200, 30);
		add(seniorCitizen);
		
		// seniorCitizen Radio Button
		syes = new JRadioButton("Yes");
		syes.setBounds(300, 540, 60,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(390, 540, 60,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorCitizenGroup = new ButtonGroup();
		seniorCitizenGroup.add(syes);
		seniorCitizenGroup.add(sno);
		
	
		JLabel existingAccount= new JLabel("Exisiting Account:");
		existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
		existingAccount.setBounds(100, 590, 200, 30);
		add(existingAccount);

		// existing account Radio Button
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300, 590, 60,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		

		eno = new JRadioButton("No");
		eno.setBounds(390, 590, 80,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existingAccountGroup = new ButtonGroup();
		existingAccountGroup.add(eyes);
		existingAccountGroup.add(eno);


		
		// JButton
		next = new JButton("Next");
		next.setBackground(Color.BLUE);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setSize(800, 800);
		setLocation(350, 10);
		setVisible(true);
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		String sreligion = (String) jreligion.getSelectedItem();
		String scategory = (String) jcategory.getSelectedItem();
		String sincome = (String) jincome.getSelectedItem();
		String seducation = (String) jeducation.getSelectedItem();
		String soccupation = (String) joccupation.getSelectedItem();

		
		String seniorCitizen= null;
		if(syes.isSelected()) {
			seniorCitizen = "Yes";
		}else if(sno.isSelected()) {
			seniorCitizen = "No";
		}
		
		String existingAccount=null;

		if(eyes.isSelected()) {
			existingAccount="Yes";
		}else if(eno.isSelected()) {
			existingAccount= "No";
		}
		
		
		String spanNumber= panNumberTextField.getText();
		String saadharNumber= aadharTextField.getText();
	
		
		try {
				Connect c = new Connect();
				String query = "insert into signuptwo values('"+formno+"','"+jreligion+"','"+jcategory+"' ,'"
				+jincome+"','"+jeducation+"','"+joccupation+"','"
						+spanNumber+"','"+saadharNumber+"','"+seniorCitizen+"','"+existingAccount+"')";
				
				c.s.executeUpdate(query);
			
		// SignUPThree Object
		setVisible(false);
		new SignUpThree(formno).setVisible(true);
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
	
	}
	public static void main(String[] args) {
		
		new SignUpTwo("");
	}
}
