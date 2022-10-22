package com.AsimulatorSystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Cursor;


public class Transaction extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2207938220556701071L;
	JLabel TitleLabel;
	JButton Depositbtn;
	JButton withdrawBtn;
	JButton FastcashBtn;
	JButton StatementBtn;
	JButton PinChangeBtn;
	JButton BalEnquiryBtn;
	JButton ExitBtn;
	String pin;
	Transaction(){
		
		
		//STYLING THE LABLE
		
		TitleLabel = new JLabel("Please select your Transaction");
		TitleLabel.setFont(new Font("Raleway",Font.BOLD,38));
		
		//styling and declaring the buttons
		
		Depositbtn = new JButton("Deposit");
		Depositbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Depositbtn.setBorderPainted(false);
		Depositbtn.setFont(new Font("Raleway",Font.BOLD,18));
		Depositbtn.setBackground(Color.BLACK);
		Depositbtn.setForeground(Color.WHITE);
		
		withdrawBtn = new JButton("Cash Withdrwal");
		withdrawBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		withdrawBtn.setBorderPainted(false);
		withdrawBtn.setFont(new Font("Raleway",Font.BOLD,18));
		withdrawBtn.setBackground(Color.BLACK);
		withdrawBtn.setForeground(Color.WHITE);
		
		FastcashBtn = new JButton("Fast Cash");
		FastcashBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FastcashBtn.setBorderPainted(false);
		FastcashBtn.setFont(new Font("Raleway",Font.BOLD,18));
		FastcashBtn.setBackground(Color.BLACK);
		FastcashBtn.setForeground(Color.WHITE);
		
		StatementBtn = new JButton("Mini Statement");
		StatementBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		StatementBtn.setBorderPainted(false);
		StatementBtn.setFont(new Font("Raleway",Font.BOLD,18));
		StatementBtn.setBackground(Color.BLACK);
		StatementBtn.setForeground(Color.WHITE);
		
		PinChangeBtn = new JButton("Pin Change");
		PinChangeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PinChangeBtn.setBorderPainted(false);
		PinChangeBtn.setFont(new Font("Raleway",Font.BOLD,18));
		PinChangeBtn.setBackground(Color.BLACK);
		PinChangeBtn.setForeground(Color.WHITE);
		
		BalEnquiryBtn = new JButton("Balance Enquiry");
		BalEnquiryBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BalEnquiryBtn.setBorderPainted(false);
		BalEnquiryBtn.setFont(new Font("Raleway",Font.BOLD,18));
		BalEnquiryBtn.setBackground(Color.BLACK);
		BalEnquiryBtn.setForeground(Color.WHITE);
		
		ExitBtn = new JButton("Exit");
		ExitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitBtn.setBorderPainted(false);
		ExitBtn.setFont(new Font("Raleway",Font.BOLD,18));
		ExitBtn.setBackground(Color.BLACK);
		ExitBtn.setForeground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		// setting the bound for the  labels and buttons
		
		TitleLabel.setBounds(70,30,588,40);
		getContentPane().add(TitleLabel);
		
		Depositbtn.setBounds(40,153,300,60);
		getContentPane().add(Depositbtn);
		
		withdrawBtn.setBounds(440,153,300,60);
		getContentPane().add(withdrawBtn);
		
		FastcashBtn.setBounds(40,262,300,60);
		getContentPane().add(FastcashBtn);
		
		StatementBtn.setBounds(427,262,300,60);
		getContentPane().add(StatementBtn);
		
		PinChangeBtn.setBounds(40,364,300,60);
		getContentPane().add(PinChangeBtn);
		
		BalEnquiryBtn.setBounds(440,364,300,60);
		getContentPane().add(BalEnquiryBtn);
		
		ExitBtn.setBounds(244,480,300,60);
		getContentPane().add(ExitBtn);
		
		// providing action listeners to the buttons.
		
		Depositbtn.addActionListener(this);
		withdrawBtn.addActionListener(this);
		FastcashBtn.addActionListener(this);
		StatementBtn.addActionListener(this);
		PinChangeBtn.addActionListener(this);
		BalEnquiryBtn.addActionListener(this);
		ExitBtn.addActionListener(this);
		
		// for the frame
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(768,578);
		setUndecorated(true);
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
	
		 if (e.getSource()==Depositbtn){
			 new  Deposits().setVisible(true);
			 setVisible(false);
		 }
		 else  if (e.getSource()==withdrawBtn) {
			 new Withdraw().setVisible(true);
			 setVisible(false);
		 }
		 else  if (e.getSource()==FastcashBtn){
			 new FastCashWithdraw().setVisible(true);
			 setVisible(false);
		 }
		
		 else  if (e.getSource()==StatementBtn){
			 new MiniStatements().setVisible(true);
			 setVisible(false);
		 }
		
		 else  if (e.getSource()==PinChangeBtn){
			 new PinCHange().setVisible(true);
			 setVisible(false);
		 }
		
		 else  if (e.getSource()==BalEnquiryBtn){
			 new EnquiryBlance().setVisible(true);
			 setVisible(false);
			}
		 else  if (e.getSource()==ExitBtn){
			 System.exit(0);
		 }
		
		
	}
	
	public static void main(String[] args) {
		Transaction t = new Transaction();
		t.setResizable(false);
		t.setVisible(true);
	}
}
