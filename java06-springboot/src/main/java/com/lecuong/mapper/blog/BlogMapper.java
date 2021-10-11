package com.lecuong.mapper.blog;

import com.lecuong.entity.Blog;
import com.lecuong.model.request.blog.BlogSaveRequest;
import com.lecuong.model.response.blog.BlogResponse;
import com.lecuong.repository.CategoryRepository;
import com.lecuong.repository.UserRepository;
import com.lecuong.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public BlogResponse to(Blog blog) {

        BlogResponse blogResponse = new BlogResponse();
        BeanUtils.refine(blog, blogResponse, BeanUtils::copyNonNull);

        if (blog.getCategory() != null) {
            blogResponse.setCategoryName(blog.getCategory().getName());
        }

        if (blog.getUser() != null) {
            blogResponse.setAuthor(blog.getUser().getUserName());
        }

        return blogResponse;
    }

    public Blog to(BlogSaveRequest blogSaveRequest) {
        Blog blog = new Blog();
        BeanUtils.refine(blogSaveRequest, blog, BeanUtils::copyNonNull);
        blog.setCategory(categoryRepository.findById(blogSaveRequest.getCategoryId()).get());
        blog.setUser(userRepository.findById(blogSaveRequest.getUserId()).get());

        return blog;
    }
}
