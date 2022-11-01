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

		layout();
		getAllInventoryItems();
		addItemListenerToCmobo();
	}

	public void layout() {
		frame.setLayout(new GridLayout(0, 1, 1, 2));
		panel1.add(navigationLabel);
		panel1.add(combobox);
		// frame.add(panel1);
		panel2.add(button);
		// frame.add(panel2);
		panel4.add(panel1, BorderLayout.WEST);
		panel4.add(panel2, BorderLayout.EAST);
		frame.add(panel4);
		panel3.add(headerLabel, BorderLayout.CENTER);
		frame.add(panel3);
		panel5.add(table.getTableHeader(), BorderLayout.NORTH);
		panel5.add(table);
		frame.add(panel5);
		panel6.add(updateButton);
		panel6.add(deleteButton);
		panel6.add(insertButton);
		frame.add(panel6);
		borderPanel.setLayout(new GridLayout(0, 1, 20, 0));
		borderPanel.add(panel5);
		borderPanel.add(panel6);

		// borderPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		frame.getContentPane().add(borderPanel, BorderLayout.CENTER);
		frame.setSize(new Dimension(800, 500));
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

			items.add(inventory.getId());
			items.add(inventory.getName());
			items.add(inventory.getItemsInStock());
			items.add(inventory.getUnitPrice());
			items.add(inventory.getShortDescription());
			items.add(inventory.getLongDescription());

			model.addRow(items);
		});
	}

	private void addItemListenerToCmobo() {
		combobox.addItemListener(itemEvent -> {
			if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
				String selected = (String) itemEvent.getItem();
				if (selected.equals("Dashboard")) {
					frame.dispose();
					new DashBoard();
				} else if (selected.equals("Customer Database")) {
					frame.dispose();
					new CustomerDatabase();
				} else if (selected.equals("Staff Database")) {
					frame.dispose();
					new StaffDatabase();
				} else if (selected.equals("Stock and Inventory")) {
					frame.dispose();
					new Stock();
				} else if (selected.equals("Check Out")) {
					frame.dispose();
					new CheckOut();
				} else if (selected.equals("Sales Reports")) {
					frame.dispose();
					new SalesReport();
				} else if (selected.equals("Register Customer")) {
					frame.dispose();
					new RegisterCustomer();
				}
			}
		});
	}

	public static void main(String[] args) {
		new Stock();
	}

}
