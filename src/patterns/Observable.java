/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

/**
 *
 * @author ME
 */
public interface Observable {

    public boolean register(Observer o);

    public boolean unRegister(Observer o);
}
