package com.web.admin;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PlanDTO implements Serializable {
    private String planTime;
    private BigDecimal refundAmount;
    private BigDecimal consumeAmount;
    private BigDecimal serviceFee;
    private List<TaskDTO> taskList;
}
