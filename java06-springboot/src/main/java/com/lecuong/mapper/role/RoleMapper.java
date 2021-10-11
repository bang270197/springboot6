package com.lecuong.mapper.role;

import com.lecuong.entity.Role;
import com.lecuong.model.response.role.RoleResponse;
import com.lecuong.utils.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleResponse to(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        BeanUtils.refine(role, roleResponse, BeanUtils::copyNonNull);
        return roleResponse;
    }
}
