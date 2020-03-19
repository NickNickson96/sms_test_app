package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.SubscriberEntity;
import org.dpk.sms.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public List<SubscriberEntity> getAllSubscriberEntities()
    {
        return subscriberRepository.findAll();
    }

    public List<SubscriberEntity> getAllSubscribersByIds(List<Long> ids) {
        return subscriberRepository.findAllByIdIn(ids);
    }

    public SubscriberEntity getThisSubscriberEntityById(Long id)
    {
        return subscriberRepository.getOne(id);
    }

    public SubscriberEntity saveThisSubscriberEntity(SubscriberEntity subscriberEntity)
    {
        return subscriberRepository.save(subscriberEntity);
    }

    public void deleteThisSubscriberEntityById(Long id)
    {
        subscriberRepository.deleteById(id);
    }
}

