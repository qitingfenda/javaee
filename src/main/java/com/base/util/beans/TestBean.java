package com.base.util.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


/**
 * @author yhc
 * @create 2023-05-25 9:38
 */
@Data
public class TestBean {

    @ApiModelProperty("抬头id")
    private String titleId;

    @ApiModelProperty("抬头名称")
    @Size(max = 30,message = "抬头名最多输入30位")
    @NotBlank(message = "抬头不能为空")
    private String invoiceTitleName;

    @ApiModelProperty("税号")
    @Size(max = 30, message = "税号最多输入30位")
    @NotBlank(message = "税号不能为空")
    private String dutyParagraph;

    @ApiModelProperty("地址")
    @Size(max = 100,message = "地址最多输入100位")
    @NotBlank(message = "地址不能为空")
    private String registeredAddress;

    @ApiModelProperty("电话")
    @Size(max = 30,message = "电话最多输入30位")
    @NotBlank(message = "电话不能为空")
    private String phone;

    @ApiModelProperty("开户行")
    @NotBlank(message = "开户行不能为空")
    @Size(max = 100,message = "开户行最多输入100位")
    private String accountBank;

    @ApiModelProperty("卡号")
    @Size(max = 30,message = "账户最多输入30位")
    @NotBlank(message = "卡号不能为空")
    private String bankCard;

    @ApiModelProperty("用户认证名")
    private String customerName;

    @ApiModelProperty("用户手机号")
    private String customerPhone;

    @ApiModelProperty("销货单位的id")
    private String salesUnitId;
}
