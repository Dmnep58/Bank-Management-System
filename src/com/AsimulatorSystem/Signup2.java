package com.AsimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup2 extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4574463773698246103L;
	// required numbers of the fields.
	JLabel PageTitleLabel;
	JLabel ReligionLabel;
	JLabel CategoryLabel;
	JLabel IncomeLabel;
	JLabel EducationLabel;
	JLabel OccupationLabel;
	JLabel PanLabel;
	JLabel CitizennumLabel;
	JLabel Seniorcitizenlabel;
	JLabel AccountLabel;
	JLabel FormNoLabel;
	
	
	JTextField PanField;
	JTextField CitizenField;

	
	JRadioButton SenoirRadio;
	JRadioButton SeniorRadio2;
	JRadioButton AccountSRadio;
	JRadioButton AccountNRadio;
	
	JButton btnNext;
	
	@SuppressWarnings("rawtypes")
	JComboBox ReligionBox, CategoryBox, IncomeBox, EducationBox, OccupationBox;
	String formno;
	
	
	
	//created a constructor.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Signup2() {
		setUndecorated(true);
		
		
		
		
		
		//declaring and styling the lables.
		PageTitleLabel = new JLabel("Page 2: Additional Details");
		PageTitleLabel.setForeground(Color.red);
		PageTitleLabel.setFont(new Font("Raleway", Font.BOLD, 22));
		
		ReligionLabel = new JLabel("Religion: ");
		ReligionLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		CategoryLabel = new JLabel("Category:");
		CategoryLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		IncomeLabel = new JLabel("Income:");
		IncomeLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		EducationLabel = new JLabel("Educational:");
		EducationLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		OccupationLabel = new JLabel("occupation:");
		OccupationLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		PanLabel = new JLabel("PAN Number:");
		PanLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		CitizennumLabel = new JLabel("citizen Number:");
		CitizennumLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		Seniorcitizenlabel = new JLabel("Senior Citizen:");
		Seniorcitizenlabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		AccountLabel = new JLabel("Existing Account:");
		AccountLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		FormNoLabel = new JLabel("Form No:");
		FormNoLabel.setFont(new Font("Raleway", Font.BOLD, 16));
		
		//button styling.
		
		btnNext = new JButton("Next");
		btnNext.setBorderPainted(false);
		btnNext.setFont(new Font("Raleway", Font.BOLD, 14));
		btnNext.setBackground(Color.BLACK);
		btnNext.setForeground(Color.WHITE);
		
		//text-field initializing and declaring
		
		PanField = new JTextField();
		PanField.setFont(new Font("Raleway", Font.BOLD, 14));
		
		CitizenField = new JTextField();
		CitizenField.setFont(new Font("Raleway", Font.BOLD, 14));
		

		
		
		// radio buttons initializing and styling
		
		SenoirRadio = new JRadioButton("yes");
		SenoirRadio.setFont(new Font("Raleway", Font.BOLD, 14));
		SenoirRadio.setBackground(Color.WHITE);
		
		SeniorRadio2 = new JRadioButton("NO");
		SeniorRadio2.setFont(new Font("Raleway", Font.BOLD, 14));
		SeniorRadio2.setBackground(Color.WHITE);
		
		ButtonGroup groupradio = new ButtonGroup();
		groupradio.add(SenoirRadio);
		groupradio.add(SeniorRadio2);
		
		AccountSRadio = new JRadioButton("yes");
		AccountSRadio.setFont(new Font("Raleway", Font.BOLD, 14));
		AccountSRadio.setBackground(Color.WHITE);
		
		AccountNRadio = new JRadioButton("NO");
		AccountNRadio.setFont(new Font("Raleway", Font.BOLD, 14));
		AccountNRadio.setBackground(Color.WHITE);
		
		ButtonGroup groupradio2 = new ButtonGroup();
		groupradio2.add(AccountSRadio);
		groupradio2.add(AccountNRadio);
		
		
		// initializing declaring and styling the combo box
		String[] religion = {"Hindu", "Muslim", "Sikh", "Christian", "others"};
		ReligionBox = new JComboBox(religion);
		ReligionBox.setBackground(Color.WHITE);
		ReligionBox.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String[] category = {"General", "OBC", "sc", "ST", "others"};
		CategoryBox = new JComboBox(category);
		CategoryBox.setBackground(Color.WHITE);
		CategoryBox.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String[] income = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Above 10,00,000"};
		IncomeBox = new JComboBox(income);
		IncomeBox.setBackground(Color.WHITE);
		IncomeBox.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String[] education = {"Non-Graduate", "Graduate", "post-Graduate", "Doctrate", "others"};
		EducationBox = new JComboBox(education);
		EducationBox.setBackground(Color.WHITE);
		EducationBox.setFont(new Font("Raleway", Font.BOLD, 14));
		
		String[] occupation = {"Salaried", "Self-Employeed", "Business", "Student", "Retired", "others"};
		OccupationBox = new JComboBox(occupation);
		OccupationBox.setBackground(Color.WHITE);
		OccupationBox.setFont(new Font("Raleway", Font.BOLD, 14));
		
		getContentPane().setLayout(null);
		
		
		//setting the bounds according to the lines.
		FormNoLabel.setBounds(538, 11, 132, 30);
		getContentPane().add(FormNoLabel);
		
//		t3.setBounds(760, 10, 60, 30);
//		add(t3);
		
		PageTitleLabel.setBounds(203, 44, 280, 40);
		getContentPane().add(PageTitleLabel);
		
		ReligionLabel.setBounds(42, 119, 100, 30);
		getContentPane().add(ReligionLabel);
		
		ReligionBox.setBounds(257, 120, 320, 30);
		getContentPane().add(ReligionBox);
		
		CategoryLabel.setBounds(42, 169, 100, 30);
		getContentPane().add(CategoryLabel);
		
		CategoryBox.setBounds(257, 170, 320, 30);
		getContentPane().add(CategoryBox);
		
		IncomeLabel.setBounds(42, 219, 100, 30);
		getContentPane().add(IncomeLabel);
		
		IncomeBox.setBounds(257, 220, 320, 30);
		getContentPane().add(IncomeBox);
		
		EducationLabel.setBounds(42, 269, 150, 30);
		getContentPane().add(EducationLabel);
		
		EducationBox.setBounds(257, 270, 320, 30);
		getContentPane().add(EducationBox);
		
		OccupationLabel.setBounds(42, 339, 150, 30);
		getContentPane().add(OccupationLabel);
		
		OccupationBox.setBounds(257, 340, 320, 30);
		getContentPane().add(OccupationBox);
		
		PanLabel.setBounds(42, 388, 150, 30);
		getContentPane().add(PanLabel);
		
		PanField.setBounds(257, 390, 320, 30);
		getContentPane().add(PanField);
		
		CitizennumLabel.setBounds(42, 438, 180, 30);
		getContentPane().add(CitizennumLabel);
		
		CitizenField.setBounds(257, 440, 320, 30);
		getContentPane().add(CitizenField);
		
		Seniorcitizenlabel.setBounds(42, 489, 150, 30);
		getContentPane().add(Seniorcitizenlabel);
		
		SenoirRadio.setBounds(257, 490, 100, 30);
		getContentPane().add(SenoirRadio);
		
		SeniorRadio2.setBounds(401, 490, 100, 30);
		getContentPane().add(SeniorRadio2);
		
		AccountLabel.setBounds(42, 550, 180, 30);
		getContentPane().add(AccountLabel);
		
		AccountSRadio.setBounds(257, 551, 100, 30);
		getContentPane().add(AccountSRadio);
		
		AccountNRadio.setBounds(401, 551, 100, 30);
		getContentPane().add(AccountNRadio);
		
		btnNext.setBounds(527, 580, 100, 30);
		getContentPane().add(btnNext);
		
		btnNext.addActionListener(this);
		
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setSize(703, 662);
		setLocation(200, 20);
		setVisible(true);
	}
	
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String religion = (String) ReligionBox.getSelectedItem();
		String category = (String) CategoryBox.getSelectedItem();
		String income = (String) IncomeBox.getSelectedItem();
		String education = (String) EducationBox.getSelectedItem();
		String occupation = (String) OccupationBox.getSelectedItem();
		
		int pan = Integer.parseInt(PanField.getText());
		int citizen = Integer.parseInt(CitizenField.getText());
		
		
		String senior = " ";
		if (SenoirRadio.isSelected()) {
			senior = "yes";
		} else if (SeniorRadio2.isSelected()) {
			senior = "No";
		}
		
		String account = " ";
		if (AccountSRadio.isSelected()) {
			account = "yes";
		} else if (AccountNRadio.isSelected()) {
			account = "No";
		}
		
		try {
			if (CitizenField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "PLEASE FILL ALL REQUIRED FIELDS");
			} else {
				Connection connection =ConnectToDb.getConnection();
				String q1 = "insert into Signup2 values('" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + citizen + "','" + senior + "','" + account + "')";
				PreparedStatement preparedStatement =connection.prepareStatement(q1);
				
				preparedStatement.executeUpdate();
				
				new Signup3().setVisible(true);
				setVisible(false);
				
			}
			if (e.getSource()==btnNext){
				new Signup3().setVisible(true);
				setVisible(false);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Signup2 s2=new Signup2();
		s2.setVisible(true);
		s2.setResizable(false);
	}
}