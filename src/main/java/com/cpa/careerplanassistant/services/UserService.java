package com.cpa.careerplanassistant.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.cpa.careerplanassistant.dto.user.UserRequest;
import com.cpa.careerplanassistant.dto.user.UserResponse;
import com.cpa.careerplanassistant.entity.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpa.careerplanassistant.dto.user.UserResponseDto;
import com.cpa.careerplanassistant.dto.user.UserRequestDto;
import com.cpa.careerplanassistant.entity.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserRequestDto UserSaveDto) {
        return userRepository.save(UserSaveDto.toEntity()).getId();
    }

    @Transactional
    public UserResponse createUser(UserRequest request) {
        User user = User.builder().name(request.name()).
                registerId(request.registerId())
                .build();

        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getName(), savedUser.getRegisterId(), savedUser.getRegisterTime());
    }

    public List < UserResponseDto > findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::new).collect(Collectors.toList());
    }

    public UserResponseDto findById(Long id) {
        return new UserResponseDto(userRepository.findById(id).get());
    }

    @Transactional
    public int updateUser(UserRequestDto userRequestDto) {
        return userRepository.updateUser(userRequestDto);
    }

    @Transactional
    public UserResponse updateUserWithPersist(UserRequest request) {
        User user = findUserById(request.id());
        user.changeInfoByRequest(request);
        return new UserResponse(user.getId(), user.getName(), user.getRegisterId(), user.getRegisterTime());
    }

    @Transactional
    public void deleteById(final Long id) {
        User user = findUserById(id);
        userRepository.deleteById(user.getId());
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("유저가 존재하지 않습니다."));
    }
}
