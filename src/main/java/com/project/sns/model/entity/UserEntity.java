package com.project.sns.model.entity;

import com.project.sns.model.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"user\" SET deleted_at = NOW() WHERE id = ?")
@Where(clause = "deleted_at is NULL")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt() {
        Timestamp.from(Instant.now());
    }

    //userEntity와 model-user 분리하는 이유 : 서비스에서는 dto를 사용한다. jpa를 사용하기 때문에 클래스의 변화에 민감해야한다.
    public static UserEntity of(String userName, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userName);
        userEntity.setPassword(password);
        return userEntity;
    }
}
