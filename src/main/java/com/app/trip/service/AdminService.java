package com.app.trip.service;

import com.app.trip.dto.Admin;

public interface AdminService {
    boolean login(String id, String pw);       
    boolean isLocked(String id);                  
    boolean signup(String id, String pw, String name); 
    Admin findById(String id);                    
    void increaseFailCount(String id);         
    void resetFailCount(String id);              
}
