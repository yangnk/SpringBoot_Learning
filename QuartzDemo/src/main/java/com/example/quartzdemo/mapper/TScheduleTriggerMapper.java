package com.example.quartzdemo.mapper;

import com.example.quartzdemo.model.TScheduleTrigger;
import com.example.quartzdemo.model.TScheduleTriggerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScheduleTriggerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int countByExample(TScheduleTriggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByExample(TScheduleTriggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insert(TScheduleTrigger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insertSelective(TScheduleTrigger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    List<TScheduleTrigger> selectByExample(TScheduleTriggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    TScheduleTrigger selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExampleSelective(@Param("record") TScheduleTrigger record, @Param("example") TScheduleTriggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExample(@Param("record") TScheduleTrigger record, @Param("example") TScheduleTriggerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKeySelective(TScheduleTrigger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKey(TScheduleTrigger record);


    List<TScheduleTrigger> listScheduleTrigger();

    void deleteByJobName(@Param("jobName") String jobName);
}