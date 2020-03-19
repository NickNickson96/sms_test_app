package org.dpk.sms.repository;

import org.dpk.sms.entity.TariffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<TariffEntity, Long> {
}
