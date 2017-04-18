/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.csueb.cs6320.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gaya
 */
public class Message {

    private int id;
    private String message;
    private String username;

    public Message() {

    }

    public Message(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public Message(int id, String message, String username) {
        this.id = id;
        this.message = message;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(getId()));
        map.put("message", getMessage());
        map.put("username", getUserName());
        return map;
    }
}
