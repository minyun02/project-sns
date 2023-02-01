package com.project.sns.fixture;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.project.sns.model.entity.UserEntity;

public class UserEntityFixture {

    public static UserEntity get(String userName, String password, Integer userId) {
        UserEntity result = new UserEntity();
        result.setId(userId);
        result.setUserName(userName);
        result.setPassword(password);

        return result;
    }
}
