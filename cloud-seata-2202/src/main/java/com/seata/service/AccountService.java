package com.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.domain.Account;

import java.math.BigDecimal;

public interface AccountService extends IService<Account> {
    String decrease(BigDecimal money, Long userId);
}
