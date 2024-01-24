package org.services.repository;

import org.services.domain.Accessorials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessorialRepository extends JpaRepository<Accessorials, String> {
}
