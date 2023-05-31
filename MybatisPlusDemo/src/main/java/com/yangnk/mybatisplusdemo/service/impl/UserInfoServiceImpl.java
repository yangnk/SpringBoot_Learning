package com.yangnk.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangnk.mybatisplusdemo.domain.UserInfo;
import com.yangnk.mybatisplusdemo.service.UserInfoService;
import com.yangnk.mybatisplusdemo.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author yangnk
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2023-05-16 19:54:13
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




