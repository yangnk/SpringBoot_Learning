package com.yangnk.TCCSample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    @Autowired
    private TransactionalService transactionalService;

    public void doBusiness(Integer count, Integer experiment) {
        try {
            transactionalService.tryOperation(count, experiment);
        } catch (Exception e) {
            transactionalService.cancelOperation(count,experiment);
            // 执行 try 操作失败，回滚事务
            throw new RuntimeException(e);
        }
        // 确认订单
        transactionalService.confirmOperation(experiment);
    }
}
