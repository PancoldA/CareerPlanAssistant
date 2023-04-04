package com.cpa.careerplanassistant.dto.user;

import java.time.LocalDateTime;

public record UserResponse (
        Long id,
        String name,
        String registerId,
        LocalDateTime registerTime) {
}