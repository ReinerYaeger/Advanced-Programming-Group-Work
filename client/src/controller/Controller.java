package controller;

import model.*;

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



}
