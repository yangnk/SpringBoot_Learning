package com.yangnk.mysqldemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User1 implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user1.id
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user1.user_name
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user1.password
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user1.sex
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user1
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user1.id
     *
     * @return the value of user1.id
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user1.id
     *
     * @param id the value for user1.id
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user1.user_name
     *
     * @return the value of user1.user_name
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user1.user_name
     *
     * @param userName the value for user1.user_name
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user1.password
     *
     * @return the value of user1.password
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user1.password
     *
     * @param password the value for user1.password
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user1.sex
     *
     * @return the value of user1.sex
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user1.sex
     *
     * @param sex the value for user1.sex
     *
     * @mbggenerated Wed Mar 22 20:40:58 CST 2023
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}