package lpy.farmmall.service;

import lpy.farmmall.bean.UmsMember;
import lpy.farmmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:33
 * @verson 1.0
 **/

public interface UserService {
    //获取所以顾客信息
    List<UmsMember> getAllUser();
    //添加新的用户
    boolean addnewUser(UmsMember umsMember);
    //验证用户名是否重复
    boolean selectInfoByUsername(String username);
    //用户登陆,返回用户登陆的具体信息
    UmsMember getUserByNameAndPwd(UmsMember umsMember);
    //获取用户当前地址信息
    List<UmsMemberReceiveAddress> getAddressById(UmsMember umsMember);

    int addnewAddress(UmsMemberReceiveAddress address);

    int editUserAddress(UmsMemberReceiveAddress address);

    int deleteAddress(UmsMemberReceiveAddress address);
}
