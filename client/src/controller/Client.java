package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.*;

public class Client {
    private ObjectInputStream objIn;
    private static ObjectOutputStream objOs;
    private Socket connectionSocket;


    public Client() {
        createConnection();
        configureConnection();
    }

    public void createConnection(){
        try {
            connectionSocket = new Socket("localhost", 8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void configureConnection(){
        try {
            objIn = new ObjectInputStream(connectionSocket.getInputStream());
            objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //close connection
    public void closeConnection(){
        try {
            objIn.close();
            objOs.close();
            connectionSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //send Customer object to server
    public void sendCustomer(Customer customer){
        try {
            objOs.writeObject(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //send Staff object to server
    public void sendStaff(Staff staff){
        try {
            objOs.writeObject(staff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //send Department object to server
    public void sendDepartment(Department department){
        try {
            objOs.writeObject(department);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //send Invoice object to server
    public void sendInvoice(Invoice invoice){
        try {
            objOs.writeObject(invoice);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void receiveResponse(){
        try {
            System.out.println(objIn.readObject());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void sendLoginResponse(String username, String password){
        try {
            objOs.writeObject(username);
            objOs.writeObject(password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }





    public static void main(String[] args) {
        new Client();
    }


}
