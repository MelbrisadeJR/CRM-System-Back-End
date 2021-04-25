package com.melbrisade.project.exceptions;

import com.melbrisade.common.ApiResponse;
import lombok.Data;

@Data
public class ServiceAccessException extends RuntimeException {

    private ApiResponse apiResponse;

    public ServiceAccessException(int status, String msg) {
        this(ApiResponse.resMessage(status, msg));
    }

    public ServiceAccessException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }


    public ApiResponse get() {
        return apiResponse;
    }
}
