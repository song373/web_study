package com.app.trip.mapper;

import com.app.trip.dto.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin selectAdminById(String id);
    int updateAdmin(Admin admin);
    int insertAdmin(Admin admin);
}
