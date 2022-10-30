package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;
import model.Invoice;

public class SalesReport implements ActionListener {

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

	SalesReport() {
		frame = new JFrame();
		navigationLabel = new JLabel("Navigation:");
		frame.add(navigationLabel);

		logoutBtn =new JButton("Logout");
		String navigation[]= {" ","Dashboard","StaffDatabase",
				"StaffDatabase","Stock and Inventory",
				"Check Out","Sales Reports","Register Customer"};
		 combobox=new JComboBox<>(navigation);
		//combobox.setBounds(100, 50, 0, 0);
		combobox.setSelectedIndex(0);
		frame.add(combobox);
		label = new JLabel("Sale Reports");
		dateLabel = new JLabel("Date mm/dd/yyyy");
		fromLabel = new JLabel("From:");
		fromTextField = new JTextField();
		toLabel = new JLabel("To");
		toTextField = new JTextField();
		printButton = new JButton("Print");
		layout();
		addActionListener();
	}

	private void layout() {
		frame.setLayout(new GridBagLayout());
		// navigationLabel.setSize(150,20);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
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

		logoutBtn.addActionListener(e->{
			frame.dispose();
			new LoginPage();
		});
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
		// ADD EVERYTHING TO A PANEL AND THEN ADD THE BORDER
		// frame.getContentPane().add(toTextField, BorderLayout.CENTER);
		frame.setSize(600, 200);
		frame.setVisible(true);
		frame.isResizable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPage();
            }
        });
	}

	private void addActionListener() {
		printButton.addActionListener(this);
	}

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

			System.out.println("In Sales Report");
			System.out.println(invoices);

			System.out.println("Printed");

		}

		if(combobox.getSelectedItem().equals("Dashboard")){
			frame.dispose();
			new DashBoard();
		}
		combobox.addItemListener(itemEvent->{
			if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
				String selected = (String) itemEvent.getItem();
				if(selected.equals("Dashboard")) {
					frame.dispose();
					new DashBoard();
				}
				else if(selected.equals("Customer StaffDatabase")) {
					frame.dispose();
					new CustomerDatabase();
				}
				else if(selected.equals("Staff StaffDatabase")) {
					frame.dispose();
					new StaffDatabase();
				}
				else if(selected.equals("Stock and Inventory")) {
					//frame.dispose();
					//new StockAndInventory();
				}
				else if(selected.equals("Check Out")) {
					frame.dispose();
					new CheckOut();
				}
				else if(selected.equals("Sales Reports")) {
					frame.dispose();
					new SalesReport();
				}
				else if(selected.equals("Register Customer")) {
					frame.dispose();
					new RegisterCustomer();
				}
			}
		});

	}

	public static void main(String[] args) {
		new SalesReport();

	}

}
