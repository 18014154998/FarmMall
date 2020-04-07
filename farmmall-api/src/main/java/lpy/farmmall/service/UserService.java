package lpy.farmmall.service;

import lpy.farmmall.bean.UmsMember;
import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:33
 * @verson 1.0
 **/

public interface UserService {
    //获取所以顾客信息
    List<UmsMember> getAllUser();

}
