/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author ME
 */
public class Game {

    private String name;
    //keep a list of all buy orders and all sell orders
    ArrayList<BuyOrder> buyList = new ArrayList();
    ArrayList<SellOrder> sellList = new ArrayList();

    public Game(String name) {
        this.name = name;
    }

    //add buy order
    public void addBuy(BuyOrder b, String price) throws ParseException {
        //check the buyList and make sure it isnt there
        if (!buyList.contains(b)) {
            //add the new buy
            buyList.add(b);
        }
        //else ammend the buy as it exists
        if (buyList.contains(b)) {
            //lookup b then ammend it
            for(int i = 0; i < buyList.size(); i++){
                if(buyList.get(i).equals(b)){
                    buyList.get(i).setPrice(price);
                }
            }
        }
    }
    //add sell order
    public void addSell(SellOrder s, String price) throws ParseException {
        //check the buyList and make sure it isnt there
        if (!sellList.contains(s)) {
            //add the new buy
            sellList.add(s);
        }
        //else ammend the buy as it exists
        if (sellList.contains(s)) {
            //lookup b then ammend it
            for(int i = 0; i < sellList.size(); i++){
                if(sellList.get(i).equals(s)){
                    sellList.get(i).setPrice(price);
                }
            }
        }
    }
    
    //create a merge sort method to sort the array
}
