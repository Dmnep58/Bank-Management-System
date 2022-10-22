package com.AsimulatorSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginBank extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8694534167875450634L;
	
	private JPanel panelTitle;
	
	private JLabel TitleLabel;
	private JLabel CardLabel;
	private JLabel PinLabel;
	private JLabel ExitLabel;
	private JTextField CardNoField;
	private JPasswordField PinNoField;
	
	private JButton SignBtn;
	private JButton ClearField;
	private JButton SignUpLabel;
	
	
	
	LoginBank(){
		setUndecorated(true);
		 
		 CardLabel= new JLabel("Card No:");
		 CardLabel.setBounds(48, 189, 144, 37);
		 CardLabel.setFont(new Font("Raleway",Font.BOLD,28));
		 
		 PinLabel= new JLabel("PIN:");
		 PinLabel.setBounds(70, 267, 122, 37);
		 PinLabel.setFont(new Font("Raleway",Font.BOLD,28));
		
		 // for text-field and password-field
		 CardNoField=new JTextField(15);
		 CardNoField.setBounds(202, 189, 285, 37);
		 PinNoField=new JPasswordField(15);
		 PinNoField.setBounds(202, 267, 285, 37);
		 
		 //for the different buttons
		 SignBtn =new JButton("Sign In");
		 SignBtn.setBorderPainted(false);
		 SignBtn.setBounds(149, 367, 100, 30);
		 SignBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignBtn.setFont(new Font("Raleway",Font.BOLD,18));
		 SignBtn.setBackground(Color.black);
		 SignBtn.setForeground(Color.WHITE);
		 
		 ClearField=new JButton("CLEAR");
		 ClearField.setBorderPainted(false);
		 ClearField.setBounds(371, 367, 100, 30);
		 ClearField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ClearField.setFont(new Font("Raleway",Font.BOLD,18));
		 ClearField.setBackground(Color.black);
		 ClearField.setForeground(Color.WHITE);
		 
		 SignUpLabel=new JButton("Sign Up");
		 SignUpLabel.setBorderPainted(false);
		 SignUpLabel.setBounds(204, 438, 230, 30);
		 SignUpLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignUpLabel.setFont(new Font("Raleway",Font.BOLD,18));
		 SignUpLabel.setBackground(new Color(0, 0, 0));
		 SignUpLabel.setForeground(Color.WHITE);
		getContentPane().setLayout(null);
		getContentPane().add(CardLabel);
		getContentPane().add(PinLabel);
		
		
		// set the text field
		CardNoField.setFont(new Font("Arial",Font.BOLD,14));
		getContentPane().add(CardNoField);
		
		// for the password-field
		PinNoField.setFont(new Font("Arial",Font.BOLD,14));
		getContentPane().add(PinNoField);
		
		// for the button sections
		
		SignBtn.setFont(new Font("Arial",Font.BOLD,14));
		getContentPane().add(SignBtn);
		
		ClearField.setFont(new Font("Arial",Font.BOLD,14));
		getContentPane().add(ClearField);
		
		SignUpLabel.setFont(new Font("Arial",Font.BOLD,14));
		getContentPane().add(SignUpLabel);
		
		//ADDING ACTIONLISTENERS TO BUTTONS
		SignBtn.addActionListener(this);
		ClearField.addActionListener(this);
		SignUpLabel.addActionListener(this);
		
		// style the panel
		
		getContentPane().setBackground(new Color(255, 255, 255));
		
		JPanel panelExit = new JPanel();
		panelExit.setBounds(547, 0, 53, 54);
		panelExit.setBackground(new Color(255, 0, 51));
		getContentPane().add(panelExit);
		panelExit.setLayout(null);
		
		ExitLabel = new JLabel("   X");
		ExitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		ExitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitLabel.setForeground(new Color(255, 255, 255));
		ExitLabel.setFont(new Font("Ubuntu", Font.BOLD, 28));
		ExitLabel.setBounds(0, 0, 49, 54);
		panelExit.add(ExitLabel);
		
		panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 255, 255));
		panelTitle.setBounds(45, 60, 470, 82);
		getContentPane().add(panelTitle);
		panelTitle.setLayout(null);
		
		
		// for the different labels
		TitleLabel= new JLabel(" WELCOME TO ATM");
		TitleLabel.setBounds(26, 11, 422, 67);
		panelTitle.add(TitleLabel);
		TitleLabel.setBackground(new Color(255, 255, 255));
		TitleLabel.setIcon(new ImageIcon("D:\\java\\library\\adminIcons\\icons8_Library_26px_1.png"));
		TitleLabel.setForeground(Color.red);
		TitleLabel.setFont(new Font("osward",Font.BOLD,38));
		
		setSize(600,541);
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
	try{
		Connection connection = ConnectToDb.getConnection();
		String cardno =CardNoField.getText();
		String pin = PinNoField.getText();
		String query= "select * from LOGIN where CARDNO ='"+cardno+"'and pin='"+pin+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs =preparedStatement.executeQuery();
		
		if (e.getSource()==SignBtn){
			if (rs.next()){
				new Transaction().setVisible(true);
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"INCORRECT CARD-NO OR PASSWORD");
			}
			
		}
		else if (e.getSource()==ClearField){
				CardNoField.setText("");
				PinNoField.setText("");
			}
			else if (e.getSource()==SignUpLabel){
				new Signup().setVisible(true);
				setVisible(false);
			}
			
	} catch (Exception ex) {
		ex.printStackTrace();
		System.out.println("error: "+ex);
	}
	}
	
	public static void main(String[] args) {
		LoginBank log=new LoginBank();
		log.setResizable(false);
		log.setVisible(true);
		
		
	}
}
