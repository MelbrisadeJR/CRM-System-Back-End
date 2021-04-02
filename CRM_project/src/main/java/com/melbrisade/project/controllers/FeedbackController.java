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

@RestController
@RequestMapping("/api/feedbacks")
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



    @GetMapping("/{feedback_seq}")
    public ResponseEntity<?> getFeedbackById(@PathVariable String feedback_seq) {
        Feedback feedback = feedbackService.findFeedbackById(feedback_seq);
        return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Feedback> findAll() {
        return feedbackService.findAllFeedbacks();
    }


    @DeleteMapping ("/{feedback_seq}")
    public ResponseEntity<?> deleteFeedbackById(@PathVariable String feedback_seq) {
        feedbackService.deleteFeedbackById(feedback_seq);

        return new ResponseEntity<String>("Feedback with ID: "+ feedback_seq + " was deleted", HttpStatus.OK);
    }




}
