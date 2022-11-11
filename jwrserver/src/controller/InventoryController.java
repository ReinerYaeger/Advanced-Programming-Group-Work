package controller;

import java.util.List;

import org.hibernate.Session;

import factories.HBFactory;
import model.Inventory;

public class InventoryController {

	private Session session;

	public InventoryController() {
		session = HBFactory.getSession();
	}

	public List<Inventory> getAllInventory() {

		session.beginTransaction();

		List<Inventory> allItems = session.createQuery("from Inventory", Inventory.class).getResultList();

		session.close();

		return allItems;
	}

}
