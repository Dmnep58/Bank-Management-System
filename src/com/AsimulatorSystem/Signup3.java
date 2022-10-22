package com.AsimulatorSystem;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2554154440591207795L;

	//all the necessary parts of the frame declared
	JLabel PageTitleLabel;
	JLabel AccountLabel;
	JLabel CardnoLabel;
	JLabel CardNumberLabel;
	JLabel ABout1Label;
	JLabel About2Label;
	JLabel formnoLabel;
	JLabel PinLabel;
	JLabel PinNumberLabel;
	JLabel About3Label;
	JLabel ServiceLabel;
	JLabel FormLabel;
	
	JRadioButton savingLabel;
	JRadioButton FDLabel;
	JRadioButton CurrentLabel;
	JRadioButton RecurringLabel;
	
	JButton submitBtn;
	JButton CancelBtn;
	
	JCheckBox ATMBox;
	JCheckBox InternetBankingBox;
	JCheckBox MobileBankingBox;
	JCheckBox EmailsBox;
	JCheckBox ChequeBox;
	JCheckBox DecalreBox;
	JCheckBox SavingBox;
	
	@SuppressWarnings("unused")
	private String formno;
//	JTextField t1;
	
	
	//constructor created to initialize

//	JTextField t1;
	
	Signup signup = new Signup();
	//constructor created to initialize
	Signup3(){
		setBackground(new Color(255, 255, 255));
	    
		
		//styling the labels.
		
		PageTitleLabel=new JLabel("Page 3 : Account Details");
		PageTitleLabel.setForeground(Color.red);
		PageTitleLabel.setFont(new Font("Raleway",Font.BOLD,22));
		
		AccountLabel = new JLabel("Account Type:");
		AccountLabel.setFont(new Font("Raleway",Font.BOLD,18));
		
		CardnoLabel =new JLabel("Card Number:");
		CardnoLabel.setFont(new Font("Raleway",Font.BOLD,18));
		
		CardNumberLabel= new JLabel("xxxx-xxxx-xxxx-1234");
		CardNumberLabel.setFont(new Font("Raleway",Font.BOLD,18));
		
		ABout1Label = new JLabel("(Your 16 digit card Number)");
		ABout1Label.setFont(new Font("Dialog", Font.BOLD, 13));
		
		About2Label = new JLabel("It will apper on ATM card/cheque Book and Statements:");
		About2Label.setFont(new Font("Dialog", Font.BOLD, 13));
		
		PinLabel = new JLabel("PIN:");
		PinLabel.setFont(new Font("Raleway",Font.BOLD,18));
		
		PinNumberLabel = new JLabel("xxxx");
		PinNumberLabel.setFont(new Font("Raleway",Font.BOLD,18));
		
		About3Label = new JLabel("(4-digit Password)");
		About3Label.setFont(new Font("Dialog", Font.BOLD, 13));
		
		ServiceLabel= new JLabel("Services Required:");
		ServiceLabel.setFont(new Font("Raleway",Font.BOLD,18));
		
		FormLabel= new JLabel("formno");
		FormLabel.setFont(new Font("Raleway",Font.BOLD,14));
		
		//styling the buttons
		submitBtn = new JButton("Submit");
		submitBtn.setBorderPainted(false);
		submitBtn.setFont(new Font("Raleway",Font.BOLD,14));
		submitBtn.setBackground(Color.BLACK);
		submitBtn.setForeground(Color.WHITE);
		
		CancelBtn = new JButton("Cancel");
		CancelBtn.setBorderPainted(false);
		CancelBtn.setFont(new Font("Raleway",Font.BOLD,14));
		CancelBtn.setBackground(Color.BLACK);
		CancelBtn.setForeground(Color.WHITE);
		
		
		// checkbox styling
		
		ATMBox = new JCheckBox("ATM CARD");
		ATMBox.setBackground(new Color(255, 255, 255));
		ATMBox.setFont(new Font("Raleway",Font.BOLD,16));
		
		InternetBankingBox = new JCheckBox("INTERNET BANKING");
		InternetBankingBox.setBackground(new Color(255, 255, 255));
		InternetBankingBox.setFont(new Font("Raleway",Font.BOLD,16));
		
		MobileBankingBox = new JCheckBox("MOBILE BANKING");
		MobileBankingBox.setBackground(new Color(255, 255, 255));
		MobileBankingBox.setFont(new Font("Raleway",Font.BOLD,16));
		
		EmailsBox = new JCheckBox("EMAIL ALERTS");
		EmailsBox.setBackground(new Color(255, 255, 255));
		EmailsBox.setFont(new Font("Raleway",Font.BOLD,16));
		
		ChequeBox = new JCheckBox("CHEQUE BOOK");
		ChequeBox.setBackground(new Color(255, 255, 255));
		ChequeBox.setFont(new Font("Raleway",Font.BOLD,16));
		
		DecalreBox = new JCheckBox("I hereby declaresthat the above details correct to the best of my knowledge.",true);
		DecalreBox.setBackground(new Color(255, 255, 255));
		DecalreBox.setFont(new Font("Raleway",Font.BOLD,12));
		
		SavingBox = new JCheckBox("SAVING ACCOUNT");
		SavingBox.setBackground(new Color(255, 255, 255));
		SavingBox.setFont(new Font("Raleway",Font.BOLD,16));
		
		//radio button styling
		
		savingLabel = new JRadioButton("SAVING ACCOUNT");
		savingLabel.setBackground(new Color(255, 255, 255));
		savingLabel.setFont(new Font("Raleway",Font.BOLD,16));
		
		FDLabel = new JRadioButton("FIXED DEPOSIT ACCOUNT");
		FDLabel.setBackground(new Color(255, 255, 255));
		FDLabel.setFont(new Font("Raleway",Font.BOLD,16));
		
		CurrentLabel = new JRadioButton("CURRENT ACCOUNT");
		CurrentLabel.setBackground(new Color(255, 255, 255));
		CurrentLabel.setFont(new Font("Raleway",Font.BOLD,16));
		
		RecurringLabel = new JRadioButton("RECURRING DEPOSIT ACCOUNT");
		RecurringLabel.setBackground(new Color(255, 255, 255));
		RecurringLabel.setFont(new Font("Raleway",Font.BOLD,16));
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(savingLabel);
		groupaccount.add(FDLabel);
		groupaccount.add(CurrentLabel);
		groupaccount.add(RecurringLabel);
		
		
		//TEXT-FIELD STYLING
		
		formnoLabel = new JLabel(formno);
		formnoLabel.setFont(new Font("Raleway",Font.BOLD,12));
		formnoLabel.setText(signup.first);
		
		getContentPane().setLayout(null);
		
		// creating the bounds.
		
		FormLabel.setBounds(600,11,70,30);
		getContentPane().add(FormLabel);
		
		formnoLabel.setBounds(680,12,89,30);
		getContentPane().add(formnoLabel);
		
		PageTitleLabel.setBounds(226,50,252,30);
		getContentPane().add(PageTitleLabel);
		
		AccountLabel.setBounds(100,110,200,30);
		getContentPane().add(AccountLabel);
		
		savingLabel.setBounds(100,150,200,30);
		getContentPane().add(savingLabel);
		
		FDLabel.setBounds(350,150,300,30);
		getContentPane().add(FDLabel);
		
		CurrentLabel.setBounds(100,180,250,30);
		getContentPane().add(CurrentLabel);
		
		RecurringLabel.setBounds(350,180,300,30);
		getContentPane().add(RecurringLabel);
		
		CardnoLabel.setBounds(100,250,200,30);
		getContentPane().add(CardnoLabel);
		
		CardNumberLabel.setBounds(330,250,250,30);
		getContentPane().add(CardNumberLabel);
		
		ABout1Label.setBounds(100,291,200,29);
		getContentPane().add(ABout1Label);
		
		About2Label.setBounds(330,290,385,30);
		getContentPane().add(About2Label);
		
		PinLabel.setBounds(100,330,100,30);
		getContentPane().add(PinLabel);
		
		PinNumberLabel.setBounds(330,330,200,30);
		getContentPane().add(PinNumberLabel);
		
		About3Label.setBounds(100,370,200,30);
		getContentPane().add(About3Label);
		
		ServiceLabel.setBounds(100,411,200,30);
		getContentPane().add(ServiceLabel);
		
		ATMBox.setBounds(100,450,200,30);
		getContentPane().add(ATMBox);
		
		InternetBankingBox.setBounds(350,450,200,30);
		getContentPane().add(InternetBankingBox);
		
		MobileBankingBox.setBounds(100,500,200,30);
		getContentPane().add(MobileBankingBox);
		
		EmailsBox.setBounds(350,500,200,30);
		getContentPane().add(EmailsBox);
		
		ChequeBox.setBounds(100,547,200,30);
		getContentPane().add(ChequeBox);
		
		DecalreBox.setBounds(100,580,600,30);
		getContentPane().add(DecalreBox);
		
		SavingBox.setBounds(350,547,250,30);
		getContentPane().add(SavingBox);
		
		submitBtn.setBounds(300,620,100,30);
		getContentPane().add(submitBtn);
		
		CancelBtn.setBounds(420,620,100,30);
		getContentPane().add(CancelBtn);
		
		//creating the panel and providing it the styles
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(813,700);
		setLocation(200,0);
		setVisible(true);
		
		
		//providing actions to the buttons
		
		submitBtn.addActionListener(this);
		CancelBtn.addActionListener(this);
		
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	 
		 String atype ="";
		 if (savingLabel.isSelected()){
			 atype="Saving Account";
		 }
		 else if (FDLabel.isSelected()){
			 atype="Fixed Deposit Account";
		 }
		 else  if (CurrentLabel.isSelected()){
			 atype="Current Account";
		 }
		 else if (RecurringLabel.isSelected()){
			 atype="Recurring Deposit Account";
		 }
		 
		 
		 System.out.println(atype);
		
		Random ram = new Random();
		 long first7 = (ram.nextLong()%90000000L+3423452900000000L);
		 String cardno = ""+Math.abs(first7);
		
		 System.out.println(cardno);
		 
		 
		 long first3 = (ram.nextLong()%9000L+1000L);
		 String pin = ""+Math.abs(first3);
	
		 System.out.println(pin);
		 
		 String facility="";
		 if (ATMBox.isSelected()){
			 facility = facility+"Atm Card";
		 }
		 
			 if (InternetBankingBox.isSelected()){
				 facility=facility+"Internet Banking";
			 }
			 if (MobileBankingBox.isSelected()){
				 facility=facility+"Mobile Banking";
			 }
			 if (EmailsBox.isSelected()){
				 facility=facility+"Email Alert";
			 }
			 if (ChequeBox.isSelected()){
				 facility=facility+"Cheque Book";
			 }
			 if (DecalreBox.isSelected()){
				 facility=facility+"E-statement";
			 }
			 
			 System.out.println(facility);
			 
			 
			 String c = formnoLabel.getText();
			
			 
			 System.out.println(c);
			 
			 try {
				 if (e.getSource()==submitBtn){
					 if (facility.equals(" ")){
						 JOptionPane.showMessageDialog(null,"fill the required fields");
					 }
					 else {
						Connection connection =ConnectToDb.getConnection();
						
						 String q1="insert into signup3 values(? ,? ,? ,?, ?)";
						 PreparedStatement preparedStatement = connection.prepareStatement(q1);
						 preparedStatement.setString(1, atype);
						 preparedStatement.setString(2, cardno);
						 preparedStatement.setString(3, pin);
						 preparedStatement.setString(4, facility);
						 preparedStatement.setString(5, c);
						 
						 preparedStatement.executeUpdate();
						 
						 String q2="insert into login values('"+cardno+"','"+pin+"')";
						 PreparedStatement pStatement = connection.prepareStatement(q2);
						 pStatement.executeUpdate();
						
						
						JOptionPane.showMessageDialog(null,"Card number "+cardno+"\n"+"pin Number "+pin);
						
						new Deposits().setVisible(true);
						setVisible(false);
					 }
				 }
				 else if (e.getSource()==CancelBtn){
					 System.exit(0);
				 }
			 } catch (SQLException ex) {
				 ex.printStackTrace();
			 }
		
		
	}
	
	public static void main(String[] args) {
		Signup3 s3 =new Signup3();
		s3.setResizable(false);
		s3.setVisible(true);
	}
}
