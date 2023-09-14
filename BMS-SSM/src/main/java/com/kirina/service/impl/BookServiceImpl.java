package com.kirina.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kirina.pojo.Book;
import com.kirina.pojo.vo.PageVo;
import com.kirina.service.BookService;
import com.kirina.mapper.BookMapper;
import com.kirina.utils.Result;
import com.kirina.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author 10947
* @description 针对表【book】的数据库操作Service实现
* @createDate 2023-09-10 16:53:36
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

    @Autowired
    BookMapper bookMapper;

    //模糊搜索并分页
    @Override
    public Result search(PageVo pageVo) {
        Map map = new HashMap<>();
        IPage<Map> page = new Page<>(pageVo.getPageNum(), pageVo.getPageSize());
        bookMapper.selectPageVo(page, pageVo);
        map.put("booklist",page.getRecords());
        map.put("pageNum", page.getCurrent());
        map.put("pageSize", page.getSize());
        map.put("pages", page.getPages());
        return Result.ok(map);
    }

    //添加图书
    @Override
    public Result add(Book book) {
        try{
            bookMapper.insert(book);
            return Result.ok(null);
        }catch (Exception e){
            return Result.build(null, ResultCodeEnum.ISBN_EXISTED);
        }
    }

    //编辑图书
    @Override
    public Result edit(Book book) {
        Book thisBook = bookMapper.selectById(book.getIsbn());
        book.setVersion(thisBook.getVersion());
        if(bookMapper.updateById(book) != 0){
            return Result.ok(null);
        }
        return Result.build(null,ResultCodeEnum.ISBN_NONEXISTENT_OR_DELETED);
    }


}




