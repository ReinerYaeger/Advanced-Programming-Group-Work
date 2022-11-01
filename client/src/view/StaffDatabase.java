package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class StaffDatabase extends JFrame {

	private static final long serialVersionUID = 1L;
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

	StaffDatabase() {
		frame = new JFrame();
		dashboard = new JPanel();
		management = new JPanel();
		inventory = new JPanel();
		accounting = new JPanel();
		tab = new JTabbedPane();
		tab.setBounds(100, 100, 700, 400);
		// navigationPanel =new JPanel();
		navigationLabel = new JLabel("Navigation:");

		logoutBtn = new JButton("Logout");
		String[] navigation = { " ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory",
				"Check Out", "Sales Reports", "Register Customer" };
		combobox = new JComboBox<>(navigation);
		combobox.setBounds(100, 50, 150, 20);
		headerLabel = new JLabel("Staff StaffDatabase");
		navigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		logNavPanel = new JPanel(new BorderLayout(0, 0));
		tabPanel = new JPanel(new BorderLayout(1, 0));
		layout();
		addItemListenerToCmobo();
	}

	@Override
	public void layout() {
		frame.setLayout(new GridLayout(0, 1, 1, 2));

		navigationPanel.add(navigationLabel);
		navigationPanel.add(combobox);

		logoutPanel.add(logoutBtn);
		logNavPanel.add(navigationPanel, BorderLayout.WEST);
		logNavPanel.add(logoutPanel, BorderLayout.EAST);
		frame.add(logNavPanel);
		headerPanel.add(headerLabel, BorderLayout.CENTER);
		frame.add(headerPanel);

		// frame.add(navigationPanel);
		tab.add("Dashboard", dashboard);
		tab.add("Management", management);
		tab.add("Inventory", inventory);
		tab.add("Accounting and Sales", accounting);
		tabPanel.add(tab);
		tabPanel.setSize(400, 200);
		frame.add(tabPanel, BorderLayout.CENTER);
		frame.setSize(700, 400);
		frame.setVisible(true);
		// frame.isResizable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage();
			}
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
		new StaffDatabase();
	}
}
