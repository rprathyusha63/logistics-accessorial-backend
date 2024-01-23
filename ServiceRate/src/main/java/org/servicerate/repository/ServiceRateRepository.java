package org.servicerate.repository;

import org.servicerate.domain.ServiceRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRateRepository extends JpaRepository<ServiceRate, Long> {
}
