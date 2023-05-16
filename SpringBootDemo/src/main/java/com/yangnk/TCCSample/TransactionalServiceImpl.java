package com.yangnk.TCCSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public void tryOperation(String id) {
        // 获取账户信息和订单信息
        Account account = accountMapper.selectById(id);
        Order order = orderMapper.selectById(id);

        // 检查账户余额是否足够支付订单金额
        if (account.getBalance() < order.getAmount()) {
            throw new RuntimeException("账户余额不足");
        }

        // 扣减账户余额
        account.setBalance(account.getBalance() - order.getAmount());
        accountMapper.updateById(account);

        // 将订单状态设置为 "已支付"
        order.setStatus("PAID");
        orderMapper.updateById(order);
    }

    @Override
    public void confirmOperation(String id) {
        // 将订单状态设置为 "已确认"
        Order order = orderMapper.selectById(id);
        order.setStatus("CONFIRMED");
        orderMapper.updateById(order);
    }

    @Override
    public void cancelOperation(String id) {
        // 将订单状态设置为 "已取消"，并返还账户余额
        Account account = accountMapper.selectById(id);
        Order order = orderMapper.selectById(id);

        account.setBalance(account.getBalance() + order.getAmount());
        accountMapper.updateById(account);

        order.setStatus("CANCELLED");
        orderMapper.updateById(order);
    }
}
