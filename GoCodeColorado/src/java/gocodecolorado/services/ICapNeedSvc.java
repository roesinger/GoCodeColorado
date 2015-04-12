/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.services;

import gocodecolorado.entities.*;

import java.util.*;

/**
 *
 * @author rsjodin
 */
public interface ICapNeedSvc {
    
    public CapNeed store(CapNeed capneed, int accountId) throws Exception;
    
    public List<CapNeed> retrieveAll(int accountId) throws Exception;
    
}
