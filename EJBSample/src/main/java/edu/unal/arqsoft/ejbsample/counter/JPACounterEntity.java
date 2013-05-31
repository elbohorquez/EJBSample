/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbsample.counter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ulmo
 */
@Entity
public class JPACounterEntity implements Serializable {

    @Id
    private String primaryKey;
    private int value = 0;

    public String getPrimaryKey() {
        System.out.println("JPACounterEntity:getPrimaryKey = '" + primaryKey
                + "'");
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        System.out.println("JPACounterEntity:setPrimaryKey = '" + primaryKey
                + "'");
        this.primaryKey = primaryKey;
    }

    public int getValue() {
        System.out.println("JPACounterEntity:getValue = " + value);
        return value;
    }

    public void setValue(int value) {
        System.out.println("JPACounterEntity:setValue = " + value);
        this.value = value;
    }
}
