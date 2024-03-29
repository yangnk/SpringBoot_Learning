package com.example.quartzdemo.model;

import java.io.Serializable;

public class QrtzSimpleTriggers implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_simple_triggers.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String schedName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_simple_triggers.TRIGGER_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String triggerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_simple_triggers.TRIGGER_GROUP
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String triggerGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_simple_triggers.REPEAT_COUNT
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private Long repeatCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_simple_triggers.REPEAT_INTERVAL
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private Long repeatInterval;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_simple_triggers.TIMES_TRIGGERED
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private Long timesTriggered;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table qrtz_simple_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_simple_triggers.SCHED_NAME
     *
     * @return the value of qrtz_simple_triggers.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getSchedName() {
        return schedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_simple_triggers.SCHED_NAME
     *
     * @param schedName the value for qrtz_simple_triggers.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_simple_triggers.TRIGGER_NAME
     *
     * @return the value of qrtz_simple_triggers.TRIGGER_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_simple_triggers.TRIGGER_NAME
     *
     * @param triggerName the value for qrtz_simple_triggers.TRIGGER_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_simple_triggers.TRIGGER_GROUP
     *
     * @return the value of qrtz_simple_triggers.TRIGGER_GROUP
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getTriggerGroup() {
        return triggerGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_simple_triggers.TRIGGER_GROUP
     *
     * @param triggerGroup the value for qrtz_simple_triggers.TRIGGER_GROUP
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_simple_triggers.REPEAT_COUNT
     *
     * @return the value of qrtz_simple_triggers.REPEAT_COUNT
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public Long getRepeatCount() {
        return repeatCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_simple_triggers.REPEAT_COUNT
     *
     * @param repeatCount the value for qrtz_simple_triggers.REPEAT_COUNT
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setRepeatCount(Long repeatCount) {
        this.repeatCount = repeatCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_simple_triggers.REPEAT_INTERVAL
     *
     * @return the value of qrtz_simple_triggers.REPEAT_INTERVAL
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public Long getRepeatInterval() {
        return repeatInterval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_simple_triggers.REPEAT_INTERVAL
     *
     * @param repeatInterval the value for qrtz_simple_triggers.REPEAT_INTERVAL
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setRepeatInterval(Long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_simple_triggers.TIMES_TRIGGERED
     *
     * @return the value of qrtz_simple_triggers.TIMES_TRIGGERED
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public Long getTimesTriggered() {
        return timesTriggered;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_simple_triggers.TIMES_TRIGGERED
     *
     * @param timesTriggered the value for qrtz_simple_triggers.TIMES_TRIGGERED
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setTimesTriggered(Long timesTriggered) {
        this.timesTriggered = timesTriggered;
    }
}