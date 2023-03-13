package com.cpa.careerplanassistant;

import java.util.List;

import com.cpa.careerplanassistant.dto.user.UserRequestDto;
import com.cpa.careerplanassistant.dto.user.UserResponseDto;
import com.cpa.careerplanassistant.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CareerPlanAssistantApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void save() {
        UserRequestDto userSaveDto = new UserRequestDto();

        userSaveDto.setName("testName");
        userSaveDto.setRegisterId("testRegisterId");

        Long result = userService.save(userSaveDto);

        if (result > 0) {
            System.out.println("# Success save() ~");
            findAll();
            findById(result);
        } else {
            System.out.println("# Fail Save() ~");
        }
    }

    void findAll() {
        List < UserResponseDto > list = userService.findAll();

        if (list != null) {
            System.out.println("# Success findAll() : " + list.toString());
        } else {
            System.out.println("# Fail findAll() ~");
        }
    }

    void findById(Long id) {
        UserResponseDto info = userService.findById(id);

        if (info != null) {
            System.out.println("# Success findById() : " + info.toString());
            updateUser(id);
        } else {
            System.out.println("# Fail findById() ~");
        }
    }

    void updateUser(Long id) {

        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setId(id);
        userRequestDto.setName("updateName");
        userRequestDto.setRegisterId("updateRegisterId");

        int result = userService.updateUser(userRequestDto);

        if (result > 0) {
            System.out.println("# Success updateUser() ~");
        } else {
            System.out.println("# Fail updateUser() ~");
        }
    }

}
