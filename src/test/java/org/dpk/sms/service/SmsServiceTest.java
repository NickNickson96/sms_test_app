package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.SmsEntity;
import org.dpk.sms.repository.SmsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class SmsServiceTest {
    private final SmsRepository smsRepository;

    public List<SmsEntity> getAllSmsEntities()
    {
        return smsRepository.findAll();
    }

    public SmsEntity getThisSmsEntityById(Long id)
    {
        return smsRepository.getOne(id);
    }

    public SmsEntity saveThisSmsEntity(SmsEntity smsEntity)
    {
        return smsRepository.save(smsEntity);
    }

    public void deleteThisSmsEntityById(Long id)
    {
        smsRepository.deleteById(id);
    }
}
