package org.dpk.sms.repository;

import org.dpk.sms.entity.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {

    List<SubscriberEntity> findAllByIdIn(List<Long> ids);
}
