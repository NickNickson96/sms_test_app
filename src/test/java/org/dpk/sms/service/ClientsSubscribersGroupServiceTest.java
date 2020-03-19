package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.ClientsSubscribersGroupEntity;
import org.dpk.sms.repository.ClientsSubscribersGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientsSubscribersGroupServiceTest {
    private final ClientsSubscribersGroupRepository clientsSubscribersGroupRepository;


    public List<ClientsSubscribersGroupEntity> getAllClientsSubscribersGroupEntities()
    {
        return clientsSubscribersGroupRepository.findAll();
    }

    public ClientsSubscribersGroupEntity getThisClientSubscribersGroupEntityById(Long id)
    {
        return clientsSubscribersGroupRepository.getOne(id);
    }

    public ClientsSubscribersGroupEntity saveThisClientSubscribersGroupEntity(ClientsSubscribersGroupEntity csgEntity)
    {
        return clientsSubscribersGroupRepository.save(csgEntity);
    }

    public void deleteThisClientSubscribersGroupEntityById(Long id)
    {
        clientsSubscribersGroupRepository.deleteById(id);
    }
}
