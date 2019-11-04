/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interra.demo.InterraDemoApp.util;


/**
 *
 * @author mac
 */
public class MessageResponses {

    public static int CODE_OK = 0;
    public static int CODE_ERROR = -1;
    public static String MESSAGE_NOT_FOUND = "Requested resources not found"; 
     public static String MESSAGE_ERROR = "Error occured, please contact admin";
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public MessageResponses(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static MessageResponses response(int code, String message) {
        return new MessageResponses(code, message);
    }
    
    
}
