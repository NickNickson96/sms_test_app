package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.UserEntity;
import org.dpk.sms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class UserServiceTest {
    private final UserRepository userRepository;

    public List<UserEntity> getAllUserEntities()
    {
        return userRepository.findAll();
    }

    public UserEntity getThisUserEntityById(Long id)
    {
        return userRepository.getOne(id);
    }

    public UserEntity saveThisUserEntity(UserEntity uEntity)
    {
        return userRepository.save(uEntity);
    }

    public void deleteThisUserEntityById(Long id)
    {
        userRepository.deleteById(id);
    }
}
