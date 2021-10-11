package com.lecuong.model.request.user;

import lombok.Data;
import lombok.Getter;

@Data
public class UserAuthRequest {

    private String userName;
    private String password;
}
