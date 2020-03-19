package org.dpk.sms.repository;

import org.dpk.sms.entity.ChangeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeHistoryRepository extends JpaRepository<ChangeHistoryEntity, Long> {
}
