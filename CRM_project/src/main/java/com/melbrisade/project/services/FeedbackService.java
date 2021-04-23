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

    public Feedback findFeedbackById(Long id) {
        return feedbackRepository.findFeedbackById(id);
    }

    public Iterable<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedbackById(Long id) {
        Feedback feedback = feedbackRepository.findFeedbackById(id);

        if (feedback == null) {
            throw new FeedbackException("Cannot delete with ID" + id + ". This feedback does not exist");
        }
        feedbackRepository.delete(feedback);
    }


}
