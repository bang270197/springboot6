package com.lecuong.model.request.blog;

import lombok.Data;

@Data
public class BlogSaveRequest {
    private String thumbnail;
    private String url;
    private String name;
    private String description;
    private String title;
    private String content;
    private Long categoryId;
    private Long userId;
}
