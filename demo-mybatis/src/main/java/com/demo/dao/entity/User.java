package com.demo.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色id，角色表主键
     */
    private Integer roleId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 账号
     */
    private String accountNo;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别：0-未知，1-男，2-女
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 状态：0-锁定，1-正常
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

}
