package com.AsimulatorSystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnquiryBlance extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6835197441082135049L;
	
	String pin;
	int balance = 0;
	
	EnquiryBlance() {
		
		JLabel Title = new JLabel();
		Title.setForeground(Color.BLACK);
		Title.setFont(new Font("System", Font.BOLD, 16));
		try {
			Connection connection= ConnectToDb.getConnection();
			String q1 = "select Balance from Bank where pin = '"+pin+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(q1);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				balance =resultSet.getInt("Balance");
			}
			
		} catch (Exception ex) {
		
		}
		Title.setText("your current account balance is " + balance);
		JButton Backbtn = new JButton("Back");
		Backbtn.setFont(new Font("Ubuntu", Font.BOLD, 20));
		Backbtn.setForeground(new Color(255, 255, 255));
		Backbtn.setBackground(Color.BLACK);
		Backbtn.setBorderPainted(false);
		
		getContentPane().setLayout(null);
		Title.setBounds(24, 26, 400, 35);
		getContentPane().add(Title);
		Backbtn.setBounds(274, 72, 150, 35);
		getContentPane().add(Backbtn);
		
		setSize(452, 143);
		setLocation(200, 0);
		setUndecorated(true);
		
		Backbtn.addActionListener(this);
		
		
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction().setVisible(true);
	}

	public static void main(String[] args) {
		new EnquiryBlance().setVisible(true);
	}
}

