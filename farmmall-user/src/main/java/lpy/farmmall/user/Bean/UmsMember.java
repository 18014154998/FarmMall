package lpy.farmmall.user.Bean;

import lombok.Data;

import java.util.Date;

/**
 * @Author:刘平远
 * @Date：2019/12/3 11:14
 * @verson 1.0
 **/
@Data
public class UmsMember {
    //主键
    private String id;
    //外键
    private String memberLevelId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int status;
    private Date createTime;
    private String icon;
    private int gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private int sourceType;
    private int integration;
    private int growth;
    private int luckeyCount;
    private int historyIntegration;

}
