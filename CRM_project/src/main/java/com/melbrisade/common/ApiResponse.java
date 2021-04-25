package com.melbrisade.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int statusCode;

    private String responseMessage;

    private Object responseData;


    public static ApiResponse resMessage(int statusCode, String responseMessage) {
        return new ApiResponse(statusCode, responseMessage, null);
    }

    public static ApiResponse OK() {
        return new ApiResponse(STATUS.SUCCESS.getStatusCode(), STATUS.SUCCESS.getResponseMessage(), null);
    }

    public static ApiResponse OKData(Object responseData) {
        return new ApiResponse(STATUS.SUCCESS.getStatusCode(), STATUS.SUCCESS.getResponseMessage(), responseData);
    }

    public static ApiResponse resStatus(STATUS status) {
        return new ApiResponse(status.getStatusCode(), status.getResponseMessage(), null);
    }

    public enum STATUS {
        SUCCESS(200, "OK"),
        BAD_REQUEST(400, "Bad Request"),
        NOT_FOUND(404, "Not Found"),
        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),
        NOT_VALID_PARAM(40005, "Not valid Params"),
        NOT_SUPPORTED_OPERATION(40006, "Operation not supported"),
        NOT_LOGIN(50000, "Not Login");

        private int statusCode;

        private String responseMessage;

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        STATUS(int statusCode, String responseMessage) {
            this.statusCode = statusCode;
            this.responseMessage = responseMessage;
        }
    }
}
