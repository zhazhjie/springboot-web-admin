package com.web.admin;

import com.alibaba.fastjson.JSON;
import org.json.JSONArray;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskTest {

    @Test
    public void test() {
        long startTime = System.currentTimeMillis();
        BigDecimal consumerRate = new BigDecimal("0.008");
        BigDecimal refundFee = new BigDecimal("1");
        BigDecimal consumerQuotaLD = new BigDecimal("1000");
        BigDecimal consumerQuotaSL = new BigDecimal("20000");
        BigDecimal planRefundTotalAmount = new BigDecimal("20000");
        BigDecimal cardBalance = new BigDecimal("2500");
        int dayConsumeTimes = 3;
        int dayRefundTimes = 2;
        int refundDay = 10;
        int planTimes = dayRefundTimes * refundDay;
        String[] dateList = {"2019-10-01", "2019-10-02", "2019-10-03", "2019-10-04", "2019-10-05", "2019-10-06", "2019-10-07", "2019-10-08", "2019-10-09", "2019-10-10"};
        {
            BigDecimal realRefundTotalAmount = BigDecimal.ZERO;
            BigDecimal curCardBalance = cardBalance;
            for (int i = 0; i < planTimes; i++) {
                BigDecimal consumeAmount;
                if (curCardBalance.compareTo(consumerQuotaSL) > 0) {
                    consumeAmount = consumerQuotaSL;
                } else {
                    consumeAmount = curCardBalance.setScale(0, RoundingMode.DOWN);
                }
                BigDecimal serviceFee = consumeAmount.multiply(consumerRate).setScale(2, RoundingMode.UP).add(refundFee);
                curCardBalance = curCardBalance.subtract(serviceFee);
                realRefundTotalAmount = realRefundTotalAmount.add(consumeAmount.subtract(serviceFee));
            }
            if (realRefundTotalAmount.compareTo(planRefundTotalAmount) < 0) {
                System.out.println("卡内余额至少：" + cardBalance.divide(realRefundTotalAmount, 6, RoundingMode.DOWN).multiply(planRefundTotalAmount).setScale(0, RoundingMode.UP));
                return;
            }
        }
        PlanResultDTO planResult = new PlanResultDTO();
        {
            BigDecimal consumeTotalAmount = BigDecimal.ZERO;
            BigDecimal totalServiceFee = BigDecimal.ZERO;
            BigDecimal curCardBalance = cardBalance;
            List<PlanDTO> planList = new ArrayList<>();
            for (int i = 0; i < refundDay; i++) {
                PlanDTO planDTO = new PlanDTO();
                List<TaskDTO> taskList = new ArrayList<>();
                BigDecimal planConsumeAmount = BigDecimal.ZERO;
                BigDecimal planServiceFee = BigDecimal.ZERO;
                BigDecimal planCardBalance = curCardBalance;
                int planRefundTimes = dayRefundTimes;
                for (int j = 0; j < dayConsumeTimes; j++) {
                    long num = curCardBalance.divide(consumerQuotaLD, 0, RoundingMode.DOWN).longValue();
                    if(num<dayConsumeTimes||planCardBalance.compareTo(consumerQuotaLD) < 0){

                    }
                    if (j == 0 || (planCardBalance.compareTo(BigDecimal.ONE) < 0 && planRefundTimes > 0)) {
                        planCardBalance = curCardBalance;
                        taskList = new ArrayList<>();
                        planDTO = new PlanDTO();
                        planDTO.setTaskList(taskList);
                        planList.add(planDTO);
                        planRefundTimes--;
                    }
                    BigDecimal consumeAmount;
                    if (planCardBalance.compareTo(consumerQuotaLD) > 0) {
                        consumeAmount = consumerQuotaLD;
                    } else {
                        consumeAmount = planCardBalance.setScale(0, RoundingMode.DOWN);
                    }
                    BigDecimal serviceFee = consumeAmount.multiply(consumerRate).setScale(2, RoundingMode.UP);
                    curCardBalance = curCardBalance.subtract(serviceFee);
                    planConsumeAmount = planConsumeAmount.add(consumeAmount);
                    planServiceFee = planServiceFee.add(serviceFee);
                    planCardBalance = planCardBalance.subtract(consumeAmount);
                    TaskDTO taskDTO = new TaskDTO();
                    taskDTO.setConsumeAmount(consumeAmount);
                    taskDTO.setServiceFee(serviceFee);
                    taskDTO.setConsumeDate(dateList[i]);
                    taskDTO.setConsumeType(consumeAmount.compareTo(consumerQuotaLD) > 0 ? "商旅" : "落地");
                    taskList.add(taskDTO);
                    if (planCardBalance.compareTo(BigDecimal.ONE) < 0 || j == dayConsumeTimes - 1) {
                        planDTO.setPlanTime(dateList[i]);
                        planDTO.setConsumeAmount(planConsumeAmount);
                        planDTO.setServiceFee(planServiceFee.add(refundFee));
                        planDTO.setRefundAmount(planDTO.getConsumeAmount().subtract(planDTO.getServiceFee()));
                        consumeTotalAmount = consumeTotalAmount.add(planDTO.getConsumeAmount());
                        totalServiceFee = totalServiceFee.add(planDTO.getServiceFee());
                        if (j < dayConsumeTimes - 1 && planRefundTimes > 0) {
                            planConsumeAmount = BigDecimal.ZERO;
                            planServiceFee = BigDecimal.ZERO;
                        } else {
                            break;
                        }
                    }
                }
            }
            planResult.setConsumeTotalAmount(consumeTotalAmount);
            planResult.setTotalServiceFee(totalServiceFee);
            planResult.setRefundTotalAmount(consumeTotalAmount.subtract(totalServiceFee));
            planResult.setPlanList(planList);
        }
        System.out.println("还款计划：" + JSON.toJSONString(planResult));
//        if (planResult.getRefundTotalAmount().compareTo(planRefundTotalAmount) < 0) {
//            BigDecimal needAmount = planRefundTotalAmount.subtract(planResult.getRefundTotalAmount());
//            BigDecimal diffAmount = (cardBalance.compareTo(consumerQuotaSL) > 0 ? consumerQuotaSL : cardBalance).subtract(cardBalance.compareTo(consumerQuotaLD) > 0 ? consumerQuotaLD : cardBalance);
//            int resetNum = (int) needAmount.divide(diffAmount, 0, RoundingMode.UP).longValue();
//            List<PlanDTO> planList = planResult.getPlanList();
//            int planLen = planList.size();
//            BigDecimal refundTotalAmount = BigDecimal.ZERO;
//            BigDecimal totalServiceFee = BigDecimal.ZERO;
//            BigDecimal curCardBalance = cardBalance;
//            for (int i = 0; i < planLen; i++) {
//                PlanDTO plan = planList.get(i);
//                List<TaskDTO> taskList = plan.getTaskList();
//                if(dayRefundTimes==1){
//
//                }
//                BigDecimal consumeAmount;
//                if (i < resetNum) {
//                    consumeAmount = curCardBalance.compareTo(consumerQuotaSL) > 0 ? consumerQuotaSL : curCardBalance.setScale(0, RoundingMode.DOWN);
//                } else {
//                    consumeAmount = curCardBalance.compareTo(consumerQuotaLD) > 0 ? consumerQuotaLD : curCardBalance.setScale(0, RoundingMode.DOWN);
//                }
//                BigDecimal serviceFee = consumeAmount.multiply(consumerRate).setScale(2, RoundingMode.UP).add(refundFee);
//                curCardBalance = curCardBalance.subtract(serviceFee);
//                refundTotalAmount = refundTotalAmount.add(consumeAmount);
//                totalServiceFee = totalServiceFee.add(serviceFee);
//                planDTO.setConsumeAmount(consumeAmount);
//                planDTO.setServiceFee(serviceFee);
//                planDTO.setConsumeType(consumeAmount.compareTo(consumerQuotaLD) > 0 ? "商旅" : "落地");
//            }
//            planResult.setTotalServiceFee(totalServiceFee);
//            planResult.setRefundTotalAmount(refundTotalAmount);
//            System.out.println("新还款总额:" + planResult.getRefundTotalAmount().subtract(planResult.getTotalServiceFee()));
//            System.out.println("新任务:" + planList);
//        }
//        BigDecimal extraRefundAmount = planResult.getRefundTotalAmount().subtract(planResult.getTotalServiceFee()).subtract(planRefundTotalAmount);
//        if (extraRefundAmount.compareTo(BigDecimal.ZERO) > 0) {
//            BigDecimal refundTotalAmount = BigDecimal.ZERO;
//            BigDecimal totalServiceFee = BigDecimal.ZERO;
//            List<TaskDTO> planList = planResult.getplanList();
//            int planLen = planList.size();
//            for (int i = 0; i < planLen; i++) {
//                TaskDTO taskDTO = planList.get(i);
//                BigDecimal newConsumeAmount;
//                if (i == planLen - 1) {
//                    BigDecimal lastRefundAmount = planRefundTotalAmount.subtract(refundTotalAmount.subtract(totalServiceFee));
//                    newConsumeAmount = lastRefundAmount.divide(BigDecimal.ONE.subtract(consumerRate), 0, RoundingMode.UP).add(refundFee);
//                } else {
//                    BigDecimal realConsumeAmount = taskDTO.getConsumeAmount().subtract(taskDTO.getServiceFee());
//                    BigDecimal newRealConsumeAmount = realConsumeAmount.subtract(extraRefundAmount.multiply(new BigDecimal("0.05")));
//                    newConsumeAmount = newRealConsumeAmount.divide(BigDecimal.ONE.subtract(consumerRate), 0, RoundingMode.UP).add(refundFee);
//                }
//                BigDecimal serviceFee = newConsumeAmount.multiply(consumerRate).setScale(2, RoundingMode.UP).add(refundFee);
//                planList.get(i).setConsumeAmount(newConsumeAmount);
//                planList.get(i).setServiceFee(serviceFee);
//                planList.get(i).setConsumeType(newConsumeAmount.compareTo(consumerQuotaLD) > 0 ? "商旅" : "落地");
//                refundTotalAmount = refundTotalAmount.add(newConsumeAmount);
//                totalServiceFee = totalServiceFee.add(serviceFee);
//            }
//            planResult.setTotalServiceFee(totalServiceFee);
//            planResult.setRefundTotalAmount(refundTotalAmount);
//            System.out.println("新还款总额:" + planResult.getRefundTotalAmount().subtract(planResult.getTotalServiceFee()));
//            System.out.println("新任务:" + planList);
//        }
//
//        long endTime = System.currentTimeMillis();
//        System.out.print("用时：" + (endTime - startTime) + "ms");
    }

}
