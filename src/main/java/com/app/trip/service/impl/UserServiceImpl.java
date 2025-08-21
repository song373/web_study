package com.app.trip.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.trip.mapper.UserMapper;
import com.app.trip.service.UserService;
import com.app.trip.dto.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserMapper userMapper;
    @Override
    public boolean login(String id, String pw) {
        User user = userMapper.selectUserById(id);
        return user != null && user.getUserPw().equals(pw);
    }
    @Override
    public boolean signup(User user) {
        if (userMapper.selectUserById(user.getUserId()) != null)
        return false;
        userMapper.insertUser(user);
        return true;
    }
    @Override
    public User findById(String id) {
    	return userMapper.selectUserById(id); 
    	}
    @Override
    public User findByEmail(String email) {
    	return userMapper.selectUserByEmail(email); 
    	}
	@Override
	public boolean signup(String id, String pw, String name, String email, String phone) {
		
		return false;
	}
	@Override
	public User findByIdAndEmail(String id, String email) {
		
		return null;
	}
	@Override
	public boolean sendResetPasswordEmail(String id, String email) {
		
		return false;
	}
}
