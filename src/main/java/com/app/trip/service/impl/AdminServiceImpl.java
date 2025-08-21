package com.app.trip.service.impl;

import com.app.trip.dto.Admin;
import com.app.trip.mapper.AdminMapper;
import com.app.trip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    // 1. 로그인 (5회 실패/24시간 잠금)
    @Override
    public boolean login(String id, String pw) {
        Admin admin = adminMapper.selectAdminById(id);
        if (admin == null) return false;

        // 24시간 잠금 확인
        if (isLocked(id)) return false;

        if (admin.getAdminPw().equals(pw)) {
            resetFailCount(id); 
            return true;
        } else {
            increaseFailCount(id); 
            return false;
        }
    }

    @Override
    public boolean isLocked(String id) {
        Admin admin = adminMapper.selectAdminById(id);
        if (admin == null) return false;
        if (admin.getFailCount() >= 5) {
       
            if (admin.getLockTime() == null) return false;
            LocalDateTime lockTime = admin.getLockTime();
            if (lockTime.plusHours(24).isAfter(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void increaseFailCount(String id) {
        Admin admin = adminMapper.selectAdminById(id);
        if (admin != null) {
            int newCount = admin.getFailCount() + 1;
            admin.setFailCount(newCount);
            if (newCount == 5) {
                admin.setLockTime(LocalDateTime.now());
            }
            adminMapper.updateAdmin(admin);
        }
    }

    @Override
    public void resetFailCount(String id) {
        Admin admin = adminMapper.selectAdminById(id);
        if (admin != null) {
            admin.setFailCount(0);
            admin.setLockTime(null);
            adminMapper.updateAdmin(admin);
        }
    }

    @Override
    public boolean signup(String id, String pw, String name) {
        Admin exists = adminMapper.selectAdminById(id);
        if (exists != null) return false;
        Admin admin = new Admin(id, pw, name, 0, null); 
        adminMapper.insertAdmin(admin);
        return true;
    }

    @Override
    public Admin findById(String id) {
        return adminMapper.selectAdminById(id);
    }
}
