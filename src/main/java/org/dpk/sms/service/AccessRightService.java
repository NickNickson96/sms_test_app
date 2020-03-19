package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.dpk.sms.repository.AccessRightRepository;
import org.dpk.sms.entity.AccessRightEntity;

import java.util.List;

@RequiredArgsConstructor
@Service



public class AccessRightService {
    private final AccessRightRepository accessRightRepository;

   /* public static void staticExample() {

    }*/

    public List<AccessRightEntity> getAllAccessRightEntities()
    {
        return accessRightRepository.findAll();
    }

    public AccessRightEntity getThisAccessRightEntityById(Long id)
    {
       return accessRightRepository.getOne(id);
    }
    
    public void saveThisAccessRightEntity(AccessRightEntity arEntity)
    {
        accessRightRepository.save(arEntity);
    }

    public void deleteThisAccessRightEntityById(Long id)
    {
        accessRightRepository.deleteById(id);
    }

}
