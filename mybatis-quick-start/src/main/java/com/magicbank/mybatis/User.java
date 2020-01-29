package com.magicbank.mybatis;

/**
 * @program: demo
 * @description: 用户
 * @author: wutao
 * @create: 2020/01/29 18:35
 **/
public class User {
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;


    /**
     * mobile
     */
    private String mobile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
