package com.cpa.careerplanassistant.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.careerplanassistant.dto.user.UserResponseDto;
import com.cpa.careerplanassistant.dto.user.UserRequestDto;
import com.cpa.careerplanassistant.entity.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserRequestDto UserSaveDto) {
        return userRepository.save(UserSaveDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List < UserResponseDto > findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    public UserResponseDto findById(Long id) {
        return new UserResponseDto(userRepository.findById(id).get());
    }

    public int updateUser(UserRequestDto userRequestDto) {
        return userRepository.updateUser(userRequestDto);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
