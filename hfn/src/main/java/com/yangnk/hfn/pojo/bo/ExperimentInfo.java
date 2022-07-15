package com.yangnk.hfn.pojo.bo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * ${试验信息}
 *
 * @author yangningkai
 * @create 2022-05-08 14:56
 **/
@Data
public class ExperimentInfo {
    @JSONField(name = "experimentId")
    public String experimentId;

    @JSONField(name = "networkId")
    public String networkId;

    @JSONField(name = "imageId")
    public String imageId;

    @JSONField(name = "priority")
    public int priority;
}