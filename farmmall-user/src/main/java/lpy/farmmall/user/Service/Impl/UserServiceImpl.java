package lpy.farmmall.user.Service.Impl;

import lpy.farmmall.user.Bean.UmsMember;
import lpy.farmmall.user.Bean.UmsMemberReceiveAddress;
import lpy.farmmall.user.Bean.UmsMemberReceiveAddressExample;
import lpy.farmmall.user.Mapper.UmsMemberReceiveAddressMapper;
import lpy.farmmall.user.Mapper.UserMapper;
import lpy.farmmall.user.Service.UserService;
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
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    //获取所以顾客信息
    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers=userMapper.selectAllUser();
        return umsMembers;
    }
    //根据会员号码，获取收货地址
    @Override
    public List<UmsMemberReceiveAddress> getReciveredAddressByMenberId(Long memberId) {
        UmsMemberReceiveAddressExample umsAddressExample = new UmsMemberReceiveAddressExample();
        UmsMemberReceiveAddressExample.Criteria criteria = umsAddressExample.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        List<UmsMemberReceiveAddress> addressList=umsMemberReceiveAddressMapper.selectByExample(umsAddressExample);
        return addressList;
    }
}
