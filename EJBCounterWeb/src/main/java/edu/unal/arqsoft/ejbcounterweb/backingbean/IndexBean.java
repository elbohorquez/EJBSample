/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbcounterweb.backingbean;

import edu.unal.arqsoft.ejbsample.counter.SingletonCounterBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ulmo
 */
@ManagedBean
@RequestScoped
public class IndexBean {

    @EJB
    private SingletonCounterBeanLocal singletonCounter;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public IndexBean() {
    }

    public void counter() {
        String msg = null;
        count = 0;

        try {
            count = singletonCounter.increment();
        } catch (RuntimeException e) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, e);
            msg = "Error - increment() method on EJB failed!";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
        }
        msg = "EJB Count value for Singleton Bean with JPA: " + count;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }
}
