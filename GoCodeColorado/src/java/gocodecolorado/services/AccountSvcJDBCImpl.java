/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.services;

import gocodecolorado.entities.Account;
import gocodecolorado.entities.Login;

import java.sql.*;

/**
 *
 * @author rsjodin
 */
public class AccountSvcJDBCImpl extends JDBCImplAbs implements IAccountSvc {

//    public void testConnection() throws Exception {
//        Connection connection = getConnection();
//        connection.close();
//    }
    
    public Account store(Account account) throws Exception {
        
        // TODO: first check to see if an account exists with this email
        
        Connection connection = getConnection();
        String sql = "INSERT INTO account ("
                + "firstname, lastname, organization, email, password, question, answer, phone, street, city, state, zip) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, account.getFirstName());
        pstmt.setString(2, account.getLastName());
        pstmt.setString(3, account.getOrganization());
        pstmt.setString(4, account.getEmail());
        pstmt.setString(5, account.getPassword());
        pstmt.setString(6, account.getQuestion());
        pstmt.setString(7, account.getAnswer());
        pstmt.setString(8, account.getPhone());
        pstmt.setString(9, account.getStreet());
        pstmt.setString(10, account.getCity());
        pstmt.setString(11, account.getState());
        pstmt.setString(12, account.getZip());
        pstmt.executeUpdate();

//        sql = "SELECT last_insert_id()";
//        pstmt = connection.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        if (rs.next()) {
//            int id = rs.getInt(1);
//            account.setId(id);
//        }
        
        account.setId(getLastInsertId(connection));
        
        // TODO: get the capneeds associated with this account
        
        connection.close();
        return account;
    }

    public Account retrieve(Login login) throws Exception {
        Account account = null;
        Connection connection = getConnection();
        String sql = "SELECT * FROM account WHERE email = ? AND password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, login.getEmail());
        pstmt.setString(2, login.getPassword());

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            account = getAccount(rs);
        }
        
        connection.close();
        return account;
    }

    private Account getAccount(ResultSet rs) throws Exception {
        Account account = new Account();
        account.setId(rs.getInt("accountid"));
        account.setFirstName(rs.getString("firstname"));
        account.setLastName(rs.getString("lastname"));
        account.setOrganization(rs.getString("organization"));
        account.setEmail(rs.getString("email"));
        account.setPassword(rs.getString("password"));
        account.setQuestion(rs.getString("question"));
        account.setAnswer(rs.getString("answer"));
        account.setPhone(rs.getString("phone"));
        account.setStreet(rs.getString("street"));
        account.setCity(rs.getString("city"));
        account.setState(rs.getString("state"));
        account.setZip(rs.getString("zip"));
        return account;
    }
}
