package org.dpk.sms.repository;

import org.dpk.sms.entity.SmsTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsTemplateRepository extends JpaRepository<SmsTemplateEntity, Long> {
}
