package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Invoice;

public class SalesReport implements ActionListener {

	// Create variables
	private JFrame frame;
	private JLabel navigationLabel;
	private GridBagConstraints gbc;
	private JComboBox<String> combobox;
	private JButton logoutBtn;
	private JLabel label;
	private JLabel dateLabel;
	private JLabel fromLabel;
	private JLabel toLabel;
	private JTextField fromTextField;
	private JTextField toTextField;
	private JButton printButton;
	private JTable table;
	private DefaultTableModel model;

	SalesReport() {
		// Initialize the variables
		frame = new JFrame();
		navigationLabel = new JLabel("Navigation:");
		// add label to frame
		frame.add(navigationLabel);

		// Initialize the variable
		logoutBtn = new JButton("Logout");
		// create array of string
		String[] navigation = { " ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory",
				"Check Out", "Sales Reports", "Register Customer" };
		// Creates a JComboBox that contains the elements in the specified array
		combobox = new JComboBox<>(navigation);
		combobox.setSelectedIndex(0);
		// add combobox to frame
		frame.add(combobox);
		// Initialize the variables
		label = new JLabel("Sale Reports");
		dateLabel = new JLabel("Date mm/dd/yyyy");
		fromLabel = new JLabel("From:");
		fromTextField = new JTextField();
		toLabel = new JLabel("To");
		toTextField = new JTextField();
		printButton = new JButton("Print");
		String modelColumns[] = { "Invoice Number", "Billing Date", "Cashier", "Customer" };
		model = new DefaultTableModel(modelColumns, 5) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable(model);

		// call the methods created
		layout();
		addActionListener();
		addItemListenerToCmobo();
	}

	private void layout() {
		// Set the Layout Manager for the frame
		frame.setLayout(new GridBagLayout());

		// Re-Initialize the GridBag Constraints
		gbc = new GridBagConstraints();
		// Set location in terms of row and column
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		// Set internal padding
		gbc.ipadx = 50;
		gbc.ipady = 20;
		// sets where, within the frame, to place the component.
		gbc.anchor = GridBagConstraints.NORTHWEST;
		// Add component to frame
		frame.add(navigationLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 40;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(combobox, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.EAST;
		frame.add(logoutBtn, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		frame.add(label, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(dateLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(fromLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.ipadx = 90;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(fromTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(toLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 90;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(toTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.WEST;
		frame.add(printButton, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.SOUTH;
		frame.add(table.getTableHeader(), gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 18;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.SOUTH;
		frame.add(table, gbc);

		// Set size of frame
		frame.setSize(800, 600);
		// Set frame to be visible
		frame.setVisible(true);
		frame.isResizable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adds an ActionListener to the button.
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// destroy frame
				frame.dispose();
				// call new loginpage
				new LoginPage();
			}
		});
	}

	private void addActionListener() {
		// Adds an actionListener to the button
		printButton.addActionListener(this);
	}

	// Invoked when an action occurs.
	@Override
	public void actionPerformed(ActionEvent e) {
		// look up invoice based on dates
		if (printButton.getModel().isArmed()) {
			System.out.println("Printing");
			// get the date and split it so we can make a localDate variable
			String[] fromDateText = fromTextField.getText().split("/");
			String[] toDateText = toTextField.getText().split("/");

			String fromDateString = fromDateText[2] + "-" + fromDateText[0] + "-" + fromDateText[1];
			String toDateString = toDateText[2] + "-" + toDateText[0] + "-" + toDateText[1];

			List<Invoice> invoices = new Controller().searchSalesReport(fromDateString, toDateString);

			invoices.forEach(invoice -> {
				Vector<Object> items = new Vector<>();

				items.add(invoice.getInvoiceNum());
				items.add(invoice.getBillingDate());
				items.add(invoice.getCashier().getName());
				if (invoice.getCustomer() != null)
					items.add(invoice.getCustomer().getName());
				else
					items.add(invoice.getCustomer());
				model.addRow(items);
			});

		}

	}

	private void addItemListenerToCmobo() {
		// Adds an ItemListener with the event to be processed
		combobox.addItemListener(itemEvent -> {
			if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
				String selected = (String) itemEvent.getItem();
				if (selected.equals("Dashboard")) {
					// Destroy frame
					frame.dispose();
					// Calls new DasBoard
					new DashBoard();
				} else if (selected.equals("Customer Database")) {
					// Destroy frame
					frame.dispose();
					// Calls new CustomerDatabase
					new CustomerDatabase();
				} else if (selected.equals("Staff Database")) {
					// Destroy frame
					frame.dispose();
					// Calls new StaffDatabase
					new StaffDatabase();
				} else if (selected.equals("Stock and Inventory")) {
					// Destroy frame
					frame.dispose();
					// Calls new Stock
					new Stock();
				} else if (selected.equals("Check Out")) {
					// Destroy frame
					frame.dispose();
					// Calls new CheckOut
					new CheckOut();
				} else if (selected.equals("Sales Reports")) {
					// Destroy frame
					frame.dispose();
					// Calls new SalesReport
					new SalesReport();
				} else if (selected.equals("Register Customer")) {
					// Calls new RegisterCustomer
					new RegisterCustomer();
				}
			}
		});
	}

	public static void main(String[] args) {
		// Calls new SalesReport
		new SalesReport();
		;

	}

}
