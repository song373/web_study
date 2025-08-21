package com.app.trip.dto;

import java.time.LocalDateTime;

public class Admin {
    String adminId;
    String adminPw;
    String name;
    int failCount;
    LocalDateTime lockTime;

    public Admin() {}

    public Admin(String adminId, String adminPw, String name, int failCount, LocalDateTime lockTime) {
        this.adminId = adminId;
        this.adminPw = adminPw;
        this.name = name;
        this.failCount = failCount;
        this.lockTime = lockTime;
    }

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public LocalDateTime getLockTime() {
		return lockTime;
	}

	public void setLockTime(LocalDateTime lockTime) {
		this.lockTime = lockTime;
	}

    
    
}
