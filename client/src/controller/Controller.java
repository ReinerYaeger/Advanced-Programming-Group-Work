package controller;

import model.Customer;

public class Controller {

    public Controller(){

    }

    public void registerCustomer(Customer customer){
        Client client = new Client();
        client.sendCustomer(customer);
    }



}
