package com.yangnk.hfn.common.adapter;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.yangnk.hfn.common.task.ExperimentTask;
import com.yangnk.hfn.pojo.bo.ExperimentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午6:34
 **/
@Component("hfnMessageListenerAdapter")
@Slf4j
public class HfnMessageListenerAdapter extends MessageListenerAdapter {
    @Autowired
    @Qualifier(value = "HfnThreadPoolExecutor")
    ThreadPoolExecutor threadPoolExecutor;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        log.info("=================HfnMessageListenerAdapter.message:{}================", message.toString());

        String experimentStr = new String(message.getBody());
        channel.basicQos(0, 1, false);
        try {
            for (int i = 0; i < 3; i++) {
                ExperimentInfo experimentInfo = JSONObject.parseObject(experimentStr, ExperimentInfo.class);
                Future<String> result = threadPoolExecutor.submit(new ExperimentTask(experimentInfo));
                if (result.get().equals("success")) {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
                    log.info("=================ack success================");
                    return;
                }
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                log.info("=================ack false================");
            }
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}