package org.dpk.sms.repository;

import org.dpk.sms.entity.SmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<SmsEntity,Long> {
}
