/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 *
 * @author ME
 */
public abstract class Order {
    BigDecimal price;
    String orderType;
    
    //get the order's price
    public BigDecimal getPrice() {
        return price;
    }
    
    //set the order's price
    public abstract void setPrice(String price) throws ParseException;
    
    //get the order's type, we cannot change a bid to a sale so no set order type
    public String getOrderType() {
        return orderType;
    }
}
