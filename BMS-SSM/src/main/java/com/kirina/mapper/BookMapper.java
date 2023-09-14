package com.kirina.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kirina.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kirina.pojo.vo.PageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* @author 10947
* @description 针对表【book】的数据库操作Mapper
* @createDate 2023-09-10 16:53:36
* @Entity com.kirina.pojo.Book
*/

@Repository
public interface BookMapper extends BaseMapper<Book> {

    //模糊搜索并分页
    IPage<Map> selectPageVo(IPage page,@Param("pageVo")PageVo pageVo);

}




