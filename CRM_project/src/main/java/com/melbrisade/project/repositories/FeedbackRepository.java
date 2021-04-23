package com.melbrisade.project.repositories;

import com.melbrisade.project.entities.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

    Feedback findFeedbackById(Long id);

}
