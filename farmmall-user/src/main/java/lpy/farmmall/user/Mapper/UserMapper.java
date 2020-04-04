package lpy.farmmall.user.Mapper;

import lpy.farmmall.user.Bean.UmsMember;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:36
 * @verson 1.0
 **/
@Repository
public interface UserMapper  {

    List<UmsMember> selectAllUser();
}
