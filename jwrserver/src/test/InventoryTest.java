package test;

import org.hibernate.Session;

import Log.LoggingService;
import factories.HBFactory;
import model.Inventory;

public class InventoryTest implements LoggingService {

	public static void main(String[] args) {
		Session sesh = new HBFactory().getSession();

		sesh.beginTransaction();

		Inventory inventory = new Inventory("Water Bottle", 20, 50.0f, "Bottle", "Water Bottle");

		sesh.save(inventory);
		sesh.getTransaction().commit();
		sesh.close();
		log.info("Inventory Saved\n" + inventory);

	}

}
