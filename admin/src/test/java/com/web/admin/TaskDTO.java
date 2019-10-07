package com.web.admin;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TaskDTO implements Serializable {
    private BigDecimal consumeAmount;
    private BigDecimal serviceFee;
    private String consumeDate;
    private String consumeType;
}
