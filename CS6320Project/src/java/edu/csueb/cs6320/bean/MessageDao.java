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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gaya
 */
public class MessageDao {
    
    private Connection connection1;
 
    public MessageDao() {
        connection1 = DataBase.getConnection();
    }
    
    public List<Map<String, String>> getMessage() {
        List<Map<String, String>> messages = new ArrayList<>();
        try {
            Statement statement = connection1.createStatement();
            ResultSet rs = statement.executeQuery("select * from message");
            while (rs.next()) {
                Message msg = new Message();
                msg.setId(rs.getInt("ID"));
                msg.setMessage(rs.getString("Message"));
                msg.setUserName(rs.getString("UserName"));
                messages.add(msg.toMap());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return messages;
    }
    
    public void newMessage(String msg, String username) {
        try {
            PreparedStatement preparedStatement = connection1
                    .prepareStatement("insert into message(message,username) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, msg);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public void deleteMessage(int id) {
        try {
            PreparedStatement preparedStatement = connection1
                    .prepareStatement("delete from message where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void updateMessage(int id, String msg) {
        try {
            PreparedStatement preparedStatement = connection1
                    .prepareStatement("update message set message=? " +
                            " where id=?");
            // Parameters start with 1
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, msg);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
