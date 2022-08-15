package com.lgs.comm;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HttpMessage {

    private Map<String, Object> message;

    public HttpMessage(){
        message = new HashMap<String, Object>();
        message.put("HttpStatus", "200");
    }

    public HttpMessage(String HttpStatus){
        message = new HashMap<String, Object>();
        message.put("HttpStatus", HttpStatus);
    }

    public void setStatus(String state){
        message.put("HttpStatus", state);
    }

    public void put(String name, Object obj){
        message.put(name, obj);
    }
}