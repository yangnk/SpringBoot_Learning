package com.example.quartzdemo.mapper;

import com.example.quartzdemo.model.QrtzCronTriggers;
import com.example.quartzdemo.model.QrtzCronTriggersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzCronTriggersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int countByExample(QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByExample(QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName, @Param("triggerGroup") String triggerGroup);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insert(QrtzCronTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insertSelective(QrtzCronTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    List<QrtzCronTriggers> selectByExample(QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    QrtzCronTriggers selectByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName, @Param("triggerGroup") String triggerGroup);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExampleSelective(@Param("record") QrtzCronTriggers record, @Param("example") QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExample(@Param("record") QrtzCronTriggers record, @Param("example") QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKeySelective(QrtzCronTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qrtz_cron_triggers
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKey(QrtzCronTriggers record);
}