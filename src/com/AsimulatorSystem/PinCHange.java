package com.AsimulatorSystem;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PinCHange extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1591081048549575220L;
	JLabel TitleLabel;
	JLabel CurrentPinLabel;
	JLabel NewPinLabel;
	JLabel REPINLabel;
	JTextField CurrentPinField;
	JTextField NewPinField;
	JTextField RepinField;
	JButton changebtn;
	JButton Backbtn;
	String pin;

	PinCHange(){
		
		//styling and declaring the labels, text-fields, buttons

		TitleLabel=new JLabel("CHANGE YOUR PIN");
		TitleLabel.setFont(new Font("System",Font.BOLD,35));

		CurrentPinLabel = new JLabel("	Current Pin");
		CurrentPinLabel.setFont(new Font("System",Font.BOLD,22));

		NewPinLabel= new JLabel("New Pin");
		NewPinLabel.setFont(new Font("System",Font.BOLD,22));

		REPINLabel = new JLabel("Re-Enter the new Pin");
		REPINLabel.setFont(new Font("System",Font.BOLD,20));

		CurrentPinField = new JTextField();
		CurrentPinField.setFont(new Font("Raleway",Font.BOLD,22));

		NewPinField = new JTextField();
		NewPinField.setFont(new Font("Raleway",Font.BOLD,22));

		RepinField = new JTextField();
		RepinField.setFont(new Font("Raleway",Font.BOLD,22));

		changebtn= new JButton("Change");
		changebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changebtn.setBorderPainted(false);
		changebtn.setFont(new Font("Raleway",Font.BOLD,18));
		changebtn.setBackground(Color.BLACK);
		changebtn.setForeground(Color.WHITE);

		Backbtn= new JButton("Back");
		Backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Backbtn.setBorderPainted(false);
		Backbtn.setFont(new Font("Raleway",Font.BOLD,18));
		Backbtn.setBackground(Color.BLACK);
		Backbtn.setForeground(Color.WHITE);

		//providing action-listeners to buttons

		changebtn.addActionListener(this);
		Backbtn.addActionListener(this);

		getContentPane().setLayout(null);

		// provinds and setting the locations of all the labels text-field and buttons

		TitleLabel.setBounds(146,11,353,60);
		getContentPane().add(TitleLabel);

		CurrentPinLabel.setBounds(61,114,150,40);
		getContentPane().add(CurrentPinLabel);

		NewPinLabel.setBounds(61,182,150,40);
		getContentPane().add(NewPinLabel);

		REPINLabel.setBounds(61,259,213,40);
		getContentPane().add(REPINLabel);

		CurrentPinField.setBounds(267,115,360,40);
		getContentPane().add(CurrentPinField);

		NewPinField.setBounds(267,183,360,40);
		getContentPane().add(NewPinField);

		RepinField.setBounds(267,259,360,40);
		getContentPane().add(RepinField);

		changebtn.setBounds(146,332,160,50);
		getContentPane().add(changebtn);

		Backbtn.setBounds(412,332,160,50);
		getContentPane().add(Backbtn);


		// styling the panel
		getContentPane().setBackground(Color.WHITE);
		setSize(658,424);
		setUndecorated(true);
		setLocation(200,0);
		setVisible(true);

	}
	
	// to check  users pin
		public boolean checkpin() {
			String pinString = CurrentPinField.getText();
			
			boolean isexists= false;
			
			try {
				
				Connection connection = ConnectToDb.getConnection();
				
				PreparedStatement pst = connection.prepareStatement("select * from login where pin = ?");
				pst.setString(1,pinString );
				
				ResultSet rSet= pst.executeQuery();
				
				if(rSet.next()) {
					isexists = true;
				}
				else {
					isexists = false;
				}
				
				
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return isexists;
		}
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String npin =CurrentPinField.getText();
			String rpin = NewPinField.getText();
			String repin = RepinField.getText();
			Connection connection =ConnectToDb.getConnection();

			if (e.getSource()==changebtn){
				if (npin.equals("") || rpin.equals("") || repin.equals("")){
					JOptionPane.showMessageDialog(null,"Please Enter Current Pin");
				}
			if(checkpin()==true) {
				if (rpin.equals(repin)){
					String q1 = "update bank set pin ='"+rpin+"'where pin ='"+npin+"'";
					PreparedStatement preparedStatement = connection.prepareStatement(q1);
					String q2 ="update login set pin ='"+rpin+"'where pin='"+npin+"'";
					PreparedStatement pStatement=connection.prepareStatement(q2);
					String q3 = "update signup3 set pin ='"+rpin+"'where pin='"+npin+"'";
					PreparedStatement p3 = connection.prepareStatement(q3);

					preparedStatement.executeUpdate();
					pStatement.executeUpdate();
					p3.executeUpdate();
					JOptionPane.showMessageDialog(null,"Pin Changes Successfully");
					
					new Transaction().setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Pin Entered Doesnot Matched");
				}
			}
				
			}
			else if (e.getSource()==Backbtn){
				new Transaction().setVisible(true);
				setVisible(false);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		PinCHange p = new PinCHange();
		p.setResizable(false);
		p.setVisible(true);
	}
}
