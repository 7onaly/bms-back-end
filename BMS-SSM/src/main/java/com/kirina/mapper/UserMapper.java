package com.kirina.mapper;

import com.kirina.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author 10947
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-09-10 16:53:46
* @Entity com.kirina.pojo.User
*/

@Repository
public interface UserMapper extends BaseMapper<User> {

}




