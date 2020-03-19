package org.dpk.sms.repository;

import org.dpk.sms.entity.ContactPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepository extends JpaRepository<ContactPersonEntity,Long> {
}
