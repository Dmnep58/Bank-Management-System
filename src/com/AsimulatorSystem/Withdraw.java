package com.AsimulatorSystem;



import java.awt.Color;
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


public class Withdraw extends JFrame implements ActionListener {

	private static final long serialVersionUID = -4063172701893732548L;
	
	JTextField AmountTxtField;
	
	JButton withdrawbtn;
	JButton backBtn;
	JButton Exitbtn;
	
	JLabel TitleLabel;
	JLabel Title2Label;
	String pin;
	
	
	Withdraw(){
		
		//styling the labels buttons and text-fields
		
		TitleLabel= new JLabel("MAXIMUM DAILY WITHDRAW");
		TitleLabel.setFont(new Font("Ralewy",Font.BOLD,40));
		
		Title2Label= new JLabel("IS RS 12000");
		Title2Label.setFont(new Font("Ralewy",Font.BOLD,35));
		
		AmountTxtField = new JTextField();
		AmountTxtField.setFont(new Font("Raleway",Font.BOLD,22));
		
		withdrawbtn = new JButton("Withdraw");
		withdrawbtn.setBorderPainted(false);
		withdrawbtn.setFont(new Font("Raleway",Font.BOLD,18));
		withdrawbtn.setBackground(Color.BLACK);
		withdrawbtn.setForeground(Color.WHITE);
		
		backBtn = new JButton("Back");
		backBtn.setBorderPainted(false);
		backBtn.setFont(new Font("Raleway",Font.BOLD,18));
		backBtn.setBackground(Color.BLACK);
		backBtn.setForeground(Color.WHITE);
		
		Exitbtn = new JButton("Exit");
		Exitbtn.setBorderPainted(false);
		Exitbtn.setFont(new Font("Raleway",Font.BOLD,18));
		Exitbtn.setBackground(Color.BLACK);
		Exitbtn.setForeground(Color.WHITE);
		
		//form
		
		getContentPane().setLayout(null);
		
		TitleLabel.setBounds(83,62,579,60);
		getContentPane().add(TitleLabel);
		
		Title2Label.setBounds(221,117,246,60);
		getContentPane().add(Title2Label);
		
		AmountTxtField.setBounds(200,210,300,50);
		getContentPane().add(AmountTxtField);
		
		withdrawbtn.setBounds(180,304,125,50);
		getContentPane().add(withdrawbtn);
		
		backBtn.setBounds(412,304,125,50);
		getContentPane().add(backBtn);
		
		Exitbtn.setBounds(267,391,200,50);
		getContentPane().add(Exitbtn);
		
		//adiing actionlistener to the buttons
		
		withdrawbtn.addActionListener(this);
		backBtn.addActionListener(this);
		Exitbtn.addActionListener(this);
		
		//styling the panel
		getContentPane().setBackground(Color.WHITE);
		setSize(726,506);
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
		int Balance = 0;
		String withdrawamount = AmountTxtField.getText();
		int amount = Integer.parseInt(withdrawamount);
				Date date1 = new Date();
		long l1 = date1.getTime();
		java.sql.Date date =new java.sql.Date(l1);
		
		try {
			if (e.getSource()==withdrawbtn) {
				
				if (AmountTxtField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter the amount to Withdraw");
				} 
				else {
					Connection connection= ConnectToDb.getConnection();
					String pin=JOptionPane.showInputDialog("enter the pin");
					String q1 = "select Balance from Bank where pin = '"+pin+"'";
					PreparedStatement preparedStatement = connection.prepareStatement(q1);
					ResultSet resultSet=preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						Balance =resultSet.getInt("Balance");
					}
					
                   if(Balance > amount) {
                	   Balance=Balance-amount;
   					
   					String query="insert into Bank(pin,Deposit,withdraw,Dates,Balance) values('"+pin+"','"+0+"','"+amount+"','"+date+"','"+Balance+"')";
   					PreparedStatement preparedStatement1 = connection.prepareStatement(query);
   					preparedStatement1.executeUpdate();
   					
   					JOptionPane.showMessageDialog(null, "rs." + amount + "withdraw Successfully");
   					new Transaction().setVisible(true);
                   }
                   else {
                	   JOptionPane.showMessageDialog(null,"Insufficient amount"+"\n Balance rs. "+Balance);
				}

				}
			}
			else if (e.getSource()==backBtn){
				new Transaction().setVisible(true);
				setVisible(false);
			}
			
			else if (e.getSource()==Exitbtn){
				System.exit(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Withdraw wd= new Withdraw();
		wd.setResizable(false);
		wd.setVisible(true);
	}
}
