package com.example.quartzdemo.mapper;

import com.example.quartzdemo.model.TScheduleTriggerParam;
import com.example.quartzdemo.model.TScheduleTriggerParamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TScheduleTriggerParamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int countByExample(TScheduleTriggerParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByExample(TScheduleTriggerParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int deleteByPrimaryKey(Integer paramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insert(TScheduleTriggerParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int insertSelective(TScheduleTriggerParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    List<TScheduleTriggerParam> selectByExample(TScheduleTriggerParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    TScheduleTriggerParam selectByPrimaryKey(Integer paramId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExampleSelective(@Param("record") TScheduleTriggerParam record, @Param("example") TScheduleTriggerParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByExample(@Param("record") TScheduleTriggerParam record, @Param("example") TScheduleTriggerParamExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKeySelective(TScheduleTriggerParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_schedule_trigger_param
     *
     * @mbggenerated Tue Aug 22 11:34:05 CST 2023
     */
    int updateByPrimaryKey(TScheduleTriggerParam record);

    List<TScheduleTriggerParam> listScheduleTriggerParam(Integer id);
}