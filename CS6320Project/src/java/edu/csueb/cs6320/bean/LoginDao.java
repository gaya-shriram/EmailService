/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csueb.cs6320.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gaya
 */
public class LoginDao {

    private Connection connection2;

    public static boolean validate(String username, String password) throws SQLException {
        boolean status = false;
        Connection connection2 = DataBase.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            pst = connection2.prepareStatement("select * from login where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            if (connection2 != null) {
                try {
                    connection2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
}
