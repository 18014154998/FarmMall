package lpy.farmmall.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import lpy.farmmall.bean.UmsMember;
import lpy.farmmall.bean.UmsMemberReceiveAddress;
import lpy.farmmall.mapper.UmsMemberReceiveAddressMapper;
import lpy.farmmall.mapper.UserMapper;
import lpy.farmmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


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
    @Autowired
    UmsMemberReceiveAddressMapper userAddressMapper;

    //获取所以顾客信息
    @Override
    public List<UmsMember> getAllUser() {
        /*List<UmsMember> umsMembers=userMapper.selectAllUser();*/
        List<UmsMember> umsMembers=userMapper.selectAll();
        return umsMembers;
    }
    //添加新的用户
    @Override
    public boolean addnewUser(UmsMember umsMember) {
        int i = userMapper.insert(umsMember);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    //验证用户名是否重复
    @Override
    public boolean selectInfoByUsername(String username) {
        int i = userMapper.selectUserByUsername(username);
        System.out.println("you "+i);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    //用户登陆,返回用户登陆的具体信息
    @Override
    public UmsMember getUserByNameAndPwd(UmsMember umsMember) {
        UmsMember loginuser = userMapper.selectOne(umsMember);
        return loginuser;
    }
    //获取用户当前地址信息
    @Override
    public List<UmsMemberReceiveAddress> getAddressById(UmsMember umsMember) {
        UmsMemberReceiveAddress address=new UmsMemberReceiveAddress();
        address.setMemberId(umsMember.getId());
        List<UmsMemberReceiveAddress> addressList = userAddressMapper.select(address);
        return addressList;
    }

    @Override
    public int addnewAddress(UmsMemberReceiveAddress address) {
        int i = userAddressMapper.insert(address);
        return i;
    }

    @Override
    public int editUserAddress(UmsMemberReceiveAddress address) {
        int i = userAddressMapper.updateByPrimaryKey(address);
        if (0==i){
           // userAddressMapper.insertBymemberId(address);
            userAddressMapper.insert(address);
            return 1;
        }else {
            return i;
        }
    }

    @Override
    public int deleteAddress(UmsMemberReceiveAddress address) {
        int i = userAddressMapper.deleteByPrimaryKey(address);
        return i;
    }


}
