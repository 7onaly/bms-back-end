package com.kirina.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kirina.pojo.User;
import com.kirina.service.UserService;
import com.kirina.mapper.UserMapper;
import com.kirina.utils.Result;
import com.kirina.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 10947
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-09-10 16:53:46
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    UserMapper userMapper;

    //登录
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>().eq(User::getUsername,user.getUsername());
        User loginUser = userMapper.selectOne(wrapper);
        //用户名不存在
        if (loginUser == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        //成功登录
        if (user.getPassword().equals(loginUser.getPassword())) {
            return Result.ok(null);
        }
        //密码错误
        return Result.build(null, ResultCodeEnum.USERNAME_OR_PASSWORD_ERROR);
    }

    //注册
    @Override
    public Result register(User user) {

        //用户名已存在
        if(userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername()))
                != null){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        userMapper.insert(user);
        return Result.ok(null);
    }
}




