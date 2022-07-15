package com.yangnk.hfn.service;

import com.yangnk.hfn.entity.UserTbl;
import com.yangnk.hfn.pojo.vo.UserVO;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 15:34
 **/
public interface UserService {
    UserTbl getUser(String userName);

    /**
     * 将用户请求的验证码发送到用户手机，并且存入到有失效时长的redis中
     *
     * @param userName
     * @param telephone
     */
    void sendSmsCode(String userName, String telephone);

    /**
     * 根据用户名查询手机验证码（smsCode）
     *
     * @param userName
     * @return
     */
    String getSmsCode(String userName);

    /**
     * 保存用户信息
     *
     * @param userVO
     */
    void saveUserInfo(UserVO userVO);
}
