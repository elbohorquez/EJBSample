/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.arqsoft.ejbsample.counter;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author ulmo
 */
public class Audit implements Serializable {

    @AroundInvoke
    public Object methodChecker(InvocationContext context) throws Exception {
        System.out.println("Audit:methodChecker - About to execute method: " + context.getMethod());
        Object result = context.proceed();
        return result;
    }
}
