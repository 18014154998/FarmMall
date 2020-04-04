package lpy.farmmall.user.Controller;

import lpy.farmmall.user.Bean.UmsMember;
import lpy.farmmall.user.Bean.UmsMemberReceiveAddress;
import lpy.farmmall.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2019/12/2 22:33
 * @verson 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    //获取所有的人员信息
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> test1(){
        List<UmsMember> umsMembers=userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("/getReciveredAddressByMenberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReciveredAddressByMenberId( Long  MemberId){
        List<UmsMemberReceiveAddress> addressList=userService.getReciveredAddressByMenberId(MemberId);
        return addressList;
    }

}
