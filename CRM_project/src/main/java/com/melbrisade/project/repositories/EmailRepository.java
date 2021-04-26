package com.melbrisade.project.repositories;

//import com.melbrisade.project.entities.Email;
import com.melbrisade.project.entities.EmailVerifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface EmailRepository extends JpaRepository<EmailVerifier, Long> {

//    void save(EmailVerifier);
    EmailVerifier getEmailVerifierByUserId(Long userId);

    EmailVerifier getEmailVerifierByToken(String token);

}
