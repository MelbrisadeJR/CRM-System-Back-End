package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Transactional
    @Modifying
    @Query("update Users u set u.isEmailVerified = ?1 where u.id = ?2")
    void updateEmailVerified(Boolean verified, Long userId);

    Users findByUsername(String username);
    Users getById(Long id);
}
