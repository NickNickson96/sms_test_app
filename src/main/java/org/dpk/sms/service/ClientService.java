package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.dto.ClientDto;
import org.dpk.sms.entity.ClientEntity;
import org.dpk.sms.entity.TariffEntity;
import org.dpk.sms.entity.UserEntity;
import org.dpk.sms.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class ClientService {
    private final ClientRepository clientRepository;
    private final TariffService tariffService;
    private final UserService userService;


    public List<ClientEntity> getAllClientEntities()
    {
        return clientRepository.findAll();
    }

    public ClientEntity getThisClientEntityById(Long id)
    {

        return clientRepository.getOne(id);
    }

    //-------------------------------------------------------
    public ClientEntity saveThisClientEntity(ClientDto client)
    {
        return clientRepository.save(dtoToEntity(client));
    }

    private ClientEntity dtoToEntity(ClientDto dto) {
        ClientEntity entity = new ClientEntity();
        //entity.setId(dto.getId());
        entity.setContractNumber(dto.getContractNumber());
        entity.setName(dto.getName());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        entity.setAddress(dto.getAddress());
        entity.setBalance(dto.getBalance());
        entity.setPaymentAccount(dto.getPaymentAccount());
        entity.setMessageSenderName(dto.getMessageSenderName());
        entity.setRegistrationDate(dto.getRegistrationDate());
        
        TariffEntity tariff = tariffService.getThisTariffEntityById(dto.getTariffId());
        entity.setTariff(tariff);
        UserEntity user = userService.getThisUserEntityById(dto.getUserId());
        entity.setUser(user);

        return entity;
    }
//------------------------------------------------------------
//    public ClientEntity saveThisClientEntity(ClientEntity cEntity)
//    {
//        return clientRepository.save(cEntity);
//    }

    public void deleteThisClientEntityById(Long id)
    {
        clientRepository.deleteById(id);
    }
}
