package com.mayc.demo.domain;

/**
 * @author mayc
 * @description 用户模型
 * @return ${return_type}
 * @Company 久远银海湖北事业部
 * @ 2018/3/1
 */
public class User {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
