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
public class SellOrder extends Order{
    private User u;// we must know the user that is creating the buy order
    
    public SellOrder(String val, User u) throws ParseException {
        super.orderType = "Buy";
        this.u = u;
        if (val.charAt(0) == 'B') {
            super.price = getValue(val);
        }
    }

    //only called upon when we are ammending the buy order
    @Override
    public void setPrice(String price) throws ParseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOrderType() {
        return super.getOrderType();
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }

    //only want to access this within the method hence private
    private BigDecimal getValue(String offerPrice) throws ParseException {
        BigDecimal res = new BigDecimal(offerPrice.substring(2));
        return res;
    }
}
