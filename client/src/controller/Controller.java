package controller;

import model.*;
import view.DashBoard;

public class Controller {

    public Controller(){

    }

    public void registerCustomer(Customer customer){
        Client client = new Client();
        client.sendCustomer(customer);
    }

    public void loginStaff(String username, String password){

        // TODO Check if staff is in database and if password is correct
        Staff staff = new Staff();
        Client client = new Client();
        client.sendStaff(staff);

    }

    public Object navigationController(String viewName){

        if(viewName.equals("Dashboard")){
            return new DashBoard();
        } else if(viewName.equals("Customer Database")){
            // TODO
        } else if(viewName.equals("Staff Database")){
            // TODO
        } else if(viewName.equals("Stock and Inventory")){
            // TODO
        } else if(viewName.equals("Check Out")){
            // TODO
        } else if(viewName.equals("Sales Reports")){
            // TODO
        } else if(viewName.equals("Register Customer")){
            // TODO
        }
        return null;

    }




}
