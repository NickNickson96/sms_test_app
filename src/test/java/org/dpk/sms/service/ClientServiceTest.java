package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.ClientEntity;
import org.dpk.sms.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class ClientServiceTest {
    private final ClientRepository clientRepository;


    public List<ClientEntity> getAllClientEntities()
    {
        return clientRepository.findAll();
    }

    public ClientEntity getThisClientEntityById(Long id)
    {
        return clientRepository.getOne(id);
    }

    public ClientEntity saveThisClientEntity(ClientEntity cEntity)
    {
        return clientRepository.save(cEntity);
    }

    public void deleteThisClientEntityById(Long id)
    {
        clientRepository.deleteById(id);
    }
}
