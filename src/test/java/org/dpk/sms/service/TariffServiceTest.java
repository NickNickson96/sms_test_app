package org.dpk.sms.service;
import lombok.RequiredArgsConstructor;
import org.dpk.sms.entity.TariffEntity;
import org.dpk.sms.repository.TariffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class TariffServiceTest {
    private final TariffRepository tariffRepository;

    public List<TariffEntity> getAllTariffEntities()
    {
        return tariffRepository.findAll();
    }

    public TariffEntity getThisTariffEntityById(Long id)
    {
        return tariffRepository.getOne(id);
    }

    public TariffEntity saveThisTariffEntity(TariffEntity tEntity)
    {
       return tariffRepository.save(tEntity);
    }

    public void deleteThisTariffEntityById(Long id)
    {
        tariffRepository.deleteById(id);
    }
}
