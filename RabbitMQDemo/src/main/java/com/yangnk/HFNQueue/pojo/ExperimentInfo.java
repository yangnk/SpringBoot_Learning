package com.yangnk.HFNQueue.pojo;

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
    private String experimentId;

    @JSONField(name = "networkId")
    private String networkId;

    @JSONField(name = "imageId")
    private String imageId;
}