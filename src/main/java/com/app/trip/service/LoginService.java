package com.app.trip.service;

import com.app.trip.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    // 실제로는 DB와 연동해서 체크해야 함
    public boolean authenticateUser(User user) {
        return "testuser".equals(user.getId()) && "Test123!".equals(user.getPassword());
    }
}
