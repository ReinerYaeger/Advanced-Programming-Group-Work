package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashBoard {
	//Create variables
    private JFrame frame;
    private JLabel dashBoardLabel;
    private JPanel dashBoardPanel;
    private JButton customerDatabaseButton;
    private JButton staffDatabaseButton;
    private JButton stockAndIventoryDatabaseButton;
    private JButton checkOutButton;
    private JButton salesReportButton;
    private JButton registerCustomerButton;
    private JButton logoutBtn;

    //Create an object of the GridBagConstraints
    private GridBagConstraints gbc;


    public DashBoard(String username) {
        //Initialize the variables
        frame = new JFrame("DashBoard");
        dashBoardLabel = new JLabel("DashBoard Hi " + username);
        dashBoardPanel = new JPanel();
        logoutBtn = new JButton("Logout");
        customerDatabaseButton = new JButton("Customer StaffDatabase");
        staffDatabaseButton = new JButton("Staff StaffDatabase");
        stockAndIventoryDatabaseButton = new JButton("Stock and Inventory");
        checkOutButton = new JButton("Check Out");
        salesReportButton = new JButton("Sales Report");
        registerCustomerButton = new JButton("Register Customer");
        gbc = new GridBagConstraints();
        
      //Call layoutComponents method
        layoutComponents(); 
    }

    public DashBoard() {
        //Initialize the variables
        frame = new JFrame("DashBoard");
        dashBoardLabel = new JLabel("DashBoard");
        dashBoardPanel = new JPanel();
        logoutBtn = new JButton("Logout");
        customerDatabaseButton = new JButton("Customer Database");
        staffDatabaseButton = new JButton("Staff Database");
        stockAndIventoryDatabaseButton = new JButton("Stock and Inventory");
        checkOutButton = new JButton("Check Out");
        salesReportButton = new JButton("Sales Report");
        registerCustomerButton = new JButton("Register Customer");
        gbc = new GridBagConstraints();

      //Call layoutComponents method
        layoutComponents();
    }
    private void layoutComponents() {
        //Set the Layout Manager for the frame
        frame.setLayout(new GridBagLayout());
      
        
        
        //Add label to panel
        dashBoardPanel.add(dashBoardLabel);
        //Add panel to frame
        frame.add(dashBoardPanel);

      //Re-Initialize the GridBag Constraints
        gbc = new GridBagConstraints();
        //Set location in terms of row and column
        gbc.gridx = 2;
        gbc.gridy = 0;
        //Set internal padding
        gbc.ipadx = 20;
        gbc.ipady = 10;
      //Set location in the frame
        gbc.anchor = GridBagConstraints.NORTH;
      //Set the external padding 
        gbc.insets = new Insets(10, 10, 11, 0);
        //Add button to frame
        frame.add(logoutBtn, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 80;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 11, 5);
        frame.add(customerDatabaseButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 70;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 11, 0);
        frame.add(staffDatabaseButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.ipadx = 45;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 11, 5);
        frame.add(stockAndIventoryDatabaseButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx = 140;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 11, 0);
        frame.add(checkOutButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipadx = 75;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 11, 0);
        frame.add(salesReportButton, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.ipadx = 50;
        gbc.ipady = 20;
        gbc.insets = new Insets(10, 10, 11, 5);
        frame.add(registerCustomerButton, gbc);

      //Set color of frame border
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE) );
      //Set size of frame
        frame.setSize(new Dimension(670, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Set frame to be visible
        frame.setVisible(true);

            //Adds an ActionListener to the button
	    logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		 //Destroy the frame   
                frame.dispose();
		    //calls a new loginpage
                new LoginPage();
            }
        });
         // Adds an ActionListener to the button
        customerDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		//Destroy the frame    
                frame.dispose();
		     //calls a new customerdatabase
                new CustomerDatabase();
            }
        });
         //Adds an ActionListener to the button.
        staffDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		//Destroy the frame    
                frame.dispose();
		     //calls a new staffdatabase
                new StaffDatabase();
            }
        });
        //Adds an ActionListener to the button
        stockAndIventoryDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		//Destroy the frame    
                frame.dispose();
		     //calls a new stock
                new Stock();
            }
        });
        // Adds an ActionListener to the button.
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		     //calls a new checkout
                new CheckOut();
            }
        });
        //Adds an ActionListener to the button.
        salesReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		     //calls a new salesreport
                new SalesReport();
            }
        });
         //Adds an ActionListener to the button.
        registerCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		     //calls a new registercustomer
                new RegisterCustomer();
            }
        });





    }
    public static void main(String[] args) {
	     //calls a new dashboard
        new DashBoard();
    }
}
