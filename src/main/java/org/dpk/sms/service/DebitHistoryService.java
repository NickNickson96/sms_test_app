package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.DebitHistoryEntity;
import org.dpk.sms.repository.DebitHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class DebitHistoryService {
    private final DebitHistoryRepository debitHistoryRepository;

    public List<DebitHistoryEntity> getAllDebitHistoryEntities()
    {
        return debitHistoryRepository.findAll();
    }

    public DebitHistoryEntity getThisDebitHistoryEntityById(Long id)
    {
        return debitHistoryRepository.getOne(id);
    }

    public DebitHistoryEntity saveThisDebitHistoryEntity(DebitHistoryEntity dhEntity)
    {
        return debitHistoryRepository.save(dhEntity);
    }

    public void deleteThisDebitHistoryEntityById(Long id)
    {
        debitHistoryRepository.deleteById(id);
    }
}
