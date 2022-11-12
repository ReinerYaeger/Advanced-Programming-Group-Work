package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Inventory;

public class StockCRUD {

	private JFrame frame;
	private JPanel panel;
	private JLabel productName, shortDesc, longDesc, unitPrice, inStock;
	private JTextField productNameText, shortDescText, longDescText, unitPriceText, inStockText;
	private JButton submitBtn;

	private boolean edit = false;
	private Inventory item = null;

	public StockCRUD() {
		frame = new JFrame();
		panel = new JPanel(new GridLayout(6, 5));

		productName = new JLabel("Name");
		shortDesc = new JLabel("Short Description");
		longDesc = new JLabel("Long Description");
		unitPrice = new JLabel("Unit Price");
		inStock = new JLabel("Amount In Stock");

		productNameText = new JTextField();
		shortDescText = new JTextField();
		longDescText = new JTextField();
		unitPriceText = new JTextField();
		inStockText = new JTextField();

		submitBtn = new JButton("Submit");
		layout("Adding an Item");
		setActionListener();
	}

	public StockCRUD(Inventory item) {
		this();
		this.item = item;
		edit = true;
		layout("Editing an Item");

		productNameText.setText(item.getName());
		shortDescText.setText(item.getShortDescription());
		longDescText.setText(item.getLongDescription());
		unitPriceText.setText(String.valueOf(item.getUnitPrice()));
		inStockText.setText(String.valueOf(item.getItemsInStock()));

	}

	private void layout(String title) {
		frame.setLayout(new BorderLayout(1, 1));

		panel.add(productName);
		panel.add(productNameText);

		panel.add(shortDesc);
		panel.add(shortDescText);

		panel.add(longDesc);
		panel.add(longDescText);

		panel.add(unitPrice);
		panel.add(unitPriceText);

		panel.add(inStock);
		panel.add(inStockText);

		panel.add(submitBtn, BorderLayout.CENTER);

		frame.add(panel, BorderLayout.CENTER);
		frame.setTitle(title);
		frame.setVisible(true);
		frame.setSize(320, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void setActionListener() {
		submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (edit) {
					item.setName(productNameText.getText());
					item.setItemsInStock(Integer.parseInt(inStockText.getText()));
					item.setUnitPrice(Float.parseFloat(unitPriceText.getText()));
					item.setShortDescription(shortDescText.getText());
					item.setLongDescription(longDescText.getText());
					if (new Controller().updateInventory(item)) {
						frame.dispose();
						new Stock();
					}
				} else {
					System.out.println("Adding");
					item = new Inventory(productNameText.getText(), Integer.parseInt(inStockText.getText()),
							Float.parseFloat(unitPriceText.getText()), shortDescText.getText(), longDescText.getText());
					if (new Controller().addInventory(item)) {
						frame.dispose();
						new Stock();
					}
				}

			}
		});
	}

	public static void main(String[] args) {
		new StockCRUD();
	}

}
