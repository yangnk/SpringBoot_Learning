package com.yangnk.hfn.myTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.remoting.RemoteAccessException;

@Slf4j
public class RetryDemoTask {


    /**
     * 重试方法
     * @return
     */
    public static boolean retryTask(String param)  {
        log.info("收到了请求参数为：{}", param);
        int randomInt = RandomUtils.nextInt(0, 11);
        log.info("生成的随机数为：{}", randomInt);

        if (randomInt < 2) {
            log.info("创建虚拟机失败");
            throw new RemoteAccessException("创建虚拟机失败");
        } else {
            log.info("创建虚拟机成功");
            return true;
        }
    }

}