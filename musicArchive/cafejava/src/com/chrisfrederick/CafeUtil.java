package com.chrisfrederick;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CafeUtil {

    public int getStreakGoal(){
        int[] percs = {1,2,3,4,5,6,7,8,9,10};
        int total = 0;
        for (int perc : percs) {
            total += perc;
        }
        return total;
    }

    public double getOrderTotal(double[] prices){
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        ListIterator<String> i = menuItems.listIterator();
        while(i.hasNext()){
            System.out.println(i.nextIndex() +" "+ i.next());
        }

    }

    public void addCustomer(ArrayList<String> customers){
        Console cns1 = System.console();
        String userName = cns1.readLine("Enter Name: ");
        System.out.printf("Hello %s", userName);
        System.out.println("There are " + customers.size() + " ahead of you.");
        customers.add(userName);
        System.out.println(customers);

    }





}
