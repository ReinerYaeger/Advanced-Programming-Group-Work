
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class CustomerDatabase extends JPanel{
	private JFrame frame;
	private JLabel customerDatabaseLabel,searchLabel;
	private TextField searchTextField;
	private JButton logoutButton;
	private JButton navigationButton;	
	private JPanel searchTextFieldPanel;
	private JPanel searchLabelPanel;
	private JPanel table1;
	private JPanel navigationPanel;
	private JPanel logoutPanel;
	private JPanel customerDatabasePanel;
	private JPanel panel1;
	private JPanel panel2;
	private JTable table;
	private JScrollPane jsp;
	
	public CustomerDatabase() {
		frame = new JFrame("Login Page");
		navigationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		logoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		customerDatabasePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		searchTextFieldPanel = new JPanel();
		searchLabelPanel = new JPanel();
		 panel1 = new JPanel(new BorderLayout(0,0));
		 panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		logoutButton = new JButton("Logout");
		navigationButton = new JButton("Navigation");
		customerDatabaseLabel = new JLabel("Customer Database");
		searchTextField = new TextField(30);
		searchLabel = new JLabel("Search");
		table1 = new JPanel(new GridLayout(1,1));
	
		
		String[] columns = {"Customer ID", "Name", "DOB", "Address","Telephone","Email","Date of Membership","Date of Membership Expiry"};
		String[][] data_rows = {

				{"", "", "","","","","",""},
				{"", "", "","","","","",""},


		};

	table = new JTable(data_rows, columns) {
	private static final long serialVersionUID = 1L;
	public boolean isCellEditable(int data_row, int columns) {
	return false;
	}
	
	public Component prepareRenderer(TableCellRenderer
	renderer, int dataRows, int columns) {
	Component row = super.prepareRenderer(renderer,
	dataRows, columns);
	if (dataRows % 2 == 0) {
	row.setBackground(Color.WHITE);
	}else {
	row.setBackground(Color.LIGHT_GRAY);
	}
	if (isCellSelected(dataRows, columns)) {
	row.setBackground(Color.GREEN);
	}
	return row;
	}
	};
	table.setPreferredScrollableViewportSize(new Dimension(1300,
	500));
	table.setFillsViewportHeight(true);
	jsp = new JScrollPane(table);
	add(jsp);
	
	layoutComponents();
	}
	
	
	private void layoutComponents() {
		
		frame.setLayout(new GridLayout(0,1,1,2));
		navigationPanel.add(navigationButton);
		logoutPanel.add(logoutButton);
		panel1.add(navigationPanel,BorderLayout.WEST);
		panel1.add(logoutPanel,BorderLayout.EAST);
		frame.add(panel1);
		customerDatabasePanel.add(customerDatabaseLabel,BorderLayout.CENTER);
		frame.add(customerDatabasePanel);

		searchLabelPanel.add(searchLabel);
		searchTextFieldPanel.add(searchTextField);
		panel2.add(searchLabelPanel,BorderLayout.WEST);
		panel2.add(searchTextFieldPanel,BorderLayout.EAST);
		frame.add(panel2);
		
		table1.add(jsp);
		frame.add(table1);
		
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		frame.setSize(1350, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		new CustomerDatabase();
	}
}
