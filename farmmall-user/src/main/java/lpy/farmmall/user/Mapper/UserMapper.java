package lpy.farmmall.user.Mapper;

import lpy.farmmall.bean.UmsMember;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:36
 * @verson 1.0
 * 使用通用mapper，负责单表的crud
 **/
@Repository
public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();
}
