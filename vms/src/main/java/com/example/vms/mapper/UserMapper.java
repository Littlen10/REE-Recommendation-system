package com.example.vms.mapper;

import com.example.vms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author vms
 * @since 2024-11-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
