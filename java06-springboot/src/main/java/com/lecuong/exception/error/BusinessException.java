package com.lecuong.exception.error;

import com.lecuong.exception.StatusResponse;
import com.lecuong.exception.StatusTemplate;
import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class BusinessException extends RuntimeException {

    private StatusResponse statusResponse;

    public BusinessException(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }
}
