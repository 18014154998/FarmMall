package lpy.farmmall.user.Controller;

import lpy.farmmall.bean.UmsMember;
import lpy.farmmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<UmsMember> getAllUserInfo(){
        List<UmsMember> umsMembers=userService.getAllUser();
        return umsMembers;
    }



}
