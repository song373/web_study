package com.app.trip.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.app.trip.dto.User;

@Mapper
public interface UserMapper {
    User selectUserById(String id);
    User selectUserByEmail(String email);
    void insertUser(User user);
}
