package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.ChangeHistoryEntity;
import org.dpk.sms.repository.ChangeHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChangeHistoryServiceTest {
    private final ChangeHistoryRepository changeHistoryRepository;

    public List<ChangeHistoryEntity> getAllChangeHistoryEntities()
    {
        return changeHistoryRepository.findAll();
    }

    public ChangeHistoryEntity getThisChangeHistoryEntityById(Long id)
    {
        return changeHistoryRepository.getOne(id);
    }

    public ChangeHistoryEntity saveThisChangeHistoryEntity(ChangeHistoryEntity chEntity)
    {
        return changeHistoryRepository.save(chEntity);
    }

    public void deleteThisChangeHistoryEntityById(Long id)
    {
        changeHistoryRepository.deleteById(id);
    }

}
