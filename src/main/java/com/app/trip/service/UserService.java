package com.app.trip.service;
import com.app.trip.dto.User;

public interface UserService {
    boolean login(String id, String pw);
    boolean signup(String id, String pw, String name, String email, String phone);
    User findByEmail(String email);
    boolean sendResetPasswordEmail(String id, String email);
	boolean signup(User user);
	User findById(String id);
	User findByIdAndEmail(String id, String email); 
}
