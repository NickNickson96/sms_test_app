package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.AuthorizationHistoryEntity;
import org.dpk.sms.repository.AuthorizationHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorizationHistoryServiceTest {
    private final AuthorizationHistoryRepository authorizationHistoryRepository;

    public List<AuthorizationHistoryEntity> getAllAuthorizationHistoryEntities()
    {
        return authorizationHistoryRepository.findAll();
    }

    public AuthorizationHistoryEntity getThisAuthorizationHistoryEntityById(Long id)
    {
        return authorizationHistoryRepository.getOne(id);
    }

    public AuthorizationHistoryEntity saveThisAuthorizationHistoryEntity(AuthorizationHistoryEntity ahEntity)
    {
        return authorizationHistoryRepository.save(ahEntity);
    }

    public void deleteThisAuthorizationHistoryEntityById(Long id)
    {
        authorizationHistoryRepository.deleteById(id);
    }
}
