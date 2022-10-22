package com.AsimulatorSystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Signup extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4451810944593024834L;
	
	JLabel TitleLabel;
	JLabel ApplicationPage1Label;
	JLabel Name;
	JLabel FatherName;
	JLabel DOBLabel;
	JLabel GenderLabel;
	JLabel EmailLabel;
	JLabel MaritalLabel;
	JLabel AddressLabel;
	JLabel CityLabel;
	JLabel l11;
	JLabel StateLabel;
	JLabel DayLabel;
	JLabel monthLabel;
	JLabel YearLabel;
	
	
	
	JTextField NameField;
	JTextField FatherNameField;
	JTextField EmailField;
	JTextField AddressField;
	JTextField CityField;
	JTextField PinCodeField;
	JTextField StateField;
	
	
	JRadioButton MaleField;
	JRadioButton FemaleField;
	JRadioButton Other;
	JRadioButton married;
	JRadioButton unmarried;
	
	
	JButton Nextbtn;
	
	@SuppressWarnings("rawtypes")
	JComboBox DayBox;
	@SuppressWarnings("rawtypes")
	JComboBox MonthBox;
	@SuppressWarnings("rawtypes")
	JComboBox YearBox;
	
	Random ram = new Random();
	long first4 = (ram.nextLong()%900L)+1000L;
	String first = " "+Math.abs(first4);
	
	private JLabel PinCodeLabel;
	private JButton btnNewButton;
	
	
	public boolean insertion1() {
		boolean	isinserted=false;
		String formno= first;
		   String name=NameField.getText();
		   
		   String fname = FatherNameField.getText();
		   
		   //for date input
		   String ac =(String) DayBox.getSelectedItem();
		   String bc=(String) MonthBox.getSelectedItem();
		   String cc= (String) YearBox.getSelectedItem();
		   String combineddateString = ac+bc+cc;	
		   Date date1 = null;
		   
		try {
			date1 = new SimpleDateFormat("ddMMMyyyy").parse(combineddateString);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
			 
			 long date2 = date1.getTime();
			 java.sql.Date date =new java.sql.Date(date2);
		  
		   
			 
			//for gender input
		   String gender =null;
		   if (MaleField.isSelected()){
			   gender="Male";
		   }
		   else if (FemaleField.isSelected()){
			   gender="Female";
		   }
		   else {
			   gender="other";
		   }
		   
		   
		   
		   
		   //for martial input
		   String marital =null;
		   if (married.isSelected()){
			   marital="Married";
		   }
		   else {
			   marital="Unmarried";
		   }
		   
		   
		   
		   String email = EmailField.getText();
		   String address = AddressField.getText();
		   String city =CityField.getText();
		   String pincode1 = PinCodeField.getText();
		   String state = StateField.getText();
		   
		   int pincode =Integer.parseInt(pincode1);
		   try{
			   
			   if (PinCodeField.getText().equals("")){
				   JOptionPane.showMessageDialog(null,"FILL ALL THE REQUIRED FIELDS");
			   }
			   else{
				  Connection connection = ConnectToDb.getConnection();
				  
				   // SQL insertion query to store the inputed data in database.
				  
				   String query = "insert into Signup values(?, ?,?,?,?,?,?,?,?,?,?,?)" ;
				   
				   PreparedStatement preparedStatement= connection.prepareStatement(query);
				   
				   preparedStatement.setString(1, formno);
				   preparedStatement.setString(2, name);
				   preparedStatement.setString(3, fname);
				   preparedStatement.setDate(4, date);
				   preparedStatement.setString(5, gender);
				   preparedStatement.setString(6, email);			  
				   preparedStatement.setString(7, marital);
				   preparedStatement.setString(8, address);
				   preparedStatement.setString(9, city);
				   preparedStatement.setInt(10, pincode);
				   preparedStatement.setString(11, state);
				   preparedStatement.setString(12, first);
				      
				   int rowcount = preparedStatement.executeUpdate();
				   
				   if(rowcount>0) {
					   isinserted=true;
				   }
				   else {
					   isinserted=false;
					JOptionPane.showMessageDialog(AddressField, "unsuccess");
				}
				   
			   }
		   
		   } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return isinserted;
		}
		
		public static void main(String[] args) {
		Signup	s=new Signup();
		s.setResizable(false);
		s.setVisible(true);
		}

	
	//initialization of sing-in using constructors.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Signup(){
		setUndecorated(true);
		
		JLabel l11 = new JLabel("NEW ACCOUNT APPLICATION FORM");
		l11.setBounds(16,0,100,100);
		getContentPane().add(l11);
		
		 // creating the labels and styling them.
		 TitleLabel = new JLabel("APPLICATION FORM NO. "+first);
		 TitleLabel.setForeground(Color.red);
		 TitleLabel.setFont(new Font("Raleway",Font.BOLD,38));
		 
		 ApplicationPage1Label= new JLabel("Page 1: PERSONAL DETAILS");
		ApplicationPage1Label.setFont(new Font("Raleway",Font.BOLD,20));
		
		Name= new JLabel("Name:");
		Name.setFont(new Font("Raleway",Font.BOLD,20));
		
		FatherName=new JLabel("Father's Name:");
		FatherName.setFont(new Font("Raleway",Font.BOLD,20));
		
		DOBLabel = new JLabel("Date of Birth:");
		DOBLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		GenderLabel= new JLabel("Gender:");
		GenderLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		EmailLabel = new JLabel("Email Address:");
		EmailLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		MaritalLabel = new JLabel("Marital Status:");
		MaritalLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		AddressLabel= new JLabel("Address:");
		AddressLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		CityLabel= new JLabel("City:");
		CityLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		PinCodeLabel= new JLabel("PIN Code:");
		PinCodeLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		StateLabel=new JLabel("State:");
		StateLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		DayLabel=new JLabel("Day:");
		DayLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		monthLabel=new JLabel("Month:");
		monthLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		YearLabel=new JLabel("Year:");
		YearLabel.setFont(new Font("Raleway",Font.BOLD,20));
		
		
		//creating the text field and styling them:
		
		NameField=new JTextField();
		NameField.setFont(new Font("Raleway",Font.BOLD,14));
		
		FatherNameField=new JTextField();
		FatherNameField.setFont(new Font("Raleway",Font.BOLD,14));
		
		EmailField=new JTextField();
		EmailField.setFont(new Font("Raleway",Font.BOLD,14));
		
		AddressField=new JTextField();
		AddressField.setFont(new Font("Raleway",Font.BOLD,14));
		
		CityField=new JTextField();
		CityField.setFont(new Font("Raleway",Font.BOLD,14));
		
		PinCodeField=new JTextField();
		PinCodeField.setFont(new Font("Raleway",Font.BOLD,14));
		
		StateField=new JTextField();
		StateField.setFont(new Font("Raleway",Font.BOLD,14));
		
		// creating the button and styling it
		
		Nextbtn= new JButton("NEXT-->");
		Nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(insertion1()==true) {
					Signup2 signup2 = new Signup2();
					signup2.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(l11, "failure");
				}
			}
		});
		Nextbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Nextbtn.setBorderPainted(false);
		Nextbtn.setFont(new Font("Raleway",Font.BOLD,14));
		Nextbtn.setBackground(Color.black);
		Nextbtn.setForeground(Color.WHITE);
		
		//creating and styling the radio buttons
		
		MaleField =new JRadioButton("Male");
		MaleField.setFont(new Font("Raleway3",Font.BOLD,14));
		
		FemaleField=new JRadioButton("Female");
		FemaleField.setFont(new Font("Raleway3",Font.BOLD,14));
		
		Other = new JRadioButton("Other");
		Other.setFont(new Font("Dialog", Font.BOLD, 14));
		
		married =new JRadioButton("Married");
		married.setFont(new Font("Raleway3",Font.BOLD,14));
		
		unmarried =new JRadioButton("Unmarried");
		unmarried.setFont(new Font("Raleway3",Font.BOLD,14));
		
		//creating and styling the combo box
		
		String date[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
		DayBox = new JComboBox(date);
		DayBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DayBox.setBackground(Color.WHITE);

		String month[]={"january","february","march","april","may","june","july","august","september","october","november","december"};
		MonthBox = new JComboBox(month);
		MonthBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MonthBox.setBackground(Color.WHITE);

		String year[]={"1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
		YearBox = new JComboBox(year);
		YearBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		YearBox.setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		TitleLabel.setBounds(140,20,600,40);
		getContentPane().add(TitleLabel);
		
		ApplicationPage1Label.setBounds(290,70,325,30);
		getContentPane().add(ApplicationPage1Label);
		
		Name.setBounds(100,140,122,30);
		getContentPane().add(Name);
		
		NameField.setBounds(300,140,538,30);
		getContentPane().add(NameField);
		
		FatherName.setBounds(100,190,200,30);
		getContentPane().add(FatherName);
		
		FatherNameField.setBounds(300,190,538,30);
		getContentPane().add(FatherNameField);
		
		DOBLabel.setBounds(100,240,158,30);
		getContentPane().add(DOBLabel);
		
		DayLabel.setBounds(300,235,60,40);
		getContentPane().add(DayLabel);
		
		DayBox.setBounds(360,240,67,30);
		getContentPane().add(DayBox);
		
		monthLabel.setBounds(453,240,80,30);
		getContentPane().add(monthLabel);
		
		MonthBox.setBounds(543,244,100,26);
		getContentPane().add(MonthBox);
		
		YearLabel.setBounds(668,240,80,30);
		getContentPane().add(YearLabel);
		
		YearBox.setBounds(758,244,80,26);
		getContentPane().add(YearBox);
		
//		c3.setBounds(610,240,40,30);
//		add(c3);
		
		GenderLabel.setBounds(100,290,100,30);
		getContentPane().add(GenderLabel);
		
		MaleField.setBounds(300,290,90,30);
		getContentPane().add(MaleField);
		
		FemaleField.setBounds(450,290,90,30);
		getContentPane().add(FemaleField);
		
		Other.setBounds(582, 290, 90, 30);
		getContentPane().add(Other);
		
		ButtonGroup groupgender = new ButtonGroup();
		groupgender.add(MaleField);
		groupgender.add(FemaleField);
		groupgender.add(Other);
		
		
		EmailLabel.setBounds(100,340,158,30);
		getContentPane().add(EmailLabel);
		
		EmailField.setBounds(300,340,538,30);
		getContentPane().add(EmailField);
		
		MaritalLabel.setBounds(100,390,180,30);
		getContentPane().add(MaritalLabel);
		
		married.setBounds(300,390,100,30);
		getContentPane().add(married);
		
		unmarried.setBounds(450,390,100,30);
		getContentPane().add(unmarried);
		
		ButtonGroup groupstatus = new ButtonGroup();
		groupstatus.add(married);
		groupstatus.add(unmarried);
		
		
		AddressLabel.setBounds(100,440,200,30);
		getContentPane().add(AddressLabel);
		
		AddressField.setBounds(300,440,538,30);
		getContentPane().add(AddressField);
		
		CityLabel.setBounds(100,490,200,30);
		getContentPane().add(CityLabel);
		
		CityField.setBounds(300,490,538,30);
		getContentPane().add(CityField);
		
		PinCodeLabel.setBounds(100,540,200,30);
		getContentPane().add(PinCodeLabel);
		
		PinCodeField.setBounds(300,540,538,30);
		getContentPane().add(PinCodeField);
		
		StateLabel.setBounds(100,590,200,30);
		getContentPane().add(StateLabel);
		
		StateField.setBounds(300,590,538,30);
		getContentPane().add(StateField);
		
		Nextbtn.setBounds(702,639,100,35);
		getContentPane().add(Nextbtn);
		
		
		
		getContentPane().setBackground(new Color(255, 255, 255));
		
	
		
		
		JButton BACKLABEL = new JButton("Back To Login");
		BACKLABEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginBank loginBank = new LoginBank();
				loginBank.setVisible(true);
				dispose();
			}
		});
		BACKLABEL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BACKLABEL.setForeground(Color.WHITE);
		BACKLABEL.setFont(new Font("Dialog", Font.BOLD, 14));
		BACKLABEL.setBorderPainted(false);
		BACKLABEL.setBackground(Color.BLACK);
		BACKLABEL.setBounds(140, 639, 140, 35);
		getContentPane().add(BACKLABEL);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnNewButton.setBounds(737, 52, 89, 23);
		getContentPane().add(btnNewButton);
		
		setSize(900,750);
		setLocation(200,0);
		setVisible(true);
		
	}
	
	
	}
