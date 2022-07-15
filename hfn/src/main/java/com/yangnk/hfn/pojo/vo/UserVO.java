package com.yangnk.hfn.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-09 16:19
 **/
@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1439071229832032112L;

    private String userName;
    private String password;
    private String sex;
    private String age;
}
