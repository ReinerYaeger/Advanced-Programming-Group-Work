package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Inventory;

public class Stock {

	// Create variables
	private JFrame frame;
	private JButton button;
	private JLabel navigationLabel;
	private JComboBox<String> combobox;
	private JLabel headerLabel;
	private JTable table;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel borderPanel;
	private String headings[] = { "Product Code", "Name", "Short Description", "Long Description", "Items in Stock",
			"Unit Price" };
	private JButton updateButton;
	private JButton deleteButton;
	private JButton insertButton;
	private DefaultTableModel model;
	List<Inventory> allItems;

	public Stock() {
		// Initialize the variables
		frame = new JFrame();
		navigationLabel = new JLabel("Navigation:");
		button = new JButton("Logout");
		String[] navigation = { " ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory",
				"Check Out", "Sales Reports", "Register Customer" };
		combobox = new JComboBox<>(navigation);
		headerLabel = new JLabel("Stock and Inventory");
		model = new DefaultTableModel(0, headings.length);
		model.setColumnIdentifiers(headings);
		table = new JTable(model);
		Border border = BorderFactory.createLineBorder(Color.black);
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");
		insertButton = new JButton("Insert");
		panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel4 = new JPanel(new BorderLayout(0, 0));
		panel5 = new JPanel(new BorderLayout(0, 0));
		panel5.setSize(400, 500);
		panel6 = new JPanel();
		borderPanel = new JPanel();
		borderPanel.setBorder(border);

		//call methods created
		layout();
		getAllInventoryItems();
		addItemListenerToCmobo();
	}

	public void layout() {
		// Set the Layout Manager for the frame
		frame.setLayout(new GridLayout(0, 1, 1, 2));
		//add label to panel
		panel1.add(navigationLabel);
		//add combobox to panel
		panel1.add(combobox);
		//add button too panel
		panel2.add(button);
		//add pael to panel
		panel4.add(panel1, BorderLayout.WEST);
		panel4.add(panel2, BorderLayout.EAST);
		//add panel to frame
		frame.add(panel4);
		panel3.add(headerLabel, BorderLayout.CENTER);
		//add panel to frame
		frame.add(panel3);
		panel5.add(table.getTableHeader(), BorderLayout.NORTH);
		//add table to panel
		panel5.add(table);
		//add panel to frame
		frame.add(panel5);
		panel6.add(updateButton);
		panel6.add(deleteButton);
		panel6.add(insertButton);
		//add panel to frame
		frame.add(panel6);
		borderPanel.setLayout(new GridLayout(0, 1, 20, 0));
		borderPanel.add(panel5);
		borderPanel.add(panel6);

		frame.getContentPane().add(borderPanel, BorderLayout.CENTER);
		//set size of frame
		frame.setSize(new Dimension(800, 500));
		//set frame to be visible
		frame.setVisible(true);
		frame.setResizable(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	 button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPage();
            }
        });
	}

	private void getAllInventoryItems() {
		allItems = new Controller().getAllInventory();

		System.out.println(allItems + " .. ");

		allItems.forEach(inventory -> {
			Vector<Object> items = new Vector<>();

			//Collects inventory information
			items.add(inventory.getId());
			items.add(inventory.getName());
			items.add(inventory.getItemsInStock());
			items.add(inventory.getUnitPrice());
			items.add(inventory.getShortDescription());
			items.add(inventory.getLongDescription());

			//Add information to table
			model.addRow(items);
		});
	}

	private void addItemListenerToCmobo() {
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
		//Calls new Stock
		new Stock();
	}

}
