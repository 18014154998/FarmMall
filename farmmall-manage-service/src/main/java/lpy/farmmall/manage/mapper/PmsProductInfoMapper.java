package lpy.farmmall.manage.mapper;

import lpy.farmmall.bean.PmsProductInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/11 10:31
 * @verson 1.0
 **/

public interface PmsProductInfoMapper extends Mapper<PmsProductInfo> {


    List<PmsProductInfo> selectInfoByName(PmsProductInfo productName);
}
