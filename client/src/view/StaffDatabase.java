package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Staff;

// StaffDatabase class inheriting from JFrame
public class StaffDatabase extends JFrame {

	private static final long serialVersionUID = 1L;
	// Create variables
	private final JFrame frame;
	private final JTabbedPane tab;
	private final JPanel dashboard;
	private final JPanel management;
	private final JPanel inventory;
	private final JPanel accounting;
	private final JLabel navigationLabel;
	private final JPanel navigationPanel;
	private final JPanel logoutPanel;
	private final JPanel headerPanel;
	private final JPanel logNavPanel;
	private final JPanel tabPanel;
	private final JComboBox<String> combobox;
	private final JButton logoutBtn;
	private final JLabel headerLabel;
	private String headings[] = { "Department Code", "Name" };
	private int row = 0;
	private JTable managementTable;
	private JTable inventoryTable;
	private JTable accountingTable;
	private JPanel centerPanel;
	private JPanel topPanel;
	DefaultTableModel managementModel, inventoryModel, accountingModel;

	StaffDatabase() {
		// Initialize the variables
		frame = new JFrame();
		dashboard = new JPanel();
		management = new JPanel(new BorderLayout(0, 0));
		inventory = new JPanel(new BorderLayout(0, 0));
		accounting = new JPanel(new BorderLayout(0, 0));
		tab = new JTabbedPane();
		tab.setBounds(500, 500, 700, 400);
		navigationLabel = new JLabel("Navigation:");
		topPanel = new JPanel(new BorderLayout(0, 0));
		logoutBtn = new JButton("Logout");
		// Create Array of string
		String[] navigation = { " ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory",
				"Check Out", "Sales Reports", "Register Customer" };
		combobox = new JComboBox<>(navigation);
		// Set size of component
		combobox.setBounds(100, 50, 150, 20);
		headerLabel = new JLabel("Staff Database");
		navigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		logNavPanel = new JPanel(new BorderLayout(0, 0));
		tabPanel = new JPanel(new BorderLayout(1, 0));
		managementModel = new DefaultTableModel(row, headings.length);
		inventoryModel = new DefaultTableModel(row, headings.length);
		accountingModel = new DefaultTableModel(row, headings.length);
		managementModel.setColumnIdentifiers(headings);
		inventoryModel.setColumnIdentifiers(headings);
		accountingModel.setColumnIdentifiers(headings);

		managementTable = new JTable(managementModel);
		managementTable.setEnabled(false);
		inventoryTable = new JTable(inventoryModel);
		inventoryTable.setEnabled(false);
		accountingTable = new JTable(accountingModel);
		accountingTable.setEnabled(false);
		centerPanel = new JPanel(new BorderLayout(1, 0));

		// Call layoutComponents method
		layout();
		// Call addItemListenerCmobo method
		addItemListenerToCombo();
		getAllStaff();
	}

	@Override
	public void layout() {
		// Set the Layout Manager for the frame
		frame.setLayout(new BorderLayout(0, 1));

		// Add label to panel
		navigationPanel.add(navigationLabel);
		// Add combobox to panel
		navigationPanel.add(combobox);

		// Add button to panel
		logoutPanel.add(logoutBtn);
		// Add panel to panel
		logNavPanel.add(navigationPanel, BorderLayout.WEST);
		// Add panel to panel
		logNavPanel.add(logoutPanel, BorderLayout.EAST);
		// Add panel to frame
		frame.add(logNavPanel, BorderLayout.PAGE_START);
		// Add label to panel
		headerPanel.add(headerLabel, BorderLayout.CENTER);
		// Add panel to frame
		centerPanel.add(headerPanel, BorderLayout.NORTH);

		tab.add("Dashboard", dashboard);
		managementTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		managementTable.getColumnModel().getColumn(1).setPreferredWidth(450);
		management.add(managementTable.getTableHeader(), BorderLayout.PAGE_START);
		management.add(managementTable, BorderLayout.CENTER);
		tab.add("Management", management);
		inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		inventoryTable.getColumnModel().getColumn(1).setPreferredWidth(450);
		inventory.add(inventoryTable.getTableHeader(), BorderLayout.PAGE_START);
		inventory.add(inventoryTable, BorderLayout.CENTER);
		tab.add("Inventory", inventory);
		accountingTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		accountingTable.getColumnModel().getColumn(1).setPreferredWidth(450);
		accounting.add(accountingTable.getTableHeader(), BorderLayout.PAGE_START);
		accounting.add(accountingTable, BorderLayout.CENTER);
		tab.add("Accounting and Sales", accounting);
		// tabPanel.add(tab);
		centerPanel.add(tab);
		// Set size of panel
		// tabPanel.setSize(400, 200);
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
		// Set size of frame
		frame.setSize(700, 600);
		// Set frame to be visible
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adds an ActionListener to the button
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Destroy frame
				frame.dispose();
				// Call new loginpage
				new LoginPage();
			}
		});
	}

	private void addItemListenerToCombo() {
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

	private void getAllStaff() {
		List<Staff> allStaff = new Controller().getAllStaff();

		allStaff.forEach(staff -> {
			Vector<Object> items = new Vector<>();
			// Collects the customer information
			items.add(staff.getDepartment().getDepartmentCode());
			items.add(staff.getName());

			if (staff.getDepartment().getName().equals("Management")) {
				managementModel.addRow(items);
			} else if (staff.getDepartment().getName().equals("Inventory")) {
				inventoryModel.addRow(items);
			} else if (staff.getDepartment().getName().equals("Accounting")) {
				accountingModel.addRow(items);
			}
		});
	}

	public static void main(String[] args) {
		// Calls new StaffDatabase
		new StaffDatabase();
	}
}
