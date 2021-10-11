package com.lecuong.controller.blog;

import com.lecuong.model.request.blog.BlogFilterRequest;
import com.lecuong.model.request.blog.BlogSaveRequest;
import com.lecuong.model.response.BaseResponse;
import com.lecuong.model.response.blog.BlogResponse;
import com.lecuong.service.BlogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<BaseResponse<Page<BlogResponse>>> getAll(@ModelAttribute BlogFilterRequest blogFilterRequest) {
        Page<BlogResponse> blogResponsePage = blogService.getAll(blogFilterRequest);
        return ResponseEntity.ok(BaseResponse.ofSuccess(blogResponsePage));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Void>> save(@RequestBody BlogSaveRequest blogSaveRequest) {
        blogService.save(blogSaveRequest);
        return ResponseEntity.ok(BaseResponse.ofSuccess(null));
    }
}
