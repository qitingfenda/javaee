package com.base.util.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;


/**
 * @author yhc
 * @create 2023-05-25 9:38
 */
@Data
public class TestBean {
    /**
     * 预测日期
     */
    private String predictDate;
    /**
     * 易单来客户id
     */
    private String infoId;
    /**
     * 易网客户id
     */
    private String customerId;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 预测下单时间(HH:mm前)
     */
    private String predictionTime;
    /**
     * 今日下单量(m²)
     */
    private BigDecimal todayOrderArea;
    /**
     * 预测偏差类型(今日无单:no_orders,订单流失:order_loss,有单未下:pending_orders,未反馈:no_feedback)
     */
    private String type;
    /**
     * 反馈记录
     */
    private String feedback;
}
