package com.melbrisade.project.exceptions;

public class FeedbackExceptionResponse {

    private String feedbackIdStr;

    public FeedbackExceptionResponse(String feedbackIdStr) {
        this.feedbackIdStr = feedbackIdStr;
    }

    public String getFeedbackIdStr() {
        return feedbackIdStr;
    }

    public void setFeedbackIdStr(String feedbackIdStr) {
        this.feedbackIdStr = feedbackIdStr;
    }
}
