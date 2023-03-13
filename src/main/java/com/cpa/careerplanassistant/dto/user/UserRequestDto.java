package com.cpa.careerplanassistant.dto.user;

import com.cpa.careerplanassistant.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    private Long id;
    private String name;
    private String registerId;
    public User toEntity() {
        return User.builder()
                .name(name)
                .registerId(registerId)
                .build();
    }
}