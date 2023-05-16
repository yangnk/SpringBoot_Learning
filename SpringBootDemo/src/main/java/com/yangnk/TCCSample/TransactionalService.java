package com.yangnk.TCCSample;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TransactionalService {
    void tryOperation(String id);

    void confirmOperation(String id);

    void cancelOperation(String id);
}
