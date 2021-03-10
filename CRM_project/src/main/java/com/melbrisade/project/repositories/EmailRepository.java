package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
