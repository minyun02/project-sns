package com.project.sns.service;

import com.project.sns.exception.SnsApplicationException;
import com.project.sns.model.User;
import com.project.sns.model.entity.UserEntity;
import com.project.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;

    public User join(String userName, String password) {
        //회원가입하려는 userName으로 중복 회원가입 여부 판단
        Optional<UserEntity> userEntity = userEntityRepository.findByUserName(userName);

        //회원가임 진행 = user 등록
        userEntityRepository.save(new UserEntity());

        return new User();
    }

    public String login(String userName, String password) {
        //회원가입 여부 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());

        //비밀번호 체크
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException();
        }

        //토큰 생성


        return "";
    }
}
