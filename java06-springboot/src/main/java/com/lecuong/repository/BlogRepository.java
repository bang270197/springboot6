package com.lecuong.repository;

import com.lecuong.entity.Blog;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends BaseRepository<Blog, Long> {
}
