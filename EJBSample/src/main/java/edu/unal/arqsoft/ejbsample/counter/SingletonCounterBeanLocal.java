/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbsample.counter;

import javax.ejb.Local;

/**
 *
 * @author ulmo
 */
@Local
public interface SingletonCounterBeanLocal {

    public int increment();

    public int getTheValue();
}
