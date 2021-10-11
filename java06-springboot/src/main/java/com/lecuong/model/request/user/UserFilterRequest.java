package com.lecuong.model.request.user;

import com.lecuong.model.request.BaseRequest;
import lombok.Data;

@Data
public class UserFilterRequest extends BaseRequest {

    private String userName;
    private String address;
    private String email;
}
