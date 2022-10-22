import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Stock{

	private JFrame frame;
	private JButton button;
	private JLabel navigationLabel;
	private JComboBox<String> combobox;
	private JLabel headerLabel;
	private JTable table;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel borderPanel;
	private String headings[]= {"Product Code","Name","Short Description","Long Description","Items in Stock","Unit Price"};
	private int row=15;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton insertButton;
	 
	public Stock(){
		frame=new JFrame();
		 
		 navigationLabel=new JLabel("Navigation:");
		 button=new JButton("Logout");
		 String navigation[]= {" ","Dashboard","Customer Database","Staff Database","Stock and Inventory","Check Out","Sales Reports","Register Customer"};
		 combobox=new JComboBox<>(navigation);
		 headerLabel=new JLabel("Stock and Inventory");
		 DefaultTableModel model = new DefaultTableModel(row, headings.length) ;
		 model.setColumnIdentifiers(headings);
		 table=new JTable(model);
		Border border= BorderFactory.createLineBorder(Color.black);
		 updateButton=new JButton("Update");
		 deleteButton=new JButton("Delete");
		 insertButton=new JButton("Insert");
		 panel1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 panel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		 panel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		 panel4=new JPanel(new BorderLayout(0,0));
		 panel5=new JPanel(new BorderLayout(0,0));
		 panel5.setSize(300,400);
		 panel6=new JPanel(new FlowLayout());
		 borderPanel=new JPanel();
		 borderPanel.setBorder(border);
		
		layout();
	}
	
	public void layout() {
		frame.setLayout(new GridLayout(0,1,1,2));
		panel1.add(navigationLabel);
		panel1.add(combobox);
		//frame.add(panel1);
		panel2.add(button);
		//frame.add(panel2);
		panel4.add(panel1,BorderLayout.WEST);
		panel4.add(panel2,BorderLayout.EAST);
		frame.add(panel4);
		panel3.add(headerLabel);
		
		frame.add(panel3);
		panel5.add(table.getTableHeader(),BorderLayout.NORTH);
		panel5.add(table);
		frame.add(panel5);
		panel6.add(updateButton);
		panel6.add(deleteButton);
		panel6.add(insertButton);
		frame.add(panel6);
		
		borderPanel.add(panel5);
		borderPanel.add(panel6);
		
		//borderPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		frame.getContentPane().add(borderPanel,BorderLayout.CENTER);
		frame.setSize(new Dimension(400,600));
		frame.setVisible(true);
		frame.setResizable(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Stock();
	}
	
	

	
}
