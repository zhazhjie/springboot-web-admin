package com.web.admin;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PlanResultDTO implements Serializable {
    private BigDecimal refundTotalAmount;
    private BigDecimal consumeTotalAmount;
    private BigDecimal totalServiceFee;
    private List<PlanDTO> planList;
}
