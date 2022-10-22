package com.AsimulatorSystem;


import java.awt.Font;
import java.awt.Color;
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
import java.awt.Cursor;


public class FastCashWithdraw extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737864111196235215L;
	
	JLabel TitleLabel;
	JButton Cash100;
	JButton Cash500;
	JButton cash1000;
	JButton cash3000;
	JButton cash6000;
	JButton cash12000;
	JButton Backbtn;
	String pin;
	FastCashWithdraw(){
		
		//styling the labels text-field and buttons.
		
		TitleLabel = new JLabel("Select the withdrawl Amount");
		TitleLabel.setFont(new Font("Raleway",Font.BOLD,38));
		
		Cash100= new JButton("100");
		Cash100.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Cash100.setBorderPainted(false);
		Cash100.setFont(new Font("Raleway",Font.BOLD,18));
		Cash100.setBackground(Color.black);
		Cash100.setForeground(Color.WHITE);
		
		Cash500= new JButton("500");
		Cash500.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Cash500.setBorderPainted(false);
		Cash500.setFont(new Font("Raleway",Font.BOLD,18));
		Cash500.setBackground(Color.black);
		Cash500.setForeground(Color.WHITE);
		
		cash1000= new JButton("1000");
		cash1000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cash1000.setBorderPainted(false);
		cash1000.setFont(new Font("Raleway",Font.BOLD,18));
		cash1000.setBackground(Color.black);
		cash1000.setForeground(Color.WHITE);
		
		cash3000= new JButton("3000");
		cash3000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cash3000.setBorderPainted(false);
		cash3000.setFont(new Font("Raleway",Font.BOLD,18));
		cash3000.setBackground(Color.black);
		cash3000.setForeground(Color.WHITE);
		
		cash6000= new JButton("6000");
		cash6000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cash6000.setBorderPainted(false);
		cash6000.setFont(new Font("Raleway",Font.BOLD,18));
		cash6000.setBackground(Color.black);
		cash6000.setForeground(Color.WHITE);
		
		cash12000= new JButton("12000");
		cash12000.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cash12000.setBorderPainted(false);
		cash12000.setFont(new Font("Raleway",Font.BOLD,18));
		cash12000.setBackground(Color.black);
		cash12000.setForeground(Color.WHITE);
		
		Backbtn= new JButton("Back");
		Backbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Backbtn.setBorderPainted(false);
		Backbtn.setFont(new Font("Raleway",Font.BOLD,18));
		Backbtn.setBackground(Color.black);
		Backbtn.setForeground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		TitleLabel.setBounds(100,100,700,40);
		getContentPane().add(TitleLabel);
		
		Cash100.setBounds(40,250,300,60);
		getContentPane().add(Cash100);
		
		Cash500.setBounds(440,250,300,60);
		getContentPane().add(Cash500);
		
		cash1000.setBounds(40,360,300,60);
		getContentPane().add(cash1000);
		
		cash3000.setBounds(440,360,300,60);
		getContentPane().add(cash3000);
		
		cash6000.setBounds(40,470,300,60);
		getContentPane().add(cash6000);
		
		cash12000.setBounds(440,470,300,60);
		getContentPane().add(cash12000);
		
		Backbtn.setBounds(240,600,300,60);
		getContentPane().add(Backbtn);
		
		//providing actions listeners to buttons
		
		Cash100.addActionListener(this);
		Cash500.addActionListener(this);
		cash1000.addActionListener(this);
		cash3000.addActionListener(this);
		cash6000.addActionListener(this);
		cash12000.addActionListener(this);
		Backbtn.addActionListener(this);
		// panels styling and declaration
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,800);
		setLocation(200,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void balance(int amt) {
		String pin = JOptionPane.showInputDialog("enter the pin");
		int Balance=0;
		Date date1 = new Date();
		long l1 = date1.getTime();
		java.sql.Date date =new java.sql.Date(l1);
		try {
			Connection connection= ConnectToDb.getConnection();
			String q1 = "select Balance from Bank where pin = '"+pin+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(q1);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				Balance=resultSet.getInt("Balance");
			}
			if(Balance > amt) {
				Balance =Balance-amt;
				String query="insert into Bank(pin,Deposit,withdraw,Dates,Balance) values('"+pin+"','"+0+"','"+amt+"','"+date+"','"+Balance+"')";
					PreparedStatement preparedStatement1 = connection.prepareStatement(query);
					preparedStatement1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "rs." + amt + "withdraw Successfully");
			}
			else {
				 JOptionPane.showMessageDialog(null,"Insufficient amount"+"\n Balance rs. "+Balance);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int amt =0;
		
		if(e.getSource()==Cash100) {
			amt =100;
			balance(amt);
		}
		if (e.getSource()==Cash500) {
			amt =500;
			balance(amt);
		}
		if(e.getSource()==cash1000) {
			amt =1000;
			balance(amt);
		}
		if (e.getSource()==cash3000) {
			amt =3000;
			balance(amt);
		}
		if(e.getSource()==cash6000) {
			amt =6000;
			balance(amt);
		}
		if (e.getSource()==cash12000) {
			amt =12000;
			balance(amt);
		}
		if (e.getSource()==Backbtn) {
			Transaction transcations= new Transaction();
			transcations.setVisible(true);
			dispose();
		}
		
	}
	
	public static void main(String[] args) {
		FastCashWithdraw fc = new FastCashWithdraw();
		fc.setVisible(true);
	}
}
