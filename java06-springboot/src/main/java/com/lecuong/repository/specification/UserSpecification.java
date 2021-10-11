package com.lecuong.repository.specification;

import com.lecuong.entity.User;
import com.lecuong.model.request.user.UserAuthRequest;
import com.lecuong.model.request.user.UserFilterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> filter(UserFilterRequest userFilterRequest) {
        return Specification.where(withUserName(userFilterRequest.getUserName()))
                .and(withAddress(userFilterRequest.getAddress()))
                .and(withEmail(userFilterRequest.getEmail()))
                .and(withUserNameLike(userFilterRequest.getUserName()));
    }

    public static Specification<User> authFilter(UserAuthRequest userAuthRequest) {
        return Specification.where(withUserName(userAuthRequest.getUserName()))
                .and(withPassword(userAuthRequest.getPassword()));
    }

    public static Specification<User> withUserName(String userName) {
        if (StringUtils.isBlank(userName))
            return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"), userName);
    }

    public static Specification<User> withPassword(String password) {
        if (StringUtils.isBlank(password))
            return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("password"), password);
    }

    public static Specification<User> withAddress(String address) {
        if (StringUtils.isBlank(address))
            return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("address"), address);
    }

    public static Specification<User> withEmail(String email) {
        if (StringUtils.isBlank(email))
            return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<User> withUserNameLike(String userName) {
        if (StringUtils.isBlank(userName))
            return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("userName"), "%" + userName + "%");
    }
}
