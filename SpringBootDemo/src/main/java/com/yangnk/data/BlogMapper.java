package com.yangnk.data;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
    @Select(value = "select * from blog")
    List<Blog> query();
}
