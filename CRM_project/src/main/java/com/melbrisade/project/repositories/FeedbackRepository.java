package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
}
