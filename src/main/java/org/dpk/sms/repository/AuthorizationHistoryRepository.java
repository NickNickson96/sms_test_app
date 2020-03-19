package org.dpk.sms.repository;

import org.dpk.sms.entity.AuthorizationHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationHistoryRepository extends JpaRepository<AuthorizationHistoryEntity, Long> {
}
