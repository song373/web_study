package com.app.trip.model;

import java.time.LocalDateTime;

public class AdminLoginAttempt {
    private int failCount;
    private LocalDateTime lockTime;

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
