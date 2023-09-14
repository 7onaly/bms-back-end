package com.kirina.service;

import com.kirina.pojo.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kirina.pojo.vo.PageVo;
import com.kirina.utils.Result;

import java.util.Map;

/**
* @author 10947
* @description 针对表【book】的数据库操作Service
* @createDate 2023-09-10 16:53:36
*/
public interface BookService extends IService<Book> {

    Result search(PageVo pageVo);

    Result add(Book book);

    Result edit(Book book);
}
