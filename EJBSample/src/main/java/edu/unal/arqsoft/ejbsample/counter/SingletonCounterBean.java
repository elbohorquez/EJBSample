/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbsample.counter;

import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            JPACounterEntity counter = em.find(JPACounterEntity.class, CounterDBKey);
            if (counter == null) {
                counter = new JPACounterEntity();
                counter.setPrimaryKey(CounterDBKey);
                em.persist(counter);
            }
            counter.setValue(counter.getValue() + 1);
            em.flush();
            em.clear();
            result = counter.getValue();
        } catch (Throwable t) {
            Logger.getLogger(SingletonCounterBean.class.getName()).log(Level.SEVERE, null, t);
        }
        return result;
    }

    @Override
    public int getTheValue() {
        int result = 0;
        try {
            JPACounterEntity counter = em.find(JPACounterEntity.class, CounterDBKey);
            if (counter == null) {
                counter = new JPACounterEntity();
                em.persist(counter);
                em.flush();
            }
            em.clear();
            result = counter.getValue();
        } catch (Throwable t) {
            Logger.getLogger(SingletonCounterBean.class.getName()).log(Level.SEVERE, null, t);
        }
        return result;
    }
}
