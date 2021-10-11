package com.lecuong.controller.user;

import com.lecuong.model.request.user.UserFilterRequest;
import com.lecuong.model.request.user.UserUpdateRequest;
import com.lecuong.model.response.BaseResponse;
import com.lecuong.model.response.user.UserResponse;
import com.lecuong.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Api(value = "User APIs")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Find user by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<UserResponse>> findById(@ApiParam(value = "Id of user", example = "123") @PathVariable long id) {
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity.ok(BaseResponse.ofSuccess(userResponse));
    }

    @GetMapping("/filter")
    public ResponseEntity<BaseResponse<Page<UserResponse>>> filter(@ModelAttribute UserFilterRequest userFilterRequest) {
        Page<UserResponse> userResponses = userService.filter(userFilterRequest);
        return ResponseEntity.ok(BaseResponse.ofSuccess(userResponses));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<Page<UserResponse>>> getAll(@RequestParam int index,
                                               @RequestParam int size) {

        PageRequest pageRequest = PageRequest.of(index, size);
        Page<UserResponse> userResponses = userService.getAll(pageRequest);
        return ResponseEntity.ok(BaseResponse.ofSuccess(userResponses));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> updateUser(@RequestBody UserUpdateRequest userUpdateRequest,
                                                         @PathVariable long id) {
        userService.updateUser(userUpdateRequest, id);
        return ResponseEntity.ok(BaseResponse.ofSuccess(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(BaseResponse.ofSuccess(null));
    }
}
