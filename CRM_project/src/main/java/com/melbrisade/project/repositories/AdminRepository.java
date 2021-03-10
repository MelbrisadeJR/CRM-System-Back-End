package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}