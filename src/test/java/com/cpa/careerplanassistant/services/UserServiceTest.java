package com.cpa.careerplanassistant.services;

import com.cpa.careerplanassistant.dto.user.UserResponse;
import com.cpa.careerplanassistant.entity.user.User;
import com.cpa.careerplanassistant.entity.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.cpa.careerplanassistant.fixture.UserFixture.TEST_USER_1;
import static com.cpa.careerplanassistant.fixture.UserFixture.TEST_USER_REQUEST;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void createUser() {
        //given
        given(userRepository.save(any(User.class))).willReturn(TEST_USER_1);
        //when
        UserResponse user = userService.createUser(TEST_USER_REQUEST);
        //then
        then(userRepository).should(times(1)).save(any(User.class));
    }

}