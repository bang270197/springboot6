package com.lecuong.service.impl;

import com.lecuong.entity.Blog;
import com.lecuong.mapper.blog.BlogMapper;
import com.lecuong.model.request.blog.BlogFilterRequest;
import com.lecuong.model.request.blog.BlogSaveRequest;
import com.lecuong.model.response.blog.BlogResponse;
import com.lecuong.repository.BlogRepository;
import com.lecuong.repository.specification.BlogSpecification;
import com.lecuong.service.BlogService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Data
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Override
    public Page<BlogResponse> getAll(BlogFilterRequest blogFilterRequest) {

        PageRequest pageRequest = PageRequest.of(blogFilterRequest.getPageIndex(), blogFilterRequest.getPageSize());

        Page<Blog> blogs = blogRepository.findAll(BlogSpecification.blogFilter(blogFilterRequest), pageRequest.previousOrFirst());

        return blogs.map(blogMapper::to);
    }

    @Override
    public void save(BlogSaveRequest blogSaveRequest) {
        Blog blog = blogMapper.to(blogSaveRequest);
        blogRepository.save(blog);
    }
}
