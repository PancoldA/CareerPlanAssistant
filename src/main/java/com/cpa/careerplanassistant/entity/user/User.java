package com.cpa.careerplanassistant.entity.user;

import com.cpa.careerplanassistant.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USERS")
@Setter
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String registerId;
    @Builder
    public User(Long id, String name, String registerId) {
        this.id = id;
        this.name = name;
        this.registerId = registerId;
    }
}