package lpy.farmmall.user.Service.Impl;

import lpy.farmmall.bean.UmsMember;
import lpy.farmmall.user.Mapper.UserMapper;
import lpy.farmmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:34
 * @verson 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    //获取所以顾客信息
    @Override
    public List<UmsMember> getAllUser() {
        /*List<UmsMember> umsMembers=userMapper.selectAllUser();*/
        List<UmsMember> umsMembers=userMapper.selectAll();
        return umsMembers;
    }


}
