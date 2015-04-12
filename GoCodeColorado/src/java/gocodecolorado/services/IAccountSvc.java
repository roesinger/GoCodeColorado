/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.services;

import gocodecolorado.entities.*;

/**
 *
 * @author rsjodin
 */
public interface IAccountSvc {
    
    public Account store(Account account) throws Exception;
    
    public Account retrieve(Login login) throws Exception;
    
}
