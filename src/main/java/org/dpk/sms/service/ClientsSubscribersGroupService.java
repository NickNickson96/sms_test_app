package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.dto.ClientsSubscribersGroupDto;
import org.dpk.sms.entity.ClientsSubscribersGroupEntity;
import org.dpk.sms.entity.SubscriberEntity;
import org.dpk.sms.repository.ClientsSubscribersGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientsSubscribersGroupService {
    private final ClientsSubscribersGroupRepository clientsSubscribersGroupRepository;
    private final SubscriberService subscriberService;



    public List<ClientsSubscribersGroupEntity> getAllClientsSubscribersGroupEntities()
    {
        return clientsSubscribersGroupRepository.findAll();
    }

    public ClientsSubscribersGroupEntity getThisClientsSubscribersGroupEntityById(Long id)
    {
        return clientsSubscribersGroupRepository.getOne(id);
    }
    //-------------------------------------------------------
    public ClientsSubscribersGroupEntity saveThisClientsSubscribersGroupEntity(ClientsSubscribersGroupDto csg)
    {
        return clientsSubscribersGroupRepository.save(dtoToEntity(csg));
    }

    private ClientsSubscribersGroupEntity dtoToEntity(ClientsSubscribersGroupDto dto) {
        ClientsSubscribersGroupEntity entity = new ClientsSubscribersGroupEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        List<SubscriberEntity> subscribers = subscriberService.getAllSubscribersByIds(dto.getSubIds());

        entity.setSubscribers(subscribers);

        return entity;
    }
    //-------------------------------------------------------

    public void deleteThisClientsSubscribersGroupEntityById(Long id)
    {
        clientsSubscribersGroupRepository.deleteById(id);
    }
}
