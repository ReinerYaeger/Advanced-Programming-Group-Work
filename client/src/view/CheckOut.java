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


	private JLabel headerLabel;
	private JLabel invoiceLabel;
	private JLabel dateLabel;
	private JLabel cashierLabel;
	private JLabel customerLabel;
	private JLabel idLabel;
	private JLabel itemLabel;
	private JLabel quantityLabel;
	private JLabel memberLabel;
	private JLabel discountLabel;
	private JLabel taxLabel;
	private JLabel totalLabel;
	private JLabel recievedLabel;
	private JLabel changeLabel;
	private JFrame frame;
	private JTextField invoiceTextField;
	private JTextField customerTextField;
	private JTextField idTextField;
	private JTextField itemTextField;
	private JTextField quantityTextField;
	private JTextField recievedTextField;
	private JRadioButton yesMemberRadioButton;
	private JRadioButton noMemberRadioButton;
	private ButtonGroup buttonGroup;
	private GridBagConstraints gbc;
	private JButton logoutBtn;
	private JLabel navigationLabel;
	private JComboBox<String> combobox;
	public CheckOut() {
   frame=new JFrame();

    navigationLabel=new JLabel("Navigation:");


logoutBtn =new JButton("Logout");
String navigation[]= {" ","Dashboard","Customer Database","Staff Database","Stock and Inventory","Check Out","Sales Reports","Register Customer"};
 combobox=new JComboBox<>(navigation);
 
        headerLabel=new JLabel("Check Out");
		invoiceLabel=new JLabel("Invoice#:");
		//use random number to set invoice number
		invoiceTextField= new JTextField(50);
		dateLabel=new JLabel("Billing Date");
		cashierLabel=new JLabel("Cashier");
		customerLabel=new JLabel("Customer");
		customerTextField= new JTextField(50);
		idLabel=new JLabel("Customer ID");
		idTextField= new JTextField(20); 
		itemLabel=new JLabel("Item");
		itemTextField= new JTextField(50);
		quantityLabel=new JLabel("Quantity of Item");
		quantityTextField= new JTextField(50);
		memberLabel=new JLabel("Member");
		yesMemberRadioButton=new JRadioButton("Yes");
		yesMemberRadioButton.setBounds(100,50,100,30);
		noMemberRadioButton=new JRadioButton("No");
		noMemberRadioButton.setBounds(100,100,100,30);

		buttonGroup=new ButtonGroup();
		buttonGroup.add(yesMemberRadioButton);
		buttonGroup.add(noMemberRadioButton);
		discountLabel=new JLabel("Discount");
		
		taxLabel=new JLabel("Tax");
		
		 totalLabel=new JLabel("Total");
		
		 recievedLabel=new JLabel("Amount Recieved:");
		 recievedTextField=new JTextField();
		 changeLabel=new JLabel("Change");
		layout();
		
	
	}
	public void layout() {
		frame.setLayout(new GridBagLayout());
		gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(navigationLabel,gbc);

		gbc=new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1; 
		gbc.ipadx = 20;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		frame.add(combobox,gbc);

		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.ipadx = 20;
		gbc.ipady = 10;
		gbc.anchor = GridBagConstraints.EAST;
		frame.add(logoutBtn, gbc);
		gbc=new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.EAST;
		frame.add(headerLabel,gbc);
		gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(invoiceLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(dateLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(cashierLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(customerLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1; 
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(customerTextField,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(idLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 4;
		gbc.gridwidth = 1; 
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(idTextField,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(itemLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1; 
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(itemTextField,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(quantityLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 5;
		gbc.gridwidth = 1; 
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(quantityTextField,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(memberLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1; 
        frame.add(yesMemberRadioButton,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1; 
        frame.add(noMemberRadioButton,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(discountLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(taxLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(totalLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(recievedLabel,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1; 
		gbc.ipadx = 150;
		gbc.ipady = 5;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(recievedTextField,gbc);
        gbc=new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.gridwidth = 1; 
		gbc.ipadx = 50;
		gbc.ipady = 20;
		gbc.anchor = GridBagConstraints.NORTHWEST;
        frame.add(changeLabel,gbc);
       
		frame.setSize(new Dimension(800,500));
		frame.setVisible(true);
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
					} else if (option == JOptionPane.NO_OPTION) {
						//TODO Validate input and add to databse the new customer and serch data base if cusomter is present
						JOptionPane.showMessageDialog(null,
													  "You can still become a member later");
					}

				} else if (yesMemberRadioButton.isSelected()) {
					String value = JOptionPane.showInputDialog(null,
												  "Please enter your phone number", JOptionPane.OK_OPTION);

					String regex =  "^\\d{10}$";
					Pattern regPattern = Pattern.compile(regex);
					Matcher matcher = regPattern.matcher(value);
					if (!matcher.matches()) {
						JOptionPane.showMessageDialog(null, "Invalid phone number");
						return;
            		}else{
						Controller cont = new Controller();
						cont.verifyCustomer(value);
					}
				}
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new CheckOut();
	}
}

