package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Customer;

// CustomerDatabase class inheriting from Jpanel 
public class CustomerDatabase extends JPanel {

	private static final long serialVersionUID = 1L;

	// Create variables
	private JFrame frame;
	private JLabel customerDatabaseLabel, searchLabel, navigationLabel;
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
	
	//Create an object of type JComboBox
	private JComboBox<String> combobox;
	//Create an object of type List
	private List<Customer> allCustomers;

	public CustomerDatabase() {
		// Initialize the variables
		frame = new JFrame("Customer StaffDatabase");
		navigationPanel = new JPanel();
		logoutPanel = new JPanel();
		customerDatabasePanel = new JPanel();
		searchTextFieldPanel = new JPanel();
		searchLabelPanel = new JPanel();
		logoutButton = new JButton("Logout");
		navigationLabel = new JLabel("Navigation");
		customerDatabaseLabel = new JLabel("Customer StaffDatabase");
		searchTextField = new TextField(40);
		searchLabel = new JLabel("Search");
		panel1 = new JPanel(new BorderLayout(0, 0));
		panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		tablePanel = new JPanel();

		// Create Array of string
		String[] navigation = { " ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory",
				"Check Out", "Sales Reports", "Register Customer" };
		//Creates a JComboBox that contains the elementsin the specified array
		combobox = new JComboBox<>(navigation);

		// Set position on the frame
		combobox.setBounds(100, 50, 150, 20);

		// Create Array of string
		String columns[] = { "Customer ID", "Name", "DOB", "Address", "Telephone", "Email", "Date of Membership",
				"Date of Membership Expiry" };
		//set value of row to 15
		int rows = 15;
		
		//Constructs a DefaultTableModel with rowCount of rows value and columnCount of the length of the column array.
		DefaultTableModel model = new DefaultTableModel(rows, columns.length);
		//Replaces the column identifiers in the model with the values from the column array
		model.setColumnIdentifiers(columns);
		//Constructs a JTable
		table = new JTable(model);

		// Set size of viewport for the table
		table.setPreferredScrollableViewportSize(new Dimension(1200, 100));
		table.setFillsViewportHeight(true);
		// Add table to scrollpane view
		scrollPane = new JScrollPane(table);

		// Call layoutComponents method
		layoutComponents();
		// call loadCustomerData method
		loadCustomerData();
		//call addItemListenerToCombo method
		addItemListenerToCombo();
	}

	private void layoutComponents() {
		// Set the Layout Manager for the frame
		frame.setLayout(new GridLayout(0, 1, 0, 0));

		// Add label to panel
		customerDatabasePanel.add(customerDatabaseLabel);
		// Add panel to frame
		frame.add(customerDatabasePanel);

		// Add label to panel
		navigationPanel.add(navigationLabel);
		// Add combobox to panel
		navigationPanel.add(combobox);
		// Add button to panel
		logoutPanel.add(logoutButton);
		// Add panel to panel using borderlayout
		panel1.add(navigationPanel, BorderLayout.WEST);
		panel1.add(logoutPanel, BorderLayout.EAST);
		// Add panel to frame
		frame.add(panel1);

		// Add label to panel
		searchLabelPanel.add(searchLabel);
		// Add textfield to panel
		searchTextFieldPanel.add(searchTextField);
		// Add panel to panel
		panel2.add(searchLabelPanel);
		panel2.add(searchTextFieldPanel);
		// Add panel to frame
		frame.add(panel2);

		// Add scrollable table to panel
		tablePanel.add(scrollPane);
		// Add panel to frame
		frame.add(tablePanel);

		// Set color of frame border
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		// Set size of frame
		frame.setSize(1350, 900);
		// Set frame to be visible
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void loadCustomerData() {
		
		allCustomers = new Controller().getAllCustomers();

		allCustomers.forEach(customer -> {
			Vector<Object> items = new Vector<>();

			items.add(customer.getId());
			items.add(customer.getName());
			items.add(customer.getDob());
			items.add(customer.getAddress());
			items.add(customer.getTelephone());
			items.add(customer.getEmail());
			items.add(customer.getDateOfMembership());
			items.add(customer.getDateOfMembershipExp());

			// tableItems.addRow(items);
		});

	}

	private void addItemListenerToCombo() {
		//Adds an ItemListener with the event to be processed
		combobox.addItemListener(itemEvent -> {
			if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
				String selected = (String) itemEvent.getItem();
				if (selected.equals("Dashboard")) {
					//Destroy frame
					frame.dispose();
					//Calls new DasBoard
					new DashBoard();
				} else if (selected.equals("Customer Database")) {
					//Destroy frame
					frame.dispose();
					//Calls new CustomerDatabase
					new CustomerDatabase();
				} else if (selected.equals("Staff Database")) {
					//Destroy frame
					frame.dispose();
					//Calls new StaffDatabase
					new StaffDatabase();
				} else if (selected.equals("Stock and Inventory")) {
					//Destroy frame
					frame.dispose();
					//Calls new Stock
					new Stock();
				} else if (selected.equals("Check Out")) {
					//Destroy frame
					frame.dispose();
					//Calls new CheckOut
					new CheckOut();
				} else if (selected.equals("Sales Reports")) {
					//Destroy frame
					frame.dispose();
					//Calls new SalesReport
					new SalesReport();
				} else if (selected.equals("Register Customer")) {
					//Destroy frame
					frame.dispose();
					//Calls new RegisterCustomer
					new RegisterCustomer();
				}
			}
		});
	}

	public static void main(String[] args) {
		//Calls new CustomerDatabase
		new CustomerDatabase();
	}
}
