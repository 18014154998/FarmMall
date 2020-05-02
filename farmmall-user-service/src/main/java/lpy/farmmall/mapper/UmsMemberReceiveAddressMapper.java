package lpy.farmmall.mapper;

import lpy.farmmall.bean.UmsMemberReceiveAddress;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author:刘平远
 * @Date：2020/4/15 21:28
 * @verson 1.0
 **/
public interface UmsMemberReceiveAddressMapper extends Mapper<UmsMemberReceiveAddress> {

    int insertBymemberId(UmsMemberReceiveAddress umsMemberReceiveAddress);

}
