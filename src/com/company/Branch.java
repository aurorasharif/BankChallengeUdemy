package com.company;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers=new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double transaction){
        Customer exists=findCustomer(name);
        if (exists==null){
            Customer newCustomer=new Customer(name, transaction);
            customers.add(newCustomer);
            System.out.println("New customer added to the branch");
            return true;
        }
        else {
            System.out.println("customer already exists");
            return false;
        }

    }

    public boolean addCustomerTransaction(String name, double transaction){
        Customer exists=findCustomer(name);
        if (exists!=null){
            exists.addTransaction(transaction);
            System.out.println("Customer transaction recorded");
            return true;
        }
        else {
            System.out.println("No customer found to add the transaction");
            return false;
        }

    }
    private Customer findCustomer(String name){
        Customer customer=null;
        for (int i=0; i<customers.size(); i++){
            if (customers.get(i).getName().equals(name)){
                customer=customers.get(i);
            }
        } return customer;
    }
}
