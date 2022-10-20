import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class SalesReport {

	private JFrame frame;
	private JLabel navigationLabel;
	private GridBagConstraints gbc;
	private JComboBox<String> combobox;
	private JButton button;
	private JLabel label;
	private JLabel dateLabel;
	private JLabel fromLabel;
	private JLabel toLabel;
	private JTextField fromTextField;
	private JTextField toTextField;
	private JButton printButton;
	SalesReport(){
		frame=new JFrame();
		navigationLabel=new JLabel("Navigation:");
		frame.add(navigationLabel);
		
		button=new JButton("Logout");
		String navigation[]= {" ","Dashboard","Customer Database","Staff Database","Stock and Inventory","Check Out","Sales Reports","Register Customer"};
		 combobox=new JComboBox<>(navigation);
		//combobox.setBounds(100, 50, 0, 0);
		combobox.setSelectedIndex(0);
		frame.add(combobox);
		label=new JLabel("Sale Reports");
		dateLabel=new JLabel("Date mm/dd/yyyy");
		fromLabel=new JLabel("From:");
		fromTextField=new JTextField();
		toLabel=new JLabel("To");
		toTextField=new JTextField();
		printButton=new JButton("Print");
		layout();
	}
	public void layout() {
		frame.setLayout(new GridBagLayout());
		//navigationLabel.setSize(150,20);
	
		gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(navigationLabel,gbc);
        
        gbc=new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1; 
		gbc.ipadx = 40;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(combobox,gbc);
        
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.EAST;
		frame.add(button,gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		
		frame.add(label,gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(dateLabel,gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(fromLabel,gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.ipadx = 90;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(fromTextField,gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(toLabel,gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 90;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(toTextField,gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(printButton,gbc);
		//ADD EVERYTHING TO A PANEL AND THEN ADD THE BORDER
		//frame.getContentPane().add(toTextField, BorderLayout.CENTER);
		frame.setSize(600,200);
		frame.setVisible(true);
		frame.isResizable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SalesReport();

	}

}
