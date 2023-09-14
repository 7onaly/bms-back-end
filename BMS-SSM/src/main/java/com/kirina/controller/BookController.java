package com.kirina.controller;

import com.kirina.pojo.Book;
import com.kirina.pojo.vo.PageVo;
import com.kirina.service.BookService;
import com.kirina.utils.Result;
import com.kirina.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("book")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    //模糊搜索
    @PostMapping("search")
    public Result search(@RequestBody PageVo pageVo, HttpServletResponse response){
        return bookService.search(pageVo);
    }

    //添加图书
    @PostMapping
    public Result add(@RequestBody Book book){
        return bookService.add(book);
    }

    //编辑图书
    @PutMapping
    public Result edit(@RequestBody Book book){
        return bookService.edit(book);
    }

    //删除图书
    @DeleteMapping("/{isbn}")
    public Result delete(@PathVariable String isbn){
        if(bookService.removeById(isbn)){
            return Result.ok(null);
        }
        return Result.build(null, ResultCodeEnum.ISBN_NONEXISTENT_OR_DELETED);
    }
}
