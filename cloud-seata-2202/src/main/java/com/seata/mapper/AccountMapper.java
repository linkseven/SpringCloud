package com.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AccountMapper extends BaseMapper<Account> {
    @Update("update account set used=#{money}+used,residue=total-used where user_id=#{userId}")
    boolean decrease(@Param("money") BigDecimal money, @Param("userId") Long userId);
}
