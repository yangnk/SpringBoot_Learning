package com.yangnk.hfn.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Image implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.id
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.imageName
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    private String imagename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.imageAliasName
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    private String imagealiasname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.imageInfo
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    private String imageinfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table image
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.id
     *
     * @return the value of image.id
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.id
     *
     * @param id the value for image.id
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.imageName
     *
     * @return the value of image.imageName
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public String getImagename() {
        return imagename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.imageName
     *
     * @param imagename the value for image.imageName
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.imageAliasName
     *
     * @return the value of image.imageAliasName
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public String getImagealiasname() {
        return imagealiasname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.imageAliasName
     *
     * @param imagealiasname the value for image.imageAliasName
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public void setImagealiasname(String imagealiasname) {
        this.imagealiasname = imagealiasname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.imageInfo
     *
     * @return the value of image.imageInfo
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public String getImageinfo() {
        return imageinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.imageInfo
     *
     * @param imageinfo the value for image.imageInfo
     *
     * @mbggenerated Sun Apr 30 16:26:24 CST 2023
     */
    public void setImageinfo(String imageinfo) {
        this.imageinfo = imageinfo;
    }
}