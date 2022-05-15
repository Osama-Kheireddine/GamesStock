/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author ME
 */
public class User {
    private String userID;

    public User() {
        userID = UUID.randomUUID().toString();
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.userID);
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
        final User other = (User) obj;
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + '}';
    }
    
    
}
