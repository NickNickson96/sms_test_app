package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.SmsTemplateEntity;
import org.dpk.sms.repository.SmsTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class SmsTemplateService {
    private final SmsTemplateRepository smsTemplateRepository;

    public List<SmsTemplateEntity> getAllSmsTemplateEntities()
    {
        return smsTemplateRepository.findAll();
    }

    public SmsTemplateEntity getThisSmsTemplateEntityById(Long id)
    {
        return smsTemplateRepository.getOne(id);
    }

    public SmsTemplateEntity saveThisSmsTemplateEntity(SmsTemplateEntity stEntity)
    {
        return smsTemplateRepository.save(stEntity);
    }

    public void deleteThisSmsTemplateEntityById(Long id)
    {
        smsTemplateRepository.deleteById(id);
    }
}
