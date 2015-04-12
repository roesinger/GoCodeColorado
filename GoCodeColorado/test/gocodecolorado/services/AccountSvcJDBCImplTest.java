/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.services;

import org.junit.Test;
import static org.junit.Assert.*;

import gocodecolorado.entities.*;

/**
 *
 * @author rsjodin
 */
public class AccountSvcJDBCImplTest {

    public AccountSvcJDBCImplTest() {
    }

    @Test
    public void testAccountSvc() throws Exception {
        AccountSvcJDBCImpl impl = new AccountSvcJDBCImpl();
        try {
            //impl.testConnection();
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

            account = impl.store(account);
            assertNotNull(account);

            Login login = new Login();
            login.setEmail("qwertyuiop");
            login.setPassword("password");
            account = impl.retrieve(login);
            assertNull(account);
            

            login.setEmail("jdoe@msn.com");
            login.setPassword("passWord");
            account = impl.retrieve(login);
            assertNotNull(account);

            System.out.println("Test PASSED");

        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            throw e;
        }
    }
}