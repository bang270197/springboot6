package com.lecuong.model.request.blog;

import com.lecuong.model.request.BaseRequest;
import lombok.Data;

@Data
public class BlogFilterRequest extends BaseRequest {

    private String name;
    private String url;
    private Long categotyId;
    private Long userId;
    private String keyWord;
}
