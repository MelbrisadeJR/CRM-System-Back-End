package com.melbrisade.project.repositories.impl;

import com.melbrisade.project.entities.EmailVerifier;
import com.melbrisade.project.repositories.EmailRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Repository
public abstract class EmailRepositoryImpl implements EmailRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // get email verifier data by userId
    public EmailVerifier getEmailVerifierByUserId(Long userId) {
        EmailVerifier emailVerifier = entityManager.createQuery("SELECT e FROM EmailVerifier e WHERE e.userId = :userId", EmailVerifier.class)
                .setParameter("userId", userId)
                .getSingleResult();
        return emailVerifier;
    }

    // get email verifier data by token
    public EmailVerifier getEmailVerifierByToken(String token) {
        EmailVerifier emailVerifier = entityManager.createQuery("SELECT e FROM EmailVerifier e WHERE e.token = :token", EmailVerifier.class)
                .setParameter("token", token)
                .getSingleResult();
        return emailVerifier;
    }
}
