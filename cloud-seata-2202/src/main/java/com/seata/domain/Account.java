package com.seata.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("account")
public class Account {
    @TableId
    private Long id;
    @TableField("user_id")
    private Long userId;
    @TableField("total")
    private BigDecimal total;
    @TableField("used")
    private BigDecimal used;
    @TableField("residue")
    private BigDecimal residue;
}
