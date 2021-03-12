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

    public Feedback findFeedbackById(String feedback_seq) {
        return feedbackRepository.findFeedbackByFeedbackSequenceNum(feedback_seq);
    }



    public Iterable<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public void deleteFeedbackById(String feedback_seq) {
        Feedback feedback = feedbackRepository.findFeedbackByFeedbackSequenceNum(feedback_seq);

        if (feedback == null) {
            throw new FeedbackException("Cannot delete with ID" + feedback_seq + ". This feedback does not exist");
        }
        feedbackRepository.delete(feedback);
    }


}
