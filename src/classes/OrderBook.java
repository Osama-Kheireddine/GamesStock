/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.Objects;
import patterns.Observable;
import patterns.Observer;

/**
 *
 * @author ME
 */
public class OrderBook implements Observable {

    //contains all the buy/sell details of a particular game
    ArrayList<Observer> observers;

    public OrderBook() {
        observers = new ArrayList();
    }
    
    //sort the order book

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.observers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderBook other = (OrderBook) obj;
        if (!Objects.equals(this.observers, other.observers)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderBook{" + "observers=" + observers + '}';
    }

    @Override
    public synchronized boolean register(Observer o) {
        // If the observer to be added to the list exists 
        // and isn't already present in the list
        if (o != null && !observers.contains(o)) {
            // Add the new observer
            observers.add(o);
            System.out.println("Adding observer " + o.toString());
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean unRegister(Observer o) {
        if (o != null && observers.remove(o)) {
            System.out.println("Removed observer " + o.toString());
            return true;
        }
        return false;
    }

    private synchronized void notifyObservers() {
        //in here we will only notify if the largest bid to offer has been replaced

        // For each observer in the list, call their update method to notify them 
        // that something has changed
        observers.stream().forEach((o)
                -> {
            o.update(this);
        });
    }
}
