package com.seata.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.domain.Account;
import com.seata.mapper.AccountMapper;
import com.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public String decrease(BigDecimal money, Long userId) {
        boolean decrease = accountMapper.decrease(money, userId);
        log.debug("" + decrease);
        return "ok";
    }
}
