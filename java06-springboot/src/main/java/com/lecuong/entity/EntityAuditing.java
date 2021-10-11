package com.lecuong.entity;

import com.lecuong.security.UserAuthentication;
import com.lecuong.security.UserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityAuditing  implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        try {
            UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) userAuthentication.getDetails();

            return Optional.of(userDetails.getUsername());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
