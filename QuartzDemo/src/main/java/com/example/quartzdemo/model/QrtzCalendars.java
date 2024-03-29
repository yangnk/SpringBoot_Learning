package com.example.quartzdemo.model;

import java.io.Serializable;

public class QrtzCalendars implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_calendars.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String schedName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_calendars.CALENDAR_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private String calendarName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column qrtz_calendars.CALENDAR
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private byte[] calendar;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_calendars.SCHED_NAME
     *
     * @return the value of qrtz_calendars.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getSchedName() {
        return schedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_calendars.SCHED_NAME
     *
     * @param schedName the value for qrtz_calendars.SCHED_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_calendars.CALENDAR_NAME
     *
     * @return the value of qrtz_calendars.CALENDAR_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public String getCalendarName() {
        return calendarName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_calendars.CALENDAR_NAME
     *
     * @param calendarName the value for qrtz_calendars.CALENDAR_NAME
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column qrtz_calendars.CALENDAR
     *
     * @return the value of qrtz_calendars.CALENDAR
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public byte[] getCalendar() {
        return calendar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column qrtz_calendars.CALENDAR
     *
     * @param calendar the value for qrtz_calendars.CALENDAR
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    public void setCalendar(byte[] calendar) {
        this.calendar = calendar;
    }
}