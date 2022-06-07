package com.yangnk.web;

import com.yangnk.pojo.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-24 上午11:02
 **/

@RestController
public class SaveAccountController {

    @PostMapping("/saveAccount")
    public Object saveAccount(@RequestBody @Valid Account account){
//        this.saveAccount(account);
        System.out.println("");
        return "保存成功";
    }
}
