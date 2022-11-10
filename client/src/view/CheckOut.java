package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.Controller;

public class CheckOut {

	//Create variables
	private final JLabel headerLabel;
	private final JLabel invoiceLabel;
	private final JLabel dateLabel;
	private final JLabel cashierLabel;
	private final JLabel customerLabel;
	private final JLabel idLabel;
	private final JLabel itemLabel;
	private final JLabel quantityLabel;
	private final JLabel memberLabel;
	private final JLabel discountLabel;
	private final JLabel taxLabel;
	private final JLabel totalLabel;
	private final JLabel recievedLabel;
	private final JLabel changeLabel;
	private final JFrame frame;
	private final JTextField invoiceTextField;
	private final JTextField dateTextField;
	private final JTextField customerTextField;
	private final JTextField idTextField;
	private final JTextField itemTextField;
	private final JTextField quantityTextField;
	private final JTextField recievedTextField;
	private final JRadioButton yesMemberRadioButton;
	private final JRadioButton noMemberRadioButton;
	private final JTextField discountTextField;
	private final ButtonGroup buttonGroup;
	private final JButton logoutBtn;
	private final JLabel navigationLabel;
	private final JComboBox<String> combobox;
	private GridBagConstraints gbc;
	private Date date;
    private String dateComp;
	private final JTextField taxTextField;
	private final JTextField totalTextField;
	private final JTextField changeTextField;
	private final JTextField cashierTextField;
    //private String invoiceNumber;
	public CheckOut() {
		// Initialize the variables
		frame = new JFrame();
		navigationLabel = new JLabel("Navigation:");
		logoutBtn = new JButton("Logout");
		//create array of string
		String[] navigation = { " ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory",
				"Check Out", "Sales Reports", "Register Customer" };
		//Creates a JComboBox that contains the elements in the specified array
		combobox = new JComboBox<>(navigation);

		// Initialize the variables
		headerLabel = new JLabel("Check Out");
		invoiceLabel = new JLabel("Invoice#:");
		// use random number to set invoice number
		
		invoiceTextField = new JTextField(50);
		dateLabel = new JLabel("Billing Date");
		//format and set date
		date=new Date(System.currentTimeMillis());
		dateComp=date.toString();
		dateTextField=new JTextField(dateComp);
		//set field to not be editable
		dateTextField.setEditable(false);
		cashierLabel = new JLabel("Cashier");
		cashierTextField = new JTextField();
		customerLabel = new JLabel("Customer");
		customerTextField = new JTextField(50);
		idLabel = new JLabel("Customer ID");
		idTextField = new JTextField(20);
		itemLabel = new JLabel("Item");
		itemTextField = new JTextField(50);
		quantityLabel = new JLabel("Quantity of Item");
		quantityTextField = new JTextField(50);
		memberLabel = new JLabel("Member");
		yesMemberRadioButton = new JRadioButton("Yes");
		yesMemberRadioButton.setBounds(100, 50, 100, 30);
		noMemberRadioButton = new JRadioButton("No");
		noMemberRadioButton.setBounds(100, 100, 100, 30);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(yesMemberRadioButton);
		buttonGroup.add(noMemberRadioButton);
		discountLabel = new JLabel("Discount");
        discountTextField=new JTextField();
		taxLabel = new JLabel("Tax");
		taxTextField = new JTextField();
		totalLabel = new JLabel("Total");
		totalTextField = new JTextField();

		recievedLabel = new JLabel("Amount Received:");
		recievedTextField = new JTextField();
		changeLabel = new JLabel("Change");
		changeTextField = new JTextField();
		
		
		//call methods created
		layout();
		actionListener();
		addItemListenerToCmobo();

		frame.setResizable(true);

	}

	public static void main(String[] args) {
		//call new CheckOut
		new CheckOut();
	}

	public void layout() {
		// Set the Layout Manager for the frame
		frame.setLayout(new GridBagLayout());
		//Re-Initialize the GridBag Constraints
		gbc = new GridBagConstraints();
		//Set location in terms of row and column
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		//Set internal padding
		gbc.ipadx = 50;
		gbc.ipady = 20;
		//sets where, within the frame, to place the component. 
		gbc.anchor = GridBagConstraints.NORTHWEST;
		//Add component to frame
		frame.add(navigationLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(combobox, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.EAST;
		frame.add(logoutBtn, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.EAST;
		frame.add(headerLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(invoiceLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(invoiceTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(dateLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(dateTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(cashierLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(cashierTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(customerLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(customerTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(idLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(idTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(itemLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(itemTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(quantityLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(quantityTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(memberLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		frame.add(yesMemberRadioButton, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		frame.add(noMemberRadioButton, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(discountLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(discountTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(taxLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.ipadx = 100;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(taxTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(totalLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(totalTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(recievedLabel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(recievedTextField, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(changeLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(changeTextField, gbc);
		
		//Set size of frame
		frame.setSize(new Dimension(850, 500));
		//Set frame to be visible
		frame.setVisible(true);
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionListener() {
		////Adds an ActionListener to the button.
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//destroy frame
				frame.dispose();
				//call new loginpage
				new LoginPage();
			}
		});

		//Adds an ActionListener to the button
		noMemberRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (noMemberRadioButton.isSelected()) {
					//Ask if a discount is needed
					int option = JOptionPane.showConfirmDialog(null, "Do you want a discount",
							"Want to become a member?", JOptionPane.YES_NO_OPTION);

					//if yes call new RegisterCustomer
					if (option == JOptionPane.YES_OPTION) {
						Controller cont = new Controller();

						new RegisterCustomer();
						yesMemberRadioButton.setSelected(true);
						//If no Tells that yoou can still register later
					} else if (option == JOptionPane.NO_OPTION) {

						JOptionPane.showMessageDialog(null, "You can still become a member later");
					}
				}
			}
		});

		//Adds an ActionListener to the button
		yesMemberRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				if (yesMemberRadioButton.isSelected()) {
					String value = JOptionPane.showInputDialog(null, "Please enter your phone number",
							JOptionPane.OK_OPTION);

					// Validate phone number
					String regex = "^\\d{10}$";
					Pattern regPattern = Pattern.compile(regex);
					Matcher matcher = regPattern.matcher(value);
					if (!matcher.matches()) {
						JOptionPane.showMessageDialog(null, "Invalid phone number");
					} else {
						Controller cont = new Controller();

						if (cont.verifyCustomer(value)) {
							JOptionPane.showMessageDialog(null, "Customer verified");
							//double discountCost = cont.registerDiscount();
							//TODO
						} else {
							JOptionPane.showConfirmDialog(null,
									"Customer not verified\nDo you want to become a member?");

							int option = JOptionPane.showConfirmDialog(null,
									"Customer not registered\nDo you want to register?", "Want to become a member?",
									JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.YES_OPTION) {
								new RegisterCustomer();
								yesMemberRadioButton.setSelected(true);
							} else if (option == JOptionPane.NO_OPTION) {

								JOptionPane.showMessageDialog(null, "You can still become a member later");
							}

						}
					}
				}
			}

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
					//Calls new RegisterCustomer
					new RegisterCustomer();
				}
			}
		});
	}
	
}
