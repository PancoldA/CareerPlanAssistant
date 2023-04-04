package com.cpa.careerplanassistant.entity.user;

import com.cpa.careerplanassistant.dto.user.UserRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository < User, Long > {

    String UPDATE_USER = "UPDATE users " +
            "SET NAME = :#{#userRequestDto.name}, " +
            "UPDATE_TIME = NOW() " +
            "WHERE ID = :#{#userRequestDto.id}";

    @Transactional
    @Modifying
    @Query(value = UPDATE_USER, nativeQuery = true)
    int updateUser(@Param("userRequestDto") UserRequestDto userRequestDto);
}