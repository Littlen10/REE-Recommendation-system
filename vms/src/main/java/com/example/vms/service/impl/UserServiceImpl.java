package com.example.vms.service.impl;

import com.example.vms.entity.User;
import com.example.vms.mapper.UserMapper;
import com.example.vms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vms
 * @since 2024-11-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
