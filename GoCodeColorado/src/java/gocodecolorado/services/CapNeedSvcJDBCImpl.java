/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.services;

import gocodecolorado.entities.Account;
import gocodecolorado.entities.CapNeed;

import java.sql.*;
import java.util.*;

/**
 *
 * @author rsjodin
 */
public class CapNeedSvcJDBCImpl extends JDBCImplAbs implements ICapNeedSvc {

    public CapNeed store(CapNeed capneed, int accountId) throws Exception {

        Connection connection = getConnection();
        String sql = "INSERT INTO capneed (name, description, type_id, startdate, stopdate, pubstartdate, pubenddate, account_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, capneed.getName());
        pstmt.setString(2, capneed.getDescription());
        pstmt.setInt(3, capneed.getType().ordinal());
//        pstmt.setDate(4, new Date(capneed.getStartDate()));
//        pstmt.setDate(5, new Date(capneed.getStartDate()));
//        pstmt.setDate(6, new Date(capneed.getStartDate()));
//        pstmt.setDate(7, new Date(capneed.getStartDate()));
        pstmt.setInt(8, accountId);
        pstmt.executeUpdate();

        capneed.setId(getLastInsertId(connection));

        connection.close();
        return capneed;
    }

    public List<CapNeed> retrieveAll(int accountId) throws Exception {
        List<CapNeed> capneeds = new ArrayList<CapNeed>();
        Connection connection = getConnection();
        String sql = "SELECT * FROM capneed WHERE account_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, accountId);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            CapNeed capneed = new CapNeed();
            capneed.setId(rs.getInt("capneedid"));
            capneed.setName(rs.getString("name"));
            capneed.setDescription(rs.getString("description"));
            //capneed.setType((rs.getInt("type_id"));
//            capneed.setStartDate(rs.getDate("startdate"));
//            capneed.setStartDate(rs.getDate("stopdate"));
//            capneed.setStartDate(rs.getDate("pubstartdate"));
//            capneed.setStartDate(rs.getDate("pubenddate"));
            capneeds.add(capneed);
        }

        connection.close();
        return capneeds;
    }
}
