package com.melbrisade.project.controllers;

import com.melbrisade.project.entities.Feedback;
import com.melbrisade.project.services.FeedbackService;
import com.melbrisade.project.services.ValidationServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ValidationServiceError validationServiceError;

    @PostMapping("")
    public ResponseEntity<?> createNewFeedback(@Valid @RequestBody Feedback feedback, BindingResult result) {
        ResponseEntity<?> errMap = validationServiceError.ValidationService(result);

        if (errMap != null) {
            return errMap;
        }

        Feedback feedbackToCreate = feedbackService.saveOrUpdateFeedback(feedback);
        return new ResponseEntity<>(feedbackToCreate, HttpStatus.CREATED);
    }

    @GetMapping("/{feedback_id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable Long feedback_id) {
        Feedback feedback = feedbackService.findFeedbackById(feedback_id);
        return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Feedback> findAll() {
        return feedbackService.findAllFeedbacks();
    }


    @DeleteMapping ("/{feedback_id}")
    public ResponseEntity<?> deleteFeedbackById(@PathVariable Long feedback_id) {
        feedbackService.deleteFeedbackById(feedback_id);

        return new ResponseEntity<String>("Feedback with ID: "+ feedback_id+ " was deleted", HttpStatus.OK);
    }

    @DeleteMapping("/feedbacks/{feedback_ids}")
    public ResponseEntity<?> deleteMultipleFeedbacks(@PathVariable List<Long> feedback_ids) {
        for (long id : feedback_ids) {
            if (feedbackService.findFeedbackById(id) != null) {
                feedbackService.deleteFeedbackById(id);
            }
        }
        return new ResponseEntity<String>("Multiple feedbacks were deleted", HttpStatus.OK);
    }



}
