package lpy.farmmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.UmsMember;

import lpy.farmmall.bean.UmsMemberReceiveAddress;
import lpy.farmmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class UserController {

    @Reference
    UserService userService;

    //获取所有的人员信息
    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUserInfo(){
        List<UmsMember> umsMembers=userService.getAllUser();
        return umsMembers;
    }

    //用户登陆,返回用户登陆的具体信息
    @RequestMapping("/api/login")
    @ResponseBody
    public UmsMember login(@RequestBody UmsMember umsMember){
        String md5Password=DigestUtils.md5DigestAsHex(umsMember.getPassword().getBytes());
        umsMember.setPassword(md5Password);
        UmsMember loginuser= userService.getUserByNameAndPwd(umsMember);
        System.out.println(loginuser);
        return loginuser;
    }
    //验证用户名是否重复
    @RequestMapping("/api/usernamechecked")
    @ResponseBody
    public String checkUsername(@RequestBody UmsMember umsMember){
        boolean b =userService.selectInfoByUsername(umsMember.getUsername());
        if (b){
            return "用户名已存在";
        }else {
            return "no user";
        }
    }
    //用户注册
    @RequestMapping("/api/register")
    @ResponseBody
    public String userRegister(@RequestBody UmsMember umsMember){
        System.out.println(umsMember.getUsername()+umsMember.getPassword()+umsMember.getPhone());
        //密码加密
        String md5Password=DigestUtils.md5DigestAsHex(umsMember.getPassword().getBytes());
        System.out.println("加密后的密码是"+md5Password);
        umsMember.setPassword(md5Password);
        boolean b=userService.addnewUser(umsMember);
        if (b){
            return "ok";
        }else {
            return "error";
        }
    }
    //获取用户当前地址信息
    @RequestMapping("/api/getAddressById")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAddress(@RequestBody UmsMember umsMember){
        List<UmsMemberReceiveAddress> Addresses = userService.getAddressById(umsMember);
        System.out.println(Addresses);
        return Addresses;
    }
    //用户添加地址信息
    @RequestMapping("/api/addnewAddress")
    @ResponseBody
    public String addnewAddress(@RequestBody UmsMemberReceiveAddress address){
        int i = userService.addnewAddress(address);
        return "ok";
    }
    //用户修改地址信息
    @RequestMapping("/api/editUserAddress")
    @ResponseBody
    public String editUserAddress(@RequestBody UmsMemberReceiveAddress address){
        int i =userService.editUserAddress(address);
        System.out.println("edit"+address.getMemberId()+"i"+i);
        return "ok";
    }
    //（删除也包括了，就是将原本的状态由0改为1即可）
    @RequestMapping("/api/deleteAddress")
    @ResponseBody
    public String deleteAddress(@RequestBody UmsMemberReceiveAddress address){
        int i = userService.deleteAddress(address);
        System.out.println("delete"+address+"i"+i);
        return "ok";
    }
}
