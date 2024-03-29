package com.example.quartzdemo.model;

import java.io.Serializable;

public class TScheduleTriggerParam implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_trigger_param.param_id
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private Integer paramId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_trigger_param.name
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_trigger_param.value
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_schedule_trigger_param.schedule_trigger_id
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private Integer scheduleTriggerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_trigger_param.param_id
     *
     * @return the value of t_schedule_trigger_param.param_id
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public Integer getParamId() {
        return paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_trigger_param.param_id
     *
     * @param paramId the value for t_schedule_trigger_param.param_id
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_trigger_param.name
     *
     * @return the value of t_schedule_trigger_param.name
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_trigger_param.name
     *
     * @param name the value for t_schedule_trigger_param.name
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_trigger_param.value
     *
     * @return the value of t_schedule_trigger_param.value
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_trigger_param.value
     *
     * @param value the value for t_schedule_trigger_param.value
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_schedule_trigger_param.schedule_trigger_id
     *
     * @return the value of t_schedule_trigger_param.schedule_trigger_id
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public Integer getScheduleTriggerId() {
        return scheduleTriggerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_schedule_trigger_param.schedule_trigger_id
     *
     * @param scheduleTriggerId the value for t_schedule_trigger_param.schedule_trigger_id
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setScheduleTriggerId(Integer scheduleTriggerId) {
        this.scheduleTriggerId = scheduleTriggerId;
    }
}