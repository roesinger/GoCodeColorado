/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.business;

import gocodecolorado.services.*;
import gocodecolorado.entities.*;

import java.util.*;

/**
 *
 * @author rsjodin
 */
public class AccountMgr {

    private IAccountSvc accountImpl = new AccountSvcJDBCImpl();
    private ICapNeedSvc capneedImpl = new CapNeedSvcJDBCImpl();

    public Account create(Account account) throws Exception {
        return accountImpl.store(account);
    }

    public Account retrieve(Login login) throws Exception {
        Account account = accountImpl.retrieve(login);
        if (login != null) {
            List<CapNeed> capneeds = capneedImpl.retrieveAll(account.getId());
            account.setCapNeeds(capneeds);
        }
        return account;
    }
}
