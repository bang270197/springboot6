package com.lecuong.repository;

import com.lecuong.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

    List<Role> findAllByIdIn(List<Long> ids);
}
