package com.seata.controller;

import com.seata.domain.Account;
import com.seata.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.math.BigDecimal;

@RestController
@RefreshScope
public class AccountController {
    @Resource
    private AccountService accountService;
    @Autowired
    private DataSource dataSource;

    @PostMapping("/account/decrease")
    @GlobalTransactional(rollbackFor = Exception.class)
    public String testDecrease(@RequestBody Account account){
        BigDecimal used = account.getUsed();
        Long userId = account.getUserId();
        String decrease = accountService.decrease(used, userId);
        int i = 10 / 0;
        return decrease;
    }
}
