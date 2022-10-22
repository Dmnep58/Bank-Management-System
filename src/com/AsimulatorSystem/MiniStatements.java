package com.AsimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MiniStatements extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7743121230495655983L;
	JLabel AboutLabel,BalanceLabel;
	JButton backbtn,exitbtn;
	
	String BalLabel;
	String pin;
	int Balance = 0;
	int withdrawlamount =0;
	
	public void balanceDisplay() {
		pin = JOptionPane.showInputDialog("Enter the pin");
		try {
			Connection connection= ConnectToDb.getConnection();
			String q1 = "select Balance,withdraw from Bank where pin = '"+pin+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(q1);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Balance=resultSet.getInt("Balance");
				withdrawlamount=resultSet.getInt("withdraw");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		BalLabel ="your balance and last withdraw amount is: "+ Balance+" "+withdrawlamount;
		
		BalanceLabel.setText(BalLabel);
	}
	
	MiniStatements(){
		
		
		AboutLabel = new JLabel("this is a mini statement");
		AboutLabel.setFont(new Font("Raleway",Font.BOLD,14));
		
		BalanceLabel= new JLabel();
		BalanceLabel.setFont(new Font("Raleway",Font.BOLD,14));
		
		backbtn = new JButton("back");
		backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backbtn.setBorderPainted(false);
		backbtn.setFont(new Font("System",Font.BOLD,12));
		backbtn.setForeground(Color.WHITE);
		backbtn.setBackground(Color.black);
		
		exitbtn = new JButton("exit");
		exitbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitbtn.setBorderPainted(false);
		exitbtn.setFont(new Font("System",Font.BOLD,12));
		exitbtn.setForeground(Color.WHITE);
		exitbtn.setBackground(Color.black);
		
		
		getContentPane().setLayout(null);
		
		AboutLabel.setBounds(33,40,200,42);
		getContentPane().add(AboutLabel);
		
		BalanceLabel.setBounds(43,81,447,50);
		getContentPane().add(BalanceLabel);
		
		backbtn.setBounds(114,142,100,50);
		getContentPane().add(backbtn);
		
		exitbtn.setBounds(284,142,100,50);
		getContentPane().add(exitbtn);
		
		backbtn.addActionListener(this);
		exitbtn.addActionListener(this);
		
		setUndecorated(true);
		setBackground(Color.lightGray);
		setLocation(80,20);
		setSize(500,212);
		
		balanceDisplay();
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 try
		 {
			 if (e.getSource()==backbtn){
				 this.setVisible(false);
				 new Transaction();
				
			 }
			 if (e.getSource()==exitbtn){
				 System.exit(0);
			 }
		 } catch (Exception ex) {
			 ex.printStackTrace();
		 }
	}
	
	public static void main(String[] args) {
		new MiniStatements().setVisible(true);
	}
}
