package com.lecuong.controller.user;

import com.lecuong.model.request.user.UserAuthRequest;
import com.lecuong.model.response.BaseResponse;
import com.lecuong.model.response.user.UserResponse;
import com.lecuong.security.jwt.TokenProducer;
import com.lecuong.security.jwt.model.JwtPayLoad;
import com.lecuong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProducer tokenProducer;

    @PostMapping
    public ResponseEntity<BaseResponse<String>> auth(@RequestBody UserAuthRequest userAuthRequest) {


        //User user = userService.findOne(UserSpecification.authFilter(userAuthRequest));
        UserResponse userResponse = userService.auth(userAuthRequest);
        JwtPayLoad jwtPayload = createPayload(userResponse);
        String token = tokenProducer.token(jwtPayload);
        return ResponseEntity.ok(BaseResponse.ofSuccess(token));
    }

    private JwtPayLoad createPayload(UserResponse userResponse){
        JwtPayLoad jwtPayload = new JwtPayLoad();
        jwtPayload.setUserName(userResponse.getUserName());
        jwtPayload.setId(userResponse.getId());
        //String role = user.getRoles().stream().map(Role::getName).collect(Collectors.joining(","));
        String role = String.join(",", userResponse.getRoleName());
        jwtPayload.setRole(role);

        return jwtPayload;
    }
}
