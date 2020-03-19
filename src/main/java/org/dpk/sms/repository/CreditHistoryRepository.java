package org.dpk.sms.repository;

import org.dpk.sms.entity.CreditHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditHistoryRepository extends JpaRepository<CreditHistoryEntity, Long> {
}
