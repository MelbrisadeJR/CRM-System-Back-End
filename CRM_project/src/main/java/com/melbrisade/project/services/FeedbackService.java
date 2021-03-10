package com.melbrisade.project.services;

import com.melbrisade.project.entities.Feedback;
import com.melbrisade.project.exceptions.FeedbackException;
import com.melbrisade.project.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback saveOrUpdateFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback findFeedbackById(long feedback_id) {
        return feedbackRepository.findFeedbackById(feedback_id);
    }

    public Iterable<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedbackById(long feedback_id) {
        Feedback feedback = feedbackRepository.findFeedbackById(feedback_id);

        if (feedback == null) {
            throw new FeedbackException("Cannot delete with ID" + feedback_id + ". This feedback does not exist");
        }
        feedbackRepository.delete(feedback);
    }


}
