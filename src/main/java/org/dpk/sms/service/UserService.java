package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.dto.UserDto;
import org.dpk.sms.entity.RoleEntity;
import org.dpk.sms.entity.UserEntity;
import org.dpk.sms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class UserService {


    public static final int ACT_U_S_ID = 1;
    private final UserRepository userRepository;
    private final RoleService roleService;

    public List<UserEntity> getAllUserEntities()
    {
        return userRepository.findAll();
    }

    public UserEntity getThisUserEntityById(Long id)
    {
        return userRepository.getOne(id);
    }

    public UserEntity saveThisUserEntity(UserDto user)
    {

        return userRepository.save(dtoToEntity(user));
    }

    private UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
      //entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setOccupation(dto.getOccupation());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        RoleEntity role = roleService.getThisRoleEntityById(dto.getRoleId());
        entity.setRole(role);

        return entity;
    }

    public void deleteThisUserEntityById(Long id)
    {
        userRepository.deleteById(id);
    }
}
