package com.example.quartzdemo.model;

import java.io.Serializable;

public class QrtzCronTriggers implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_cron_triggers.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String schedName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_cron_triggers.TRIGGER_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String triggerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_cron_triggers.TRIGGER_GROUP
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String triggerGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_cron_triggers.CRON_EXPRESSION
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String cronExpression;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_cron_triggers.TIME_ZONE_ID
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String timeZoneId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_cron_triggers.SCHED_NAME
     *
     * @return the value of qrtz_cron_triggers.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getSchedName() {
        return schedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_cron_triggers.SCHED_NAME
     *
     * @param schedName the value for qrtz_cron_triggers.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_cron_triggers.TRIGGER_NAME
     *
     * @return the value of qrtz_cron_triggers.TRIGGER_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_cron_triggers.TRIGGER_NAME
     *
     * @param triggerName the value for qrtz_cron_triggers.TRIGGER_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_cron_triggers.TRIGGER_GROUP
     *
     * @return the value of qrtz_cron_triggers.TRIGGER_GROUP
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getTriggerGroup() {
        return triggerGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_cron_triggers.TRIGGER_GROUP
     *
     * @param triggerGroup the value for qrtz_cron_triggers.TRIGGER_GROUP
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_cron_triggers.CRON_EXPRESSION
     *
     * @return the value of qrtz_cron_triggers.CRON_EXPRESSION
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_cron_triggers.CRON_EXPRESSION
     *
     * @param cronExpression the value for qrtz_cron_triggers.CRON_EXPRESSION
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_cron_triggers.TIME_ZONE_ID
     *
     * @return the value of qrtz_cron_triggers.TIME_ZONE_ID
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_cron_triggers.TIME_ZONE_ID
     *
     * @param timeZoneId the value for qrtz_cron_triggers.TIME_ZONE_ID
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}