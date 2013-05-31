/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbsample.counter;

/**
 *
 * @author ulmo
 */
interface SingletonCounterBeanRemote {
    public int increment();

    public int getTheValue();
}
