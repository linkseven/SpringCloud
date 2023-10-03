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
@TableName("t_order")
public class Order {
    @TableId
    private Long id;
    @TableField("user_id")
    private Long userId;
    @TableField("product_id")
    private Long productId;
    @TableField("count")
    private Integer count;
    @TableField("money")
    private BigDecimal money;
    @TableField("status")
    private Integer status;
}
