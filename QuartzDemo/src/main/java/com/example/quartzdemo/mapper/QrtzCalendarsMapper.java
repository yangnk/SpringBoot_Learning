package com.example.quartzdemo.mapper;

import com.example.quartzdemo.model.QrtzCalendars;
import com.example.quartzdemo.model.QrtzCalendarsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzCalendarsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int countByExample(QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByExample(QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("calendarName") String calendarName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insert(QrtzCalendars record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insertSelective(QrtzCalendars record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    List<QrtzCalendars> selectByExampleWithBLOBs(QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    List<QrtzCalendars> selectByExample(QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    QrtzCalendars selectByPrimaryKey(@Param("schedName") String schedName, @Param("calendarName") String calendarName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExampleSelective(@Param("record") QrtzCalendars record, @Param("example") QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExampleWithBLOBs(@Param("record") QrtzCalendars record, @Param("example") QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExample(@Param("record") QrtzCalendars record, @Param("example") QrtzCalendarsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKeySelective(QrtzCalendars record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_calendars
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKeyWithBLOBs(QrtzCalendars record);
}