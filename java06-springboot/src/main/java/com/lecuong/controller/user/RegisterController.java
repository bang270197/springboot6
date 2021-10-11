package com.lecuong.controller.user;

import com.lecuong.model.request.user.UserSaveRequest;
import com.lecuong.model.response.BaseResponse;
import com.lecuong.service.UserService;
import com.lecuong.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<BaseResponse<Void>> save(@RequestBody UserSaveRequest userSaveRequest) {
        UserValidate.validate(userSaveRequest);
        userService.save(userSaveRequest);
        return ResponseEntity.ok(BaseResponse.ofSuccess(null));
    }
}
