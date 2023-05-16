package com.yangnk.TCCSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    @Autowired
    private TransactionalService transactionalService;

//    @GlobalTransactional(timeoutMills = 300000)
    public void doBusiness(String id) {
        try {
            transactionalService.tryOperation(id);
        } catch (Exception e) {
            // 执行 try 操作失败，回滚事务
            throw new RuntimeException(e);
        }

        // 确认订单
        transactionalService.confirmOperation(id);
    }
}
