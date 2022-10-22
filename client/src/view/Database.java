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
	private JFrame frame;
	private JTabbedPane tab;
	private JPanel dashboard;
	private JPanel management;
	private JPanel inventory;
	private JPanel accounting;
	private JLabel navigationLabel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JComboBox<String> combobox;
	private JButton button;
	private JLabel headerLabel;
	Database(){
		frame= new JFrame();
		dashboard=new JPanel();
		management=new JPanel();
		inventory=new JPanel();
		accounting=new JPanel();
		tab=new JTabbedPane();
		tab.setBounds(100, 100, 700,400);
		//navigationPanel =new JPanel();
		navigationLabel=new JLabel("Navigation:");

		button=new JButton("Logout");
		String navigation[]= {" ","Dashboard","Customer Database","Staff Database","Stock and Inventory","Check Out","Sales Reports","Register Customer"};
		 combobox=new JComboBox<>(navigation);
		combobox.setBounds(100, 50, 150, 20);
		headerLabel=new JLabel("Staff Database");
		panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 panel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 panel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		 panel4=new JPanel(new BorderLayout(0,0));
		 panel5=new JPanel(new BorderLayout(1,0));
		layout();
	}
	public void layout() {
		frame.setLayout(new GridLayout(0,1,1,2));
	
		panel1.add(navigationLabel);
		panel1.add(combobox);
		
		panel2.add(button);
		panel4.add(panel1,BorderLayout.WEST);
		panel4.add(panel2,BorderLayout.EAST);
		frame.add(panel4);
		panel3.add(headerLabel,BorderLayout.CENTER);
		frame.add(panel3);
		
		//frame.add(navigationPanel);
		tab.add("Dashboard",dashboard);
		tab.add("Management",management);
		tab.add("Inventory",inventory);
		tab.add("Accounting and Sales",accounting);
		panel5.add(tab);
		panel5.setSize(400,200);
		frame.add(panel5,BorderLayout.CENTER);
		frame.setSize(700,400);
		frame.setVisible(true);
		//frame.isResizable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		new Database();
	}
}
