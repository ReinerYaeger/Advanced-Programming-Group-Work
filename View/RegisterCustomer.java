package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class RegisterCustomer {
//Create variables
private JFrame frame;
private JLabel registerCustomerLabel;
private JLabel firstNameLabel;
private JLabel lastNameLabel;
private JLabel dateOfBirthLabel;
private JLabel addressLabel;
private JLabel telephoneLabel;
private JLabel emailLabel;
private JLabel dateOfMembershipLabel;
private JLabel dateOfMembershipExpireLabel;
private JTextField firstNameTextField;
private JTextField lastNameTextField;
private JTextField dateOfBirthTextField;
private JTextField addressTextField;
private JTextField telephoneTextField;
private JTextField emailTextField;
private JTextField dateOfMembershipTextField;
private JTextField dateOfMembershipExpireTextField;
private JButton button;
private JPanel firstNamePanel;
private JPanel lastNamePanel;
private JPanel dateOfBirthPanel;
private JPanel addressPanel;
private JPanel telephonePanel;
private JPanel emailPanel;
private JPanel dateOfMembershipPanel;
private JPanel dateOfMembershipExpirePanel;
private JPanel buttonPanel;
private JPanel registerCustomerPanel;


public RegisterCustomer() {
frame = new JFrame("Register Customer");
registerCustomerLabel = new JLabel("Register Customer");
firstNameLabel = new JLabel("First Name: ");
lastNameLabel = new JLabel("Last Name: ");
dateOfBirthLabel = new JLabel("Date of Birth:");
addressLabel = new JLabel("Address:");
telephoneLabel = new JLabel("Telephone: ");
emailLabel = new JLabel("Email: ");
dateOfMembershipLabel = new JLabel("Date of Memebership: ");
dateOfMembershipExpireLabel = new JLabel("Date of Membership Expiry: ");

firstNameTextField = new JTextField(20);
lastNameTextField = new JTextField(20);
dateOfBirthTextField = new JTextField(20);
addressTextField = new JTextField(20);
addressTextField = new JTextField(20);
telephoneTextField = new JTextField(20);
emailTextField = new JTextField(20);
dateOfMembershipTextField = new JTextField(20);
dateOfMembershipExpireTextField = new JTextField(20);

button = new JButton("Save");
button.setSize(new Dimension(400, 30));
registerCustomerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
firstNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
lastNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
dateOfBirthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
addressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
telephonePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
dateOfMembershipPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
dateOfMembershipExpirePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

layoutComponents();
}

private void layoutComponents() {
frame.setLayout(new GridLayout(0,1 , 0, 0));
registerCustomerPanel.add(registerCustomerLabel);
frame.add(registerCustomerPanel);

firstNamePanel.setSize(new Dimension(400, 30));
firstNamePanel.add(firstNameLabel);
firstNamePanel.add(firstNameTextField);
frame.add(firstNamePanel);

lastNamePanel.setSize(new Dimension(400, 30));
lastNamePanel.add(lastNameLabel);
lastNamePanel.add(lastNameTextField);
frame.add(lastNamePanel);

dateOfBirthPanel.setSize(new Dimension(400, 30));
dateOfBirthPanel.add(dateOfBirthLabel);
dateOfBirthPanel.add(dateOfBirthTextField);
frame.add(dateOfBirthPanel);

addressPanel.setSize(new Dimension(400, 30));
addressPanel.add(addressLabel);
addressPanel.add(addressTextField);
frame.add(addressPanel);

telephonePanel.setSize(new Dimension(400, 30));
telephonePanel.add(telephoneLabel);
telephonePanel.add(telephoneTextField);
frame.add(telephonePanel);

emailPanel.setSize(new Dimension(400, 30));
emailPanel.add(emailLabel);
emailPanel.add(emailTextField);
frame.add(emailPanel);

dateOfMembershipPanel.setSize(new Dimension(400, 30));
dateOfMembershipPanel.add(dateOfMembershipLabel);
dateOfMembershipPanel.add(dateOfMembershipTextField);
frame.add(dateOfMembershipPanel);

dateOfMembershipExpirePanel.setSize(new Dimension(400, 30));
dateOfMembershipExpirePanel.add(dateOfMembershipExpireLabel);
dateOfMembershipExpirePanel.add(dateOfMembershipExpireTextField);
frame.add(dateOfMembershipExpirePanel);


buttonPanel.setSize(400, 30);
buttonPanel.add(button);
frame.add(buttonPanel);


frame.getRootPane().setBorder(
        BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE)
);
frame.setSize(new Dimension(600, 600));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}


public static void main(String[] args) {
	new RegisterCustomer();
}
}

