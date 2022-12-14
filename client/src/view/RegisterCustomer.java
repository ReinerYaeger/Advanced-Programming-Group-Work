package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Customer;

public class RegisterCustomer {
	// Create variables
	private JFrame frame;
	private JLabel registerCustomerLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel dateOfBirthLabel;
	private JLabel addressLabel;
	private JLabel telephoneLabel;
	private JLabel emailLabel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JComboBox<Integer> yearBox;
	private JComboBox<Integer> monthBox;
	private JComboBox<Integer> dayBox;
	private JTextField addressTextField;
	private JTextField telephoneTextField;
	private JTextField emailTextField;
	private JButton button;
	private JPanel firstNamePanel;
	private JPanel lastNamePanel;
	private JPanel dateOfBirthPanel;
	private JPanel addressPanel;
	private JPanel telephonePanel;
	private JPanel emailPanel;
	private JPanel buttonPanel;
	private JPanel registerCustomerPanel;

	public RegisterCustomer() {
		// Initialize the variables
		frame = new JFrame("Register Customer");
		registerCustomerLabel = new JLabel("Register Customer");
		firstNameLabel = new JLabel("First Name: ");
		lastNameLabel = new JLabel("Last Name: ");
		dateOfBirthLabel = new JLabel("Date of Birth -");
		addressLabel = new JLabel("Address:");
		telephoneLabel = new JLabel("Telephone: ");
		emailLabel = new JLabel("Email: ");
		firstNameTextField = new JTextField(20);
		lastNameTextField = new JTextField(20);
		addressTextField = new JTextField(20);
		addressTextField = new JTextField(20);
		telephoneTextField = new JTextField(20);
		emailTextField = new JTextField(20);
		button = new JButton("Save");
		// Set component size
		button.setSize(new Dimension(400, 30));
		registerCustomerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		firstNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		lastNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		dateOfBirthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		addressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		telephonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		//Add the year 1900 to the curreent year we are in to the JComboBox
		yearBox = new JComboBox<>();
		for (int i = 1900; i <= LocalDateTime.now().getYear(); i++) {
			yearBox.addItem(i);
		}

		//Add numbers 1 to 12 to the JComboBox
		monthBox = new JComboBox<>();
		for (int i = 1; i <= 12; i++) {
			monthBox.addItem(i);
		}

		//Add numbers 1 to 31 to the JComboBox
		dayBox = new JComboBox<>();
		for (int i = 1; i <= 31; i++) {
			dayBox.addItem(i);

		}
		// Call layoutComponents method
		layoutComponents();
	}

	private void layoutComponents() {
		// Set the Layout Manager for the frame
		frame.setLayout(new GridLayout(0, 1, 0, 0));
		// Add Label to panel
		registerCustomerPanel.add(registerCustomerLabel);
		// Add panel to frame
		frame.add(registerCustomerPanel);

		// Set size of component
		firstNamePanel.setSize(new Dimension(400, 30));
		// Add Label to panel
		firstNamePanel.add(firstNameLabel);
		// Add textfield to panel
		firstNamePanel.add(firstNameTextField);
		// Add panel to frame
		frame.add(firstNamePanel);

		// Set size of component
		lastNamePanel.setSize(new Dimension(400, 30));
		// Add Label to panel
		lastNamePanel.add(lastNameLabel);
		// Add textfield to panel
		lastNamePanel.add(lastNameTextField);
		// Add panel to frame
		frame.add(lastNamePanel);

		// Set size of component
		dateOfBirthPanel.setSize(new Dimension(400, 30));
		// Add Label to panel
		dateOfBirthPanel.add(dateOfBirthLabel);
		// Add label to panel
		dateOfBirthPanel.add(new JLabel("year:"));
		// Add combobox to panel
		dateOfBirthPanel.add(yearBox);
		// Add label to panel
		dateOfBirthPanel.add(new JLabel("month:"));
		// Add combobox to panel
		dateOfBirthPanel.add(monthBox);
		// Add label to panel
		dateOfBirthPanel.add(new JLabel("day:"));
		// Add combobox to panel
		dateOfBirthPanel.add(dayBox);
		// Add panel to frame
		frame.add(dateOfBirthPanel);

		addressPanel.setSize(new Dimension(400, 30));
		// Add Label to panel
		addressPanel.add(addressLabel);
		// Add textfield to panel
		addressPanel.add(addressTextField);
		// Add panel to frame
		frame.add(addressPanel);

		telephonePanel.setSize(new Dimension(400, 30));
		// Add Label to panel
		telephonePanel.add(telephoneLabel);
		// Add textfield to panel
		telephonePanel.add(telephoneTextField);
		// Add panel to frame
		frame.add(telephonePanel);

		emailPanel.setSize(new Dimension(400, 30));
		// Add Label to panel
		emailPanel.add(emailLabel);
		// Add textfield to panel
		emailPanel.add(emailTextField);
		// Add panel to frame
		frame.add(emailPanel);

		buttonPanel.setSize(400, 30);
		buttonPanel.add(button);
		// Add panel to frame
		frame.add(buttonPanel);

		//Adds an ActionListener to the button
		button.addActionListener(e -> {
			//Store textfield value in the variable declared
			String name = firstNameTextField.getText() + " " + lastNameTextField.getText();
			String lastName = lastNameTextField.getText();

			//Store the selected value in the variable declared
			int year = (int) yearBox.getSelectedItem();
			int month = (int) monthBox.getSelectedItem();
			int day = (int) dayBox.getSelectedItem();
			
			LocalDate dateOfBirth = LocalDate.of(year, month, day);

			//Store textfield value in the variable declared
			String address = addressTextField.getText();

			// Validate phone number
			String regex = "^\\d{10}$";
			Pattern regPattern = Pattern.compile(regex);
			Matcher matcher = regPattern.matcher(telephoneTextField.getText());
			if (!matcher.matches()) {
				JOptionPane.showMessageDialog(null, "Invalid phone number");
				return;
			}
			//Store textfield value in the variable declared
			String email = emailTextField.getText();

			
			new Controller().registerCustomer(new Customer(name, dateOfBirth, address,
					telephoneTextField.getText(), email));
			JOptionPane.showMessageDialog(null, "Customer registered successfully");
			//Destroy the frame
			frame.dispose();
		});

		// Set color of frame border
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		// Set size of frame
		frame.setSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set frame to be visible
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//call new RegisterCustomer
		new RegisterCustomer();
	}
}
