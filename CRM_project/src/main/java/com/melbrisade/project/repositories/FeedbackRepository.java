package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    Feedback findFeedbackById(long id);

    @Override
    List<Feedback> findAll();
}
