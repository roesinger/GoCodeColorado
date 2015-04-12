/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.services;

import java.sql.*;

/**
 *
 * @author rsjodin
 */
public abstract class JDBCImplAbs {

    private String CONNSTRING = "jdbc:mysql://localhost/gocodecolorado?user=root&password=";

    protected Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection(CONNSTRING);
        return connection;
    }

    protected int getLastInsertId(Connection connection) {
        int id = 0;

        try {
            String sql = "SELECT last_insert_id()";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return id;
    }
}
