package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.ContactPersonEntity;
import org.dpk.sms.repository.ContactPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class ContactPersonService {
    private final ContactPersonRepository contactPersonRepository;

    public List<ContactPersonEntity> getAllContactPersonEntities()
    {
        return contactPersonRepository.findAll();
    }

    public ContactPersonEntity getThisContactPersonEntityById(Long id)
    {
        return contactPersonRepository.getOne(id);
    }

    public ContactPersonEntity saveThisContactPersonEntity(ContactPersonEntity cpEntity)
    {
        return contactPersonRepository.save(cpEntity);
    }

    public void deleteThisContactPersonEntityById(Long id)
    {
        contactPersonRepository.deleteById(id);
    }
}
