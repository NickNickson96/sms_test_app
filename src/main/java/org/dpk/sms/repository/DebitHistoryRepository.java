package org.dpk.sms.repository;

import org.dpk.sms.entity.DebitHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitHistoryRepository extends JpaRepository<DebitHistoryEntity, Long> {
}
