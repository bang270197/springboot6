package com.lecuong.mapper.user;

import com.lecuong.entity.Role;
import com.lecuong.entity.User;
import com.lecuong.model.request.user.UserSaveRequest;
import com.lecuong.model.response.user.UserResponse;
import com.lecuong.repository.RoleRepository;
import com.lecuong.utils.AlgorithmMd5;
import com.lecuong.utils.BeanUtils;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Component
public class UserMapper {

    private final RoleRepository roleRepository;

    public UserResponse to(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.refine(user, userResponse, BeanUtils::copyNonNull);
//        List<String> roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
//        userResponse.setRoleName(roles);
        return userResponse;
    }

    public User to(UserSaveRequest userSaveRequest) {
        User user = new User();
        BeanUtils.refine(userSaveRequest, user, BeanUtils::copyNonNull);
        Set<Role> roles = new HashSet<>(roleRepository.findAllByIdIn(userSaveRequest.getIds()));
        user.setRoles(roles);
        user.setPassword(AlgorithmMd5.getMd5(userSaveRequest.getPassword()));
        return user;
    }
}
