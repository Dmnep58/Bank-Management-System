package com.AsimulatorSystem;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposits extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4522714335340066901L;
	JTextField AmountField;
	JButton DepositBtn;
	JButton Backbtn;
	JButton Exitbtn;
	JLabel TitleLabel;
	JLabel Title2Label;
	JLabel l4;
	String pin;
	
	Deposits(){
		

		//styling the lables buttons and text-fields
		
		TitleLabel= new JLabel("Enter the balance to deposit");
		TitleLabel.setFont(new Font("Ralewy",Font.BOLD,35));
		
		Title2Label= new JLabel("To Deposit");
		Title2Label.setFont(new Font("Ralewy",Font.BOLD,35));
		
		AmountField = new JTextField();
		AmountField.setFont(new Font("Raleway",Font.BOLD,22));
		
		DepositBtn = new JButton("Deposit");
		DepositBtn.setBorderPainted(false);
		DepositBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DepositBtn.setFont(new Font("Raleway",Font.BOLD,18));
		DepositBtn.setBackground(Color.BLACK);
		DepositBtn.setForeground(Color.WHITE);
		
		Backbtn = new JButton("Back");
		Backbtn.setBorderPainted(false);
		Backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Backbtn.setFont(new Font("Raleway",Font.BOLD,18));
		Backbtn.setBackground(Color.BLACK);
		Backbtn.setForeground(Color.WHITE);
		
		Exitbtn = new JButton("Exit");
		Exitbtn.setBorderPainted(false);
		Exitbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exitbtn.setFont(new Font("Raleway",Font.BOLD,18));
		Exitbtn.setBackground(Color.BLACK);
		Exitbtn.setForeground(Color.WHITE);
		
		//form
		
		getContentPane().setLayout(null);
		
		TitleLabel.setBounds(114,66,501,60);
		getContentPane().add(TitleLabel);
		
		Title2Label.setBounds(250,125,224,60);
		getContentPane().add(Title2Label);
		
		AmountField.setBounds(206,231,300,50);
		getContentPane().add(AmountField);
		
		DepositBtn.setBounds(162,331,125,50);
		getContentPane().add(DepositBtn);
		
		Backbtn.setBounds(401,331,125,50);
		getContentPane().add(Backbtn);
		
		Exitbtn.setBounds(250,425,200,50);
		getContentPane().add(Exitbtn);
		
		//adiing actionlistener to the buttons
		
		DepositBtn.addActionListener(this);
		Backbtn.addActionListener(this);
		Exitbtn.addActionListener(this);
		
		//styling the panel
		getContentPane().setBackground(Color.WHITE);
		setSize(688,541);
		setLocation(200,0);
		setVisible(true);
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String pin = JOptionPane.showInputDialog("Enter the Pin");
		int Balance = 0;
		String amount1 = AmountField.getText();
		int amount = Integer.parseInt(amount1);
		
		Date date1 = new Date();
		long l1 = date1.getTime();
		java.sql.Date date =new java.sql.Date(l1);
		try {
			if (e.getSource() == DepositBtn) {
				
				
				if (AmountField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the amount to desposit");
				} else {
					Connection connection= ConnectToDb.getConnection();
					String q1 = "select Balance from Bank where pin = '"+pin+"'";
					PreparedStatement preparedStatement = connection.prepareStatement(q1);
					ResultSet resultSet=preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						Balance=resultSet.getInt("Balance");
					}
					
					Balance=Balance+amount;
					
					String query="insert into Bank(pin,Deposit,withdraw,Dates,Balance) values('"+pin+"','"+amount+"','"+0+"','"+date+"','"+Balance+"')";
					PreparedStatement preparedStatement1 = connection.prepareStatement(query);
					preparedStatement1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "rs." + amount + "Deposited Successfully");
					
					new Transaction().setVisible(true);
				}
			} else if (e.getSource() == Backbtn) {
				setVisible(false);
				new Transaction().setVisible(true);
			}
			else	if (e.getSource()==Exitbtn){
					System.exit(0);
				}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		Deposits Des= new Deposits();
		Des.setResizable(false);
		Des.setVisible(true);
	}
}
