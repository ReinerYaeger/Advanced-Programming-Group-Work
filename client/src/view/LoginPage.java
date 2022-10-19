package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class LoginPage {
    //Create variables
    private final JFrame frame;
    private final JLabel mainLabel;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;
    private final JLabel typeOfEmployeeLabel;
    private final JTextField usernameTextField;
    private final JPasswordField passwordField;
    private final JButton button;
    private final JPanel mainPanel;
    private final JPanel namePanel;
    private final JPanel passwordPanel;
    private final JPanel buttonPanel;
    private final JRadioButton rbtnManagement;
    private final JRadioButton rbtnInventory;
    private final JRadioButton rbtnAccountingAndSales;


    public LoginPage() {
        frame = new JFrame("Login Page");
        mainLabel = new JLabel("Main");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel();
        typeOfEmployeeLabel = new JLabel("Type of Employee: ");
        usernameTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        button = new JButton("Login");
        button.setSize(new Dimension(400, 30));
        mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));


        rbtnManagement = new JRadioButton("Management");
        rbtnManagement.setBounds(100, 50, 100, 30);
        rbtnInventory = new JRadioButton("Inventory");
        rbtnInventory.setBounds(100, 100, 100, 30);
        rbtnAccountingAndSales = new JRadioButton("Accounting and Sales");
        rbtnAccountingAndSales.setBounds(100, 100, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        //Add the Radio Buttons to the Button Group
        bg.add(rbtnManagement);
        bg.add(rbtnInventory);
        bg.add(rbtnAccountingAndSales);
        layoutComponents();
    }

    private void layoutComponents() {
        frame.setLayout(new GridLayout(0, 1, 0, 0));
        mainPanel.add(mainLabel);
        frame.add(mainPanel);
        namePanel.setSize(new Dimension(400, 30));
        namePanel.add(usernameLabel);
        namePanel.add(usernameTextField);
        frame.add(namePanel);
        passwordPanel.setSize(new Dimension(400, 30));
        passwordLabel.setText("Password: ");
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        frame.add(passwordPanel);

        /*frame.add(typeOfEmployeeLabel);
        frame.add(rbtnManagement);
        frame.add(rbtnInventory);
        frame.add(rbtnAccountingAndSales);*/
        frame.add(button);

        buttonPanel.setSize(400, 30);
        buttonPanel.add(button);
        frame.add(buttonPanel);

        frame.getRootPane().setBorder(
            BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE)
        );
        frame.setSize(new Dimension(450, 450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}