package com.cpa.careerplanassistant.entity.user;

import com.cpa.careerplanassistant.dto.user.UserRequest;
import com.cpa.careerplanassistant.dto.user.UserRequestDto;
import com.cpa.careerplanassistant.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USERS")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String registerId;
    @Builder
    public User(Long id, String name, String registerId) {
        this.id = id;
        this.name = name;
        this.registerId = registerId;
    }

    public void changeInfoByRequest(UserRequest request) {
        name = request.name();
        registerId = request.registerId();
    }
}