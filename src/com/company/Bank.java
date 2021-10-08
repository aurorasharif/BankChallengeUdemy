package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            Branch newBranch = new Branch(branchName);
            branches.add(newBranch);
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            ArrayList<Customer> customers = branch.getCustomers();
            if (customers.size() > 0) {
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getName().equals(customerName)) {
                        System.out.println("Customer already exists");
                        return false;
                    }
                }
            }
            return branch.newCustomer(customerName, transaction);
        }
        return false;

    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        } else return false;
    }

    private Branch findBranch(String branchName) {
        Branch branch = null;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                System.out.println("Branch found");
                branch = branches.get(i);
            }
        }
        return branch;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        ArrayList<Customer> customers;
        if (branch != null) {
            customers = branch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                System.out.println((i + 1) + " Customer name: " + customers.get(i).getName());
                if (printTransactions) {
                    ArrayList<Double> transactions = customers.get(i).getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("   Transaction# " + (j + 1) +": "+ transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            System.out.println("Branch does not exist");
            return false;
        }
    }
}
