package view;

import controller.Controller;
import model.Department;
import model.Staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class RegisterStaff {

	// Create variables
		private JFrame frame;
		private JLabel registerStaffLabel;
		private JLabel firstNameLabel;
		private JLabel lastNameLabel;
		private JLabel dateOfBirthLabel;
		private JLabel addressLabel;
		private JLabel telephoneLabel;
		private JLabel emailLabel;
		private JLabel typeLabel;
		private JLabel departmentLabel;
		private JLabel passwordLabel;
		private JTextField firstNameTextField;
		private JTextField lastNameTextField;
		private JComboBox<Integer> yearBox;
		private JComboBox<Integer> monthBox;
		private JComboBox<Integer> dayBox;
		private JComboBox<String> typeBox;
		private JComboBox<String> departmentBox;
		private JTextField addressTextField;
		private JTextField telephoneTextField;
		private JTextField emailTextField;
		private JPasswordField passwordField;
		private JButton button;
		private JPanel firstNamePanel;
		private JPanel lastNamePanel;
		private JPanel dateOfBirthPanel;
		private JPanel addressPanel;
		private JPanel telephonePanel;
		private JPanel emailPanel;
		private JPanel buttonPanel;
		private JPanel registerStaffPanel;
		private JPanel typePanel;
		private JPanel departmentPanel;
		private JPanel passwordPanel;

		public RegisterStaff() {
			// Initialize the variables
			frame = new JFrame("Register Staff");
			registerStaffLabel = new JLabel("Register Staff");
			firstNameLabel = new JLabel("First Name: ");
			lastNameLabel = new JLabel("Last Name: ");
			dateOfBirthLabel = new JLabel("Date of Birth -");
			addressLabel = new JLabel("Address:");
			telephoneLabel = new JLabel("Telephone: ");
			emailLabel = new JLabel("Email: ");
			typeLabel = new JLabel("Type of Worker: ");
			departmentLabel = new JLabel("Department Name: ");
			passwordLabel = new JLabel("Password: ");
			firstNameTextField = new JTextField(20);
			lastNameTextField = new JTextField(20);
			addressTextField = new JTextField(20);
			addressTextField = new JTextField(20);
			telephoneTextField = new JTextField(20);
			emailTextField = new JTextField(20);
			passwordField = new JPasswordField(20);
			button = new JButton("Save");
			// Set component size
			button.setSize(new Dimension(400, 30));
			registerStaffPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			firstNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			lastNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			dateOfBirthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			addressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			telephonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			typePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			departmentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			

			yearBox = new JComboBox<>();
			for (int i = 1900; i <= LocalDateTime.now().getYear(); i++) {
				yearBox.addItem(i);
			}

			monthBox = new JComboBox<>();
			for (int i = 1; i <= 12; i++) {
				monthBox.addItem(i);
			}

			dayBox = new JComboBox<>();
			for (int i = 1; i <= 31; i++) {
				dayBox.addItem(i);

			}
			
			String[] workerType = {"", "Manager", "Supervisor", "Line-Worker" };
			typeBox = new JComboBox<>(workerType);
			
			String[] departmentType = {"", "Management", "Inventory", "Accounting and Sales" };
			departmentBox = new JComboBox<>(departmentType);
			
			
			// Call layoutComponents method
			layoutComponents();
		}

		private void layoutComponents() {
			// Set the Layout Manager for the frame
			frame.setLayout(new GridLayout(0, 1, 0, 0));
			// Add Label to panel
			registerStaffPanel.add(registerStaffLabel);
			// Add panel to frame
			frame.add(registerStaffPanel);

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
			
			typePanel.add(typeLabel);
			typePanel.add(typeBox);
			frame.add(typePanel);
			
			departmentPanel.add(departmentLabel);
			departmentPanel.add(departmentBox);
			frame.add(departmentPanel);
			
			passwordPanel.add(passwordLabel);
			passwordPanel.add(passwordField);
			frame.add(passwordPanel);

			buttonPanel.setSize(400, 30);
			buttonPanel.add(button);
			// Add panel to frame
			frame.add(buttonPanel);

			button.addActionListener(e -> {
				String name = firstNameTextField.getText() + " " + lastNameTextField.getText();

				int year = (int) yearBox.getSelectedItem();
				int month = (int) monthBox.getSelectedItem();
				int day = (int) dayBox.getSelectedItem();
				LocalDate dateOfBirth = LocalDate.of(year, month, day);

				String address = addressTextField.getText();

				// Validate phone number

				String regex = "^\\d{10}$";
				Pattern regPattern = Pattern.compile(regex);
				Matcher matcher = regPattern.matcher(telephoneTextField.getText());
				if (!matcher.matches()) {
					JOptionPane.showMessageDialog(null, "Invalid phone number");
					return;
				}
				String telephone = telephoneTextField.getText();
				String email = emailTextField.getText();
				String password = passwordField.getPassword().toString();
				String department = (String) departmentBox.getSelectedItem();
				String type = (String) typeBox.getSelectedItem();
				// Create a new Staff object

				Department departmentObj = new Department();
				departmentObj.setName(department);
				if(department == "Management") {
					departmentObj.setDepartmentCode("MGT101");
				}
				else if(department == "Inventory") {
					departmentObj.setDepartmentCode("INV101");
				}
				else if(department == "Accounting and Sales") {
					departmentObj.setDepartmentCode("ACCS101");
				}

				Staff staff =new Staff(name,dateOfBirth, address, telephone,email,department);
				/*Staff staff = new Staff(name,password, dateOfBirth, address, telephone, email, departmentObj, type);*/


				new Controller().registerStaff(staff);
				JOptionPane.showMessageDialog(null, "Customer staff successfully");
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
			new RegisterStaff();
		}
	}

