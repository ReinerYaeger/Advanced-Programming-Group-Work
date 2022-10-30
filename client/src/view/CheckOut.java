package view;

import controller.Controller;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class CheckOut {


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
    private final JTextField customerTextField;
    private final JTextField idTextField;
    private final JTextField itemTextField;
    private final JTextField quantityTextField;
    private final JTextField recievedTextField;
    private final JRadioButton yesMemberRadioButton;
    private final JRadioButton noMemberRadioButton;
    private final ButtonGroup buttonGroup;
    private final JButton logoutBtn;
    private final JLabel navigationLabel;
    private final JComboBox<String> combobox;
    private GridBagConstraints gbc;

    public CheckOut( ) {
        frame = new JFrame();

        navigationLabel = new JLabel("Navigation:");


        logoutBtn = new JButton("Logout");
        String[] navigation = {" ", "Dashboard", "Customer StaffDatabase", "Staff StaffDatabase", "Stock and Inventory", "Check Out", "Sales Reports", "Register Customer"};
        combobox = new JComboBox<>(navigation);

        headerLabel = new JLabel("Check Out");
        invoiceLabel = new JLabel("Invoice#:");
        //use random number to set invoice number
        invoiceTextField = new JTextField(50);
        dateLabel = new JLabel("Billing Date");
        cashierLabel = new JLabel("Cashier");
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

        taxLabel = new JLabel("Tax");

        totalLabel = new JLabel("Total");

        recievedLabel = new JLabel("Amount Received:");
        recievedTextField = new JTextField();
        changeLabel = new JLabel("Change");
        layout();
        actionListener();

        frame.setResizable(true);


    }

    public static void main(String[] args) {
        new CheckOut();
    }

    public void layout( ) {
        frame.setLayout(new GridBagLayout());
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
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(dateLabel, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(cashierLabel, gbc);
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
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(taxLabel, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(totalLabel, gbc);
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

        frame.setSize(new Dimension(800, 500));
        frame.setVisible(true);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void actionListener( ) {
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPage();
            }
        });

        noMemberRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (noMemberRadioButton.isSelected()) {
                    int option = JOptionPane.showConfirmDialog(null,
                                                               "Do you want a discount",
                                                               "Want to become a member?",
                                                               JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        Controller cont = new Controller();

                        new RegisterCustomer();
                        yesMemberRadioButton.setSelected(true);
                    } else if (option == JOptionPane.NO_OPTION) {

                        JOptionPane.showMessageDialog(null,
                                                      "You can still become a member later");
                    }
                }
            }
        });

        yesMemberRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (yesMemberRadioButton.isSelected()) {
                    String value = JOptionPane.showInputDialog(null,
                                                               "Please enter your phone number",
                                                               JOptionPane.OK_OPTION);

                    String regex = "^\\d{10}$";
                    Pattern regPattern = Pattern.compile(regex);
                    Matcher matcher = regPattern.matcher(value);
                    if (! matcher.matches()) {
                        JOptionPane.showMessageDialog(null, "Invalid phone number");
                    } else {
                        Controller cont = new Controller();

                        if (cont.verifyCustomer(value)) {
                            JOptionPane.showMessageDialog(null, "Customer verified");

                            cont.registerDiscount();

                        } else {
                            JOptionPane.showConfirmDialog(null,
                                                          "Customer not verified\nDo you want to become a member?");

                            int option = JOptionPane.showConfirmDialog(null,
                                                                       "Customer not registered\nDo you want to register?",
                                                                       "Want to become a member?",
                                                                       JOptionPane.YES_NO_OPTION);
                            if (option == JOptionPane.YES_OPTION) {
                                new RegisterCustomer();
                                yesMemberRadioButton.setSelected(true);
                            } else if (option == JOptionPane.NO_OPTION) {

                                JOptionPane.showMessageDialog(null,
                                                              "You can still become a member later");
                            }

                        }
                    }
                }
            }

        });

    }
}

