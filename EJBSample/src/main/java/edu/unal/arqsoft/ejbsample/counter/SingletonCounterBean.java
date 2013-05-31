/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbsample.counter;

import javax.ejb.Singleton;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ulmo
 */
@Singleton
@Interceptors(Audit.class)
public class SingletonCounterBean implements SingletonCounterBeanLocal, SingletonCounterBeanRemote {

    private static final String CounterDBKey = "PRIMARYKEY";
    @PersistenceContext(unitName = "Counter")
    private EntityManager em;

    @Override
    public int increment() {
        int result = 0;
        return result;
    }

    @Override
    public int getTheValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
