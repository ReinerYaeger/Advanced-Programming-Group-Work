package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Database extends JFrame implements ActionListener {


    private static final long serialVersionUID = 1L;
    private final JFrame frame;
    private final JTabbedPane tab;
    private final JPanel dashboard;
    private final JPanel management;
    private final JPanel inventory;
    private final JPanel accounting;
    private final JLabel navigationLabel;
    private final JPanel navigationPanel;
    private final JPanel logoutPanel;
    private final JPanel headerPanel;
    private final JPanel logNavPanel;
    private final JPanel tabPanel;
    private final JComboBox<String> combobox;
    private final JButton logoutBtn;
    private final JLabel headerLabel;

    Database( ) {
        frame = new JFrame();
        dashboard = new JPanel();
        management = new JPanel();
        inventory = new JPanel();
        accounting = new JPanel();
        tab = new JTabbedPane();
        tab.setBounds(100, 100, 700, 400);
        //navigationPanel =new JPanel();
        navigationLabel = new JLabel("Navigation:");

        logoutBtn = new JButton("Logout");
        String[] navigation = {" ", "Dashboard", "Customer Database", "Staff Database", "Stock and Inventory", "Check Out", "Sales Reports", "Register Customer"};
        combobox = new JComboBox<>(navigation);
        combobox.setBounds(100, 50, 150, 20);
        headerLabel = new JLabel("Staff Database");
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        logNavPanel = new JPanel(new BorderLayout(0, 0));
        tabPanel = new JPanel(new BorderLayout(1, 0));
        layout();
    }

    public void layout( ) {
        frame.setLayout(new GridLayout(0, 1, 1, 2));

        navigationPanel.add(navigationLabel);
        navigationPanel.add(combobox);

        logoutPanel.add(logoutBtn);
        logNavPanel.add(navigationPanel, BorderLayout.WEST);
        logNavPanel.add(logoutPanel, BorderLayout.EAST);
        frame.add(logNavPanel);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        frame.add(headerPanel);

        //frame.add(navigationPanel);
        tab.add("Dashboard", dashboard);
        tab.add("Management", management);
        tab.add("Inventory", inventory);
        tab.add("Accounting and Sales", accounting);
        tabPanel.add(tab);
        tabPanel.setSize(400, 200);
        frame.add(tabPanel, BorderLayout.CENTER);
        frame.setSize(700, 400);
        frame.setVisible(true);
        //frame.isResizable();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginPage();
            }
        });

/*        combobox.addActionListener(e1 -> {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = combobox.getSelectedItem().toString();
                if (selected.equals("Dashboard")) {
                    tab.setSelectedIndex(0);
                    new DashBoard();
                    System.out.println("Dashboard");
                } else if (selected.equals("Customer Database")) {
                    tab.setSelectedIndex(1);
                    new CustomerDatabase();
                    System.out.println("Customer Database");
                } else if (selected.equals("Staff Database")) {
                    tab.setSelectedIndex(2);
                } else if (selected.equals("Stock and Inventory")) {
                    tab.setSelectedIndex(3);
                    //new Stock();
                    System.out.println("Stock and Inventory");
                } else if (selected.equals("Check Out")) {
                    tab.setSelectedIndex(4);
                    new CheckOut();
                    System.out.println("Check Out");
                } else if (selected.equals("Sales Reports")) {
                    tab.setSelectedIndex(5);
                    new SalesReport();
                    System.out.println("Sales Reports");
                } else if (selected.equals("Register Customer")) {
                    tab.setSelectedIndex(6);
                    new RegisterCustomer();
                    System.out.println("Register Customer");
                }
            }
        });*/



    }

    public static void main(String[] args) {
        new Database();
    }
}
