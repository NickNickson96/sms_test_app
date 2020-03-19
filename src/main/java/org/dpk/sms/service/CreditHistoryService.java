package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.CreditHistoryEntity;
import org.dpk.sms.repository.CreditHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class CreditHistoryService {
    private final CreditHistoryRepository creditHistoryRepository;

    public List<CreditHistoryEntity> getAllCreditHistoryEntities()
    {
        return creditHistoryRepository.findAll();
    }

    public CreditHistoryEntity getThisCreditHistoryEntityById(Long id)
    {
        return creditHistoryRepository.getOne(id);
    }

    public CreditHistoryEntity saveThisCreditHistoryEntity(CreditHistoryEntity chEntity)
    {
        return creditHistoryRepository.save(chEntity);
    }

    public void deleteThisCreditHistoryEntityById(Long id)
    {
        creditHistoryRepository.deleteById(id);
    }
}
