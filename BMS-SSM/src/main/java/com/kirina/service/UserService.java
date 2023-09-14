package com.kirina.service;

import com.kirina.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kirina.utils.Result;

import java.util.Map;

/**
* @author 10947
* @description 针对表【user】的数据库操作Service
* @createDate 2023-09-10 16:53:46
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result register(User user);
}
