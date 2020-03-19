package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.RoleEntity;
import org.dpk.sms.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public List<RoleEntity> getAllRoleEntities() {
        return roleRepository.findAll();
    }

    public RoleEntity getThisRoleEntityById(Long id)
    {
        return roleRepository.getOne(id);
    }

    public RoleEntity saveThisRoleEntity(RoleEntity rEntity)
    {
        return roleRepository.save(rEntity);
    }

    public void deleteThisRoleEntityById(Long id)
    {
        roleRepository.deleteById(id);
    }
}
