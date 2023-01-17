package com.project.sns.fixture;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.project.sns.model.entity.UserEntity;

public class UserEntityFixture {

    public static UserEntity get(String userName, String password) {
        UserEntity result = new UserEntity();
        result.setId(1);
        result.setUserName(userName);
        result.setPassword(password);

        return result;
    }
}
