package com.yangnk.TCCSample1;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionalService {
    void tryOperation(Integer count, Integer experiment);

    void confirmOperation(Integer experiment);

    void cancelOperation(Integer count, Integer experiment);
}
