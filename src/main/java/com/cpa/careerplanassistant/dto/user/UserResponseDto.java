package com.cpa.careerplanassistant.dto.user;

import com.cpa.careerplanassistant.entity.user.User;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String registerId;
    private LocalDateTime registerTime;
    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.registerId = entity.getRegisterId();
        this.registerTime = entity.getRegisterTime();
    }

    @Override
    public String toString() {
        return "BoardListDto [id=" + id + ", name=" + name + ", registerId=" + registerId + ", registerTime=" + registerTime + "]";
    }
}