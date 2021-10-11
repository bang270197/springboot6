package com.lecuong.service;

import com.lecuong.entity.User;
import com.lecuong.model.request.user.UserAuthRequest;
import com.lecuong.model.request.user.UserFilterRequest;
import com.lecuong.model.request.user.UserSaveRequest;
import com.lecuong.model.request.user.UserUpdateRequest;
import com.lecuong.model.response.user.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface UserService {

    void save(UserSaveRequest userSaveRequest);

    UserResponse auth(UserAuthRequest userAuthRequest);

    UserResponse findById(long id);

    Page<UserResponse> getAll(Pageable pageable);

    Page<UserResponse> filter(UserFilterRequest userFilterRequest);

    User findOne(Specification<User> authFilter);

    void updateUser(UserUpdateRequest userUpdateRequest, long id);

    void deleteUserById(long id);
}
