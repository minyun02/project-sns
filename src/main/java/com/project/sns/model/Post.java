package com.project.sns.model;

import com.project.sns.model.entity.PostEntity;
import com.project.sns.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class Post {

    private Integer id;

    private String title;

    private String body;

    private User user;

    private Timestamp registeredAt;

    private Timestamp updatedAt;

    private Timestamp deletedAt;

    public static Post fromEntity(PostEntity entity) {
        return new Post(
            entity.getId(),
            entity.getTitle(),
            entity.getBody(),
            User.fromUserEntity(entity.getUser()),
            entity.getRegisteredAt(),
            entity.getUpdatedAt(),
            entity.getDeletedAt()
        );
    }
}
