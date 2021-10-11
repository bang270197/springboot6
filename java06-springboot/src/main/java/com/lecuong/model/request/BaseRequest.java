package com.lecuong.model.request;

import lombok.Data;

@Data
public class BaseRequest {

    private int pageIndex = 1;
    private int pageSize = 10;
}
