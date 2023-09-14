package com.kirina.pojo.vo;

import lombok.Data;

@Data
public class PageVo {

    private String keyword;

    private int pageNum = 1;

    private int pageSize = 5;

}
