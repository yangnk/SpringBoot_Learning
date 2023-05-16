package com.yangnk.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangnk.mybatisplusdemo.domain.Student;
import com.yangnk.mybatisplusdemo.service.StudentService;
import com.yangnk.mybatisplusdemo.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author yangnk
* @description 针对表【student】的数据库操作Service实现
* @createDate 2023-05-16 01:02:39
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




