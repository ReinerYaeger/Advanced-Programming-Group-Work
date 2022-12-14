package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Controller;
import model.LoggedIn;
import model.Staff;

public class LoginPage {
	// Create variables
	private final JFrame frame;
	private final JLabel mainLabel;
	private final JLabel usernameLabel;
	private final JLabel passwordLabel;
	private final JTextField usernameTextField;
	private final JPasswordField passwordField;
	private final JButton button;
	private final JPanel mainPanel;
	private final JPanel namePanel;
	private final JPanel passwordPanel;
	private final JPanel buttonPanel;

	public LoginPage() {
		// Initialize the variables
		frame = new JFrame("Login Page");
		mainLabel = new JLabel("Main");
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel();
		usernameTextField = new JTextField(20);
		passwordField = new JPasswordField(20);
		button = new JButton("Login");
		// set size of button
		button.setSize(new Dimension(400, 30));
		mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Call layoutComponents method
		layoutComponents();
	}

	private void layoutComponents() {
		// Set the Layout Manager for the frame
		frame.setLayout(new GridLayout(0, 1, 0, 0));
		// Add label to panel
		mainPanel.add(mainLabel);
		// Add panel to frame
		frame.add(mainPanel);

		// Set size of panel
		namePanel.setSize(new Dimension(400, 30));
		// Add label to panel
		namePanel.add(usernameLabel);
		// Add textfield to panel
		namePanel.add(usernameTextField);
		// Add panel to frame
		frame.add(namePanel);

		// Set size of panel
		passwordPanel.setSize(new Dimension(400, 30));
		// Set what the component will display
		passwordLabel.setText("Password: ");
		// Add label to panel
		passwordPanel.add(passwordLabel);
		// Add textfield to panel
		passwordPanel.add(passwordField);
		// Add panel to frame
		frame.add(passwordPanel);

		// Set size of panel
		buttonPanel.setSize(400, 30);
		// Add button to panel
		buttonPanel.add(button);
		// Add panel to frame
		frame.add(buttonPanel);

		// Adds an ActionListener to the button
		button.addActionListener((ActionListener) e -> {
			// set the variables to the value from the text and password field
			String username = usernameTextField.getText();
			String password = new String(passwordField.getPassword());

			Controller controller = new Controller();
			Staff staff = controller.loginStaff(username, password);
			if (staff != null) {
				LoggedIn.setStaff(staff);
				// Destroy the frame
				frame.dispose();
				// call a new dashboard and display value the of username
				new DashBoard();
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		});
		// Set color of frame border
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		// Set size of frame
		frame.setSize(new Dimension(450, 450));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set frame to be visible
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginPage();
	}
}
