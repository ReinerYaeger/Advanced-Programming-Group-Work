package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomerDatabase extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//Create variables
	private JFrame frame;
	private JLabel customerDatabaseLabel,searchLabel,navigationLabel;
	private TextField searchTextField;
	private JButton logoutButton;	
	private JPanel searchTextFieldPanel;
	private JPanel searchLabelPanel;
	private JPanel tablePanel;
	private JPanel navigationPanel;
	private JPanel logoutPanel;
	private JPanel customerDatabasePanel;
	private JPanel panel1;
	private JPanel panel2;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox<String> combobox;
	
	public CustomerDatabase() {
		//Initialize the variables
		frame = new JFrame("Customer Database");
		navigationPanel = new JPanel();
		logoutPanel = new JPanel();
		customerDatabasePanel = new JPanel();
		searchTextFieldPanel = new JPanel();
		searchLabelPanel = new JPanel();
		logoutButton = new JButton("Logout");
		navigationLabel = new JLabel("Navigation");
		customerDatabaseLabel = new JLabel("Customer Database");
		searchTextField = new TextField(40);
		searchLabel = new JLabel("Search");
		panel1 = new JPanel(new BorderLayout(0,0));
		panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		tablePanel = new JPanel();
		
		//Create Array of string
		String navigation[]= {" ","Dashboard","Customer Database","Staff Database","Stock and Inventory","Check Out","Sales Reports","Register Customer"};
		combobox=new JComboBox<>(navigation);
		//Set position on the frame
		combobox.setBounds(100, 50, 150, 20);
		
		//Create Array of string
	String columns[] = {"Customer ID", "Name", "DOB", "Address","Telephone","Email","Date of Membership","Date of Membership Expiry"};
	int rows = 15;
	
	DefaultTableModel model = new DefaultTableModel(rows, columns.length) ;
	model.setColumnIdentifiers(columns);
	table=new JTable(model);

	//Set size of viewport for the table
	table.setPreferredScrollableViewportSize(new Dimension(1200,100));
	table.setFillsViewportHeight(true);
	//Add table to scrollpane view
     scrollPane = new JScrollPane(table);
	
	 //Call layoutComponents method
	layoutComponents();
	}
	
	private void layoutComponents() {
		//Set the Layout Manager for the frame
		frame.setLayout(new GridLayout(0,1,0,0));
		
		//Add label to panel
		customerDatabasePanel.add(customerDatabaseLabel);
		//Add panel to frame
		frame.add(customerDatabasePanel);
		
		//Add label to panel
		navigationPanel.add(navigationLabel);
		//Add combobox to panel
		navigationPanel.add(combobox);
		//Add button to panel
		logoutPanel.add(logoutButton);
		//Add panel to panel using borderlayout
		panel1.add(navigationPanel,BorderLayout.WEST);
		panel1.add(logoutPanel,BorderLayout.EAST);
		//Add panel to frame
		frame.add(panel1);
		
		//Add label to panel
		searchLabelPanel.add(searchLabel);
		//Add textfield to panel
		searchTextFieldPanel.add(searchTextField);
		//Add panel to panel 
		panel2.add(searchLabelPanel);
		panel2.add(searchTextFieldPanel);
		//Add panel to frame
		frame.add(panel2);
		
		//Add scrollable table to panel
		tablePanel.add(scrollPane);
		//Add panel to frame
		frame.add(tablePanel);
		
		//Set color of frame border
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		 //Set size of frame
		frame.setSize(1350, 900);
		//Set frame to be visible
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		new CustomerDatabase();
	}
}
