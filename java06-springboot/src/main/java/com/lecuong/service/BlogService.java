package com.lecuong.service;

import com.lecuong.model.request.blog.BlogFilterRequest;
import com.lecuong.model.request.blog.BlogSaveRequest;
import com.lecuong.model.response.blog.BlogResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {

    Page<BlogResponse> getAll(BlogFilterRequest blogFilterRequest);

    void save(BlogSaveRequest blogSaveRequest);
}
