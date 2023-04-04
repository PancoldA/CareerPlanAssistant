package com.cpa.careerplanassistant.fixture;

import com.cpa.careerplanassistant.dto.user.UserRequest;
import com.cpa.careerplanassistant.dto.user.UserResponse;
import com.cpa.careerplanassistant.entity.user.User;

import java.time.LocalDateTime;

public class UserFixture {

    public static final User TEST_USER_1 = User.builder()
            .id(1L)
            .name("테스터 1")
            .registerId("테스팅중")
            .build();

    public static final UserRequest TEST_USER_REQUEST = new UserRequest(1L, "테스트 요청", "테스터 아이디");
    public static final UserResponse TEST_USER_RESPONSE = new UserResponse(1L, "테스트 응답", "테스터 아이디", LocalDateTime.now());
}
