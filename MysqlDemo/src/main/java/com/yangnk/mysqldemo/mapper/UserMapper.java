package com.yangnk.mysqldemo.mapper;

import com.yangnk.mysqldemo.entity.User;
import com.yangnk.mysqldemo.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbggenerated Thu Apr 07 22:47:47 CST 2022
     */
    int updateByPrimaryKey(User record);
}