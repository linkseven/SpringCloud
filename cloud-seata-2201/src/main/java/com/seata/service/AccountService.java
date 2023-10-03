package com.seata.service;

import com.seata.domain.Account;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cloud-seata-account")
public interface AccountService {
    @PostMapping("/account/decrease")
    public String testDecrease(@RequestBody Account account);
}
