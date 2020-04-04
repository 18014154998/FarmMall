package lpy.farmmall.user.Service;

import lpy.farmmall.user.Bean.UmsMember;
import lpy.farmmall.user.Bean.UmsMemberReceiveAddress;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:33
 * @verson 1.0
 **/

public interface UserService {
    //获取所以顾客信息
    List<UmsMember> getAllUser();
    //根据会员号码，获取收货地址
    List<UmsMemberReceiveAddress> getReciveredAddressByMenberId(Long memberId);
}
