/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.business;

import gocodecolorado.entities.Account;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rsjodin
 */
public class AccountMgrTest {

    public AccountMgrTest() {
    }

    @Test
    public void testCreate() throws Exception {

        AccountMgr mgr = new AccountMgr();
        Account account = new Account();
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setOrganization("Acme");
        account.setPhone("303-321-4567");
        account.setEmail("jdoe@msn.com");
        account.setPassword("passWord");
        account.setQuestion("my question");
        account.setAnswer("my answer");
        account.setStreet("123 Java Lane");
        account.setCity("Denver");
        account.setState("Colorado");
        account.setZip("80122");
        account = mgr.create(account);
        assertNotNull(account);
        System.out.println("return id: " + account.getId());
    }
}