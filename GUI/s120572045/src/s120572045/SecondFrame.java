package s120572045;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecondFrame {

	private JFrame frame = new JFrame("LOGIN");
	private JButton login = new JButton("LOGON");
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFrame window = new SecondFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecondFrame() {
		
		
		frame.setSize(300, 300);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 46, 106, 26);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 46, 96, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 99, 96, 28);
		frame.getContentPane().add(passwordField);
		
		JButton login = new JButton("LOGON");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String password = passwordField.getText();
				String username = textField.getText();
				if (password.contains("jinwen") && username.contains("s120572045")){
					frame.dispose();
					GUI ORDER = new GUI();
					GUI.main(null);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD!");
					textField.setText(null);
					passwordField.setText(null);
				}
			}
		});
		login.setFont(new Font("Arial Black", Font.PLAIN, 14));
		login.setBounds(94, 180, 106, 28);
		frame.getContentPane().add(login);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(28, 98, 106, 26);
		frame.getContentPane().add(lblPassword);
		
		
	}
}

