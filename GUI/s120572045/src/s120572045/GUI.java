package s120572045;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class GUI {
	
	private JFrame frmOrder =new JFrame ("ORDER");
	
	private JTextField textField;
	int table;
	protected JLabel show_comboBox_selected_item;
	protected JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmOrder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {

		initialize();
		

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrder = new JFrame();
		frmOrder.setForeground(SystemColor.text);
		frmOrder.getContentPane().setBackground(new Color(255, 255, 204));
		frmOrder.setTitle("ORDER");
		frmOrder.setBounds(100, 100, 435, 300);
		
		frmOrder.getContentPane().setLayout(null);
		
		 
		 String[] main = {"BEEF", "FISH", "PORK","CHICKEN"};
		 String[] water = {"COKE", "FRUIT DRINK", "COFFEE", "TEA"};
		//appetizer options
	
		 JComboBox comboBox = new JComboBox();
		 comboBox.addItem("CAESAR SALAD");
		comboBox.addItem("SALMON SALAD");
		comboBox.addItem("FRUIT SALAD");
		
		
		comboBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		comboBox.setBounds(98, 78, 101, 21);
		comboBox.setSelectedItem(null);
		frmOrder.getContentPane().add(comboBox);
		
		//mainCouse options
		JComboBox comboBox_1 = new JComboBox(main);
		comboBox_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		comboBox_1.setBounds(98, 118, 101, 21);
		comboBox_1.setSelectedItem(null);
		frmOrder.getContentPane().add(comboBox_1);
		
		//drink options
		JComboBox comboBox_2 = new JComboBox(water);
		comboBox_2.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		comboBox_2.setBounds(98, 162, 101, 21);
		comboBox_2.setSelectedItem(null);
		frmOrder.getContentPane().add(comboBox_2);
		
		//label of appetizer
		JLabel lblNewLabel = new JLabel("APPETIZER:");
		lblNewLabel.setFont(new Font("Cordia New", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 76, 78, 21);
		frmOrder.getContentPane().add(lblNewLabel);
		
		//label of main course
		JLabel lblMainCouse = new JLabel("MAIN COURSE:");
		lblMainCouse.setFont(new Font("Cordia New", Font.PLAIN, 18));
		lblMainCouse.setBounds(10, 116, 96, 21);
		frmOrder.getContentPane().add(lblMainCouse);
		
		//label of drink
		JLabel lblDrink = new JLabel("DRINK:");
		lblDrink.setFont(new Font("Cordia New", Font.PLAIN, 18));
		lblDrink.setBounds(10, 160, 96, 21);
		frmOrder.getContentPane().add(lblDrink);
		
		//table number
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
			}
		});		
		textField.setBounds(123, 29, 53, 26);
		frmOrder.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTableNo = new JLabel("TABLE NO.:");
		lblTableNo.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		lblTableNo.setBounds(31, 30, 93, 21);
		frmOrder.getContentPane().add(lblTableNo);
		//order
		JButton btnNewButton = new JButton("ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null, "ORDER SUCESS!");
				
			}
		});
	
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 16));
		btnNewButton.setBounds(31, 208, 101, 43);
		frmOrder.getContentPane().add(btnNewButton);
		
		//appetizer select
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					 		int caesar=150;
					 		int salmon=130;
					 		int fruit=120;
					 		if (comboBox.getSelectedItem().equals("CAESAR SALAD")){
					 			String c= String.format("%d", caesar);
					 			textField_1.setText(c);
					 		}
					 		if (comboBox.getSelectedItem().equals("SALMON SALAD")){
					 			String s= String.format("%d",salmon );
					 			textField_1.setText(s);
					 		}
					 		if (comboBox.getSelectedItem().equals("FRUIT SALAD")){
					 			String f= String.format("%d",fruit );
					 			textField_1.setText(f);
					 		}
					 	}
					 });
			
				
				
	
		button.setFont(new Font("Consolas", Font.PLAIN, 12));
		button.setBounds(209, 78, 46, 22);
		frmOrder.getContentPane().add(button);
		
		//main course select
		JButton button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					 		int beef=250;
					 		int fish=200;
					 		int pork=190;
					 		int chicken=180;
					 		if (comboBox_1.getSelectedItem().equals("BEEF")){
					 			String cbeef= String.format("%d", beef);
					 			textField_2.setText(cbeef);
					 		}
					 		if (comboBox_1.getSelectedItem().equals("FISH")){
					 			String cfish= String.format("%d", fish);
					 			textField_2.setText(cfish);
					 		}
					 		if (comboBox_1.getSelectedItem().equals("PORK")){
					 			String cpork= String.format("%d", pork);
					 			textField_2.setText(cpork);
					 		}
					 		if (comboBox_1.getSelectedItem().equals("CHICKEN")){
					 			String cchicken= String.format("%d",chicken );
					 			textField_2.setText(cchicken);
					 		}
					 	}
					 });
			
		button_1.setFont(new Font("Consolas", Font.PLAIN, 12));
		button_1.setBounds(209, 118, 46, 22);
		frmOrder.getContentPane().add(button_1);
		
		//drink select
		JButton button_2 = new JButton("+");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					 		int coke=25;
					 		int fruit_drink=40;
					 		int coffee=30;
					 		int tea=30;
					 		if (comboBox_2.getSelectedItem().equals("COKE")){
					 			String ccoke= String.format("%d", coke);
					 			textField_3.setText(ccoke);
					 		}
					 		if (comboBox_2.getSelectedItem().equals("FRUIT DRINK")){
					 			String cfd= String.format("%d", fruit_drink);
					 			textField_3.setText(cfd);
					 		}
					 		if (comboBox_2.getSelectedItem().equals("COFFEE")){
					 			String ccoffee= String.format("%d", coffee);
					 			textField_3.setText(ccoffee);
					 		}
					 		if (comboBox_2.getSelectedItem().equals("TEA")){
					 			String ctea= String.format("%d",tea );
					 			textField_3.setText(ctea);
					 		}
					 	}
					 });
		button_2.setFont(new Font("Consolas", Font.PLAIN, 12));
		button_2.setBounds(209, 162, 46, 22);
		frmOrder.getContentPane().add(button_2);
		
		//order list
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
	
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(303, 29, 101, 21);
		frmOrder.getContentPane().add(lblNewLabel_1);
		
		//ADD TABLE NO
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table=Integer.parseInt(textField.getText());
				lblNewLabel_1.setText("TABLE NO: "+table+"");
			}
		});
		btnAdd.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnAdd.setBounds(185, 30, 70, 22);
		frmOrder.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_2 = new JLabel("ORDER LIST:");
		lblNewLabel_2.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(313, 10, 111, 15);
		frmOrder.getContentPane().add(lblNewLabel_2);
		//show appetizer
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(303, 78, 53, 21);
		frmOrder.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//show main course
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(303, 118, 53, 21);
		frmOrder.getContentPane().add(textField_2);
		//show drink
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(303, 162, 53, 21);
		frmOrder.getContentPane().add(textField_3);
		//total
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(303, 210, 53, 21);
		frmOrder.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnTotal = new JButton("total");
		btnTotal.setFont(new Font("Arial", Font.PLAIN, 12));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cappetizer =  Integer.parseInt(textField_1.getText());
				int cmain = Integer.parseInt(textField_2.getText());
				int cdrink = Integer.parseInt(textField_3.getText());
				int ctotal= (cappetizer + cmain +cdrink);
				String itotal=String.format("%d", ctotal);
				textField_4.setText(itotal);
			}
		});
		
				
		
		
		btnTotal.setBounds(185, 209, 70, 21);
		frmOrder.getContentPane().add(btnTotal);
		
	}
}
