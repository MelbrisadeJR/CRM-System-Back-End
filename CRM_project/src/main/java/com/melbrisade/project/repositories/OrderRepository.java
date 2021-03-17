package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.OrderEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntities, UUID> {

}
