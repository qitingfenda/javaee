package com.base.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yhc
 * @create 2023-08-23 15:35
 */
@Data
public class TestModel {


    /**
     * 期间费用及税费(万元)
     */
    @ApiModelProperty(value = "期间费用及税费(万元)")
    private String periodFeesAndTaxes;

    /**
     * 营业外收入(万元)
     */
    @ApiModelProperty(value = "营业外收入(万元)")
    private String nonOperatingIncome;

    /**
     * 营业外支出(万元)
     */
    @ApiModelProperty(value = "营业外支出(万元)")
    private String nonOperatingExpenses;

    /**
     * 营业外利润(万元)
     */
    @ApiModelProperty(value = "营业外利润(万元)")
    private String nonOperatingProfit;

    /**
     * 薪酬总额(万元)
     */
    @ApiModelProperty(value = "薪酬总额(万元)")
    private String totalCompensation;

    /**
     * 单位薪酬(元/平方米)
     */
    @ApiModelProperty(value = "单位薪酬(元/平方米)")
    private String unitSalary;

    /**
     * 利润总额(万元)
     */
    @ApiModelProperty(value = "利润总额(万元)")
    private String totalProfit;

    /**
     * 所得税(万元)
     */
    @ApiModelProperty(value = "所得税(万元)")
    private String incomeTax;

    /**
     * 净利润(万元)
     */
    @ApiModelProperty(value = "净利润(万元)")
    private String netProfit;

    /**
     * 净利率(%)
     */
    @ApiModelProperty(value = "净利率(%)")
    private String netProfitMargin;

    /**
     * 报表-原纸成本占比-原纸价格变化趋势-近期采购价格(元/吨)
     */
    @ApiModelProperty(value = "报表-原纸成本占比-原纸价格变化趋势-近期采购价格(元/吨)")
    private String paperPurchasePrice;

    /**
     * 报表-原纸成本占比-原纸价格变化趋势-历史库存价格(元/吨)
     */
    @ApiModelProperty(value = "报表-原纸成本占比-原纸价格变化趋势-历史库存价格(元/吨)")
    private String paperInventoryPrice;

    /**
     * 报表-原纸成本占比-原纸价格变化趋势-市场价格(元/吨)
     */
    @ApiModelProperty(value = "报表-原纸成本占比-原纸价格变化趋势-市场价格(元/吨)")
    private String paperMarketPrice;

    /**
     * 报表-原纸成本占比-原纸利用率及损耗分析-修边率(%)
     */
    @ApiModelProperty(value = "报表-原纸成本占比-原纸利用率及损耗分析-修边率(%)")
    private String paperTrimmingRate;

    /**
     * 报表-原纸成本占比-原纸利用率及损耗分析-其他(%)
     */
    @ApiModelProperty(value = "报表-原纸成本占比-原纸利用率及损耗分析-其他(%)")
    private String paperOtherRate;

    /**
     * 报表-单位薪酬-员工人数(人)
     */
    @ApiModelProperty(value = "报表-单位薪酬-员工人数(人)")
    private String numberOfEmployee;

    /**
     * 营业收入-价税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-价税合计(万元)")
    private String operatingRevenueTotalTaxPrice;

    /**
     * 营业收入-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-不含税合计(万元)")
    private String operatingRevenueTotalExcludeTax;

    /**
     * 营业收入-纸板收入-日均接单量(万平方米)
     */
    @ApiModelProperty(value = "营业收入-纸板收入-日均接单量(万平方米)")
    private String dayAvgArea;

    /**
     * 营业收入-纸板收入-接单天数(天)
     */
    @ApiModelProperty(value = "营业收入-纸板收入-接单天数(天)")
    private String orderDay;

    /**
     * 营业收入-纸板收入-销售面积(万平方米)
     */
    @ApiModelProperty(value = "营业收入-纸板收入-销售面积(万平方米)")
    private String salesArea;

    /**
     * 营业收入-纸板收入-销售单价(元/平方米)
     */
    @ApiModelProperty(value = "营业收入-纸板收入-销售单价(元/平方米)")
    private String salesPrice;

    /**
     * 营业收入-纸板收入-价税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-纸板收入-价税合计(万元)")
    private String cardboardRevenueTotalTaxPrice;

    /**
     * 营业收入-纸板收入-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-纸板收入-不含税合计(万元)")
    private String cardboardRevenueTotalExcludeTax;

    /**
     * 营业收入-销售折让-折让比例(%)
     */
    @ApiModelProperty(value = "营业收入-销售折让-折让比例(%)")
    private String discountRatio;

    /**
     * 营业收入-销售折让-返利后单价(元/平方米)
     */
    @ApiModelProperty(value = "营业收入-销售折让-返利后单价(元/平方米)")
    private String unitPriceAfterRebate;

    /**
     * 营业收入-销售折让-价税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-销售折让-价税合计(万元)")
    private String salesAllowanceTotalTaxPrice;

    /**
     * 营业收入-销售折让-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-销售折让-不含税合计(万元)")
    private String salesAllowanceTotalExcludeTax;

    /**
     * 营业收入-废纸收入-废纸单价(万元/吨)
     */
    @ApiModelProperty(value = "营业收入-废纸收入-废纸单价(万元/吨)")
    private String wastePaperUnit;

    /**
     * 营业收入-废纸收入-原纸利用率(%)
     */
    @ApiModelProperty(value = "营业收入-废纸收入-原纸利用率(%)")
    private String basePaperUtilizationRate;

    /**
     * 营业收入-废纸收入-废纸重量(万元/吨)
     */
    @ApiModelProperty(value = "营业收入-废纸收入-废纸重量(万元/吨)")
    private String wastePaperWeight;

    /**
     * 营业收入-废纸收入-价税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-废纸收入-价税合计(万元)")
    private String wastePaperRevenueTotalTaxPrice;

    /**
     * 营业收入-废纸收入-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业收入-废纸收入-不含税合计(万元)")
    private String wastePaperRevenueTotalExcludeTax;


    /**
     * 营业成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-价税合计(万元)")
    private String operatingCostTotalTaxPrice;

    /**
     * 营业成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-不含税合计(万元)")
    private String operatingCostTotalExcludeTax;

    /**
     * 营业成本-单位营业成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-单位营业成本(元/平方米)")
    private String unitOperatingCost;

    /**
     * 营业成本-纸板生产成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-单位成本(元/平方米)")
    private String cardboardProductionCostUnitCost;

    /**
     * 营业成本-纸板生产成本-价税合计(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-价税合计(元/平方米)")
    private String cardboardProductionCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-不含税合计(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-不含税合计(元/平方米)")
    private String cardboardProductionCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-原纸成本-纸板克重(克)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-纸板克重(克)")
    private String cardboardWeight;

    /**
     * 营业成本-纸板生产成本-原纸成本-销售面积与下料面积差异率(%)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-销售面积与下料面积差异率(%)")
    private String difRateSalesAreaCuttingArea;

    /**
     * 营业成本-纸板生产成本-原纸成本-原纸重量(吨)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-原纸重量(吨)")
    private String paperWeight;

    /**
     * 营业成本-纸板生产成本-原纸成本-原纸单价(万元/吨)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-原纸单价(万元/吨)")
    private String paperUnitPrice;

    /**
     * 营业成本-纸板生产成本-原纸成本-原纸单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-原纸单位成本(元/平方米)")
    private String paperUnitCost;

    /**
     * 营业成本-纸板生产成本-原纸成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-价税合计(万元)")
    private String paperCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-原纸成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-原纸成本-不含税合计(万元)")
    private String paperCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-淀粉成本-淀粉单价(万元/吨)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-淀粉成本-淀粉单价(万元/吨)")
    private String starchUnitPrice;

    /**
     * 营业成本-纸板生产成本-淀粉成本-平均淀粉用量(克/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-淀粉成本-平均淀粉用量(克/平方米)")
    private String avgStarchDosage;

    /**
     * 营业成本-纸板生产成本-淀粉成本-淀粉用量(吨)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-淀粉成本-淀粉用量(吨)")
    private String starchDosage;

    /**
     * 营业成本-纸板生产成本-淀粉成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-淀粉成本-价税合计(万元)")
    private String starchCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-淀粉成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-淀粉成本-不含税合计(万元)")
    private String starchCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-淀粉成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-淀粉成本-单位成本(元/平方米)")
    private String starchCostUnitCost;

    /**
     * 营业成本-纸板生产成本-硼砂成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-硼砂成本-单位成本(元/平方米)")
    private String boraxCostUnitCost;

    /**
     * 营业成本-纸板生产成本-硼砂成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-硼砂成本-价税合计(万元)")
    private String boraxCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-硼砂成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-硼砂成本-不含税合计(万元)")
    private String boraxCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-烧碱成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-烧碱成本-单位成本(元/平方米)")
    private String causticSodaCostUnitCost;

    /**
     * 营业成本-纸板生产成本-烧碱成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-烧碱成本-价税合计(万元)")
    private String causticSodaCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-烧碱成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-烧碱成本-不含税合计(万元)")
    private String causticSodaCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-添加剂成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-添加剂成本-单位成本(元/平方米)")
    private String additiveCostUnitCost;

    /**
     * 营业成本-纸板生产成本-添加剂成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-添加剂成本-价税合计(万元)")
    private String additiveCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-添加剂成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-添加剂成本-不含税合计(万元)")
    private String additiveCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-胶水成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-胶水成本-单位成本(元/平方米)")
    private String glueCostUnitCost;

    /**
     * 营业成本-纸板生产成本-胶水成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-胶水成本-价税合计(万元)")
    private String glueCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-胶水成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-胶水成本-不含税合计(万元)")
    private String glueCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-蒸汽成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-蒸汽成本-单位成本(元/平方米)")
    private String steamCostUnitCost;

    /**
     * 营业成本-纸板生产成本-蒸汽成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-蒸汽成本-价税合计(万元)")
    private String steamCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-蒸汽成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-蒸汽成本-不含税合计(万元)")
    private String steamCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-水费成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-水费成本-单位成本(元/平方米)")
    private String waterCostUnitCost;

    /**
     * 营业成本-纸板生产成本-水费成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-水费成本-价税合计(万元)")
    private String waterCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-水费成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-水费成本-不含税合计(万元)")
    private String waterCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-电费成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-电费成本-单位成本(元/平方米)")
    private String electricityCostUnitCost;

    /**
     * 营业成本-纸板生产成本-电费成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-电费成本-价税合计(万元)")
    private String electricityCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-电费成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-电费成本-不含税合计(万元)")
    private String electricityCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-水电费-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-水电费-单位成本(元/平方米)")
    private String waterElectricityExpensesUnitCost;

    /**
     * 营业成本-纸板生产成本-水电费-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-水电费-价税合计(万元)")
    private String waterElectricityExpensesTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-水电费-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-水电费-不含税合计(万元)")
    private String waterElectricityExpensesTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-修理费成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-修理费成本-单位成本(元/平方米)")
    private String repairCostUnitCost;

    /**
     * 营业成本-纸板生产成本-修理费成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-修理费成本-价税合计(万元)")
    private String repairCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-修理费成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-修理费成本-不含税合计(万元)")
    private String repairCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-易耗品成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-易耗品成本-单位成本(元/平方米)")
    private String consumablesCostUnitCost;

    /**
     * 营业成本-纸板生产成本-易耗品成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-易耗品成本-价税合计(万元)")
    private String consumablesCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-易耗品成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-易耗品成本-不含税合计(万元)")
    private String consumablesCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-其他成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-其他成本-单位成本(元/平方米)")
    private String otherCostUnitCost;

    /**
     * 营业成本-纸板生产成本-其他成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-其他成本-价税合计(万元)")
    private String otherCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-其他成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-其他成本-不含税合计(万元)")
    private String otherCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-人工成本-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-人工成本-单位成本(元/平方米)")
    private String laborCostUnitCost;

    /**
     * 营业成本-纸板生产成本-人工成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-人工成本-价税合计(万元)")
    private String laborCostTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-人工成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-人工成本-不含税合计(万元)")
    private String laborCostTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-租金-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-租金-价税合计(万元)")
    private String rentTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-租金-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-租金-不含税合计(万元)")
    private String rentTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-折旧-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-折旧-价税合计(万元)")
    private String depreciationTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-折旧-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-折旧-不含税合计(万元)")
    private String depreciationTotalExcludeTax;

    /**
     * 营业成本-纸板生产成本-租金&折旧-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-租金&折旧-价税合计(万元)")
    private String rentDepreciationTotalTaxPrice;

    /**
     * 营业成本-纸板生产成本-租金&折旧-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-纸板生产成本-租金&折旧-不含税合计(万元)")
    private String rentDepreciationTotalExcludeTax;

    /**
     * 营业成本-运输成本-运费单价(元/平方米)
     */
    @ApiModelProperty(value = "营业成本-运输成本-运费单价(元/平方米)")
    private String freightUnitPrice;

    /**
     * 营业成本-运输成本-运输面积(万平方米)
     */
    @ApiModelProperty(value = "营业成本-运输成本-运输面积(万平方米)")
    private String transportationArea;

    /**
     * 营业成本-运输成本-价税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-运输成本-价税合计(万元)")
    private String transportCostTotalTaxPrice;

    /**
     * 营业成本-运输成本-不含税合计(万元)
     */
    @ApiModelProperty(value = "营业成本-运输成本-不含税合计(万元)")
    private String transportCostTotalExcludeTax;

    /**
     * 报表-运输成本-运费结构分析-线下补贴(万元)
     */
    @ApiModelProperty(value = "报表-运输成本-运费结构分析-线下补贴(万元)")
    private String freightOfflineSubsidies;

    /**
     * 报表-运输成本-运费结构分析-超家数费(元/平方米)
     */
    @ApiModelProperty(value = "报表-运输成本-运费结构分析-超家数费(元/平方米)")
    private String freightExcessDelivery;

    /**
     * 报表-蒸汽成本-蒸汽用量(吨)
     */
    @ApiModelProperty(value = "报表-蒸汽成本-蒸汽用量(吨)")
    private String steamCostConsumption;

    /**
     * 报表-蒸汽成本-天然气用量(吨)
     */
    @ApiModelProperty(value = "报表-蒸汽成本-天然气用量(吨)")
    private String naturalGasConsumption;


    /**
     * 毛利额-毛利额(万元)
     */
    @ApiModelProperty(value = "毛利额-毛利额(万元)")
    private String grossProfitAmount;

    /**
     * 毛利额-毛利率(%)
     */
    @ApiModelProperty(value = "毛利额-毛利率(%)")
    private String grossMargin;

    /**
     * 毛利额-加工费(元/平方米)
     */
    @ApiModelProperty(value = "毛利额-加工费(元/平方米)")
    private String machiningCost;

    /**
     * 毛利额-加工费总额(万元)
     */
    @ApiModelProperty(value = "毛利额-加工费总额(万元)")
    private String totalMachiningCost;

    /**
     * 毛利额-加工费占比(%)
     */
    @ApiModelProperty(value = "毛利额-加工费占比(%)")
    private String machiningCostProportion;

    /**
     * 毛利额-原纸成本占比(%)
     */
    @ApiModelProperty(value = "毛利额-原纸成本占比(%)")
    private String paperCostProportion;

    /**
     * 毛利额-供销差额(元/平方米)
     */
    @ApiModelProperty(value = "毛利额-供销差额(元/平方米)")
    private String supplyAndSalesDif;


    /**
     * 税费-增值税(万元)
     */
    @ApiModelProperty(value = "税费-增值税(万元)")
    private String valueAddedTax;

    /**
     * 税费-附加税(万元)
     */
    @ApiModelProperty(value = "税费-附加税(万元)")
    private String additionalTax;

    /**
     * 税费-印花税(万元)
     */
    @ApiModelProperty(value = "税费-印花税(万元)")
    private String stampDuty;

    /**
     * 税费-其他税费(万元)
     */
    @ApiModelProperty(value = "税费-其他税费(万元)")
    private String otherTaxes;

    /**
     * 税费-税费合计(万元)
     */
    @ApiModelProperty(value = "税费-税费合计(万元)")
    private String totalTaxes;

    /**
     * 税费-税负率(%)
     */
    @ApiModelProperty(value = "税费-税负率(%)")
    private String taxBearingRate;


    /**
     * 销售费用-销售薪酬(万元)
     */
    @ApiModelProperty(value = "销售费用-销售薪酬(万元)")
    private String salesCompensation;

    /**
     * 报表-销售费用-销售薪酬-单位成本(元/平方米)
     */
    @ApiModelProperty(value = "报表-销售费用-销售薪酬-单位成本(元/平方米)")
    private String salesCompensationUnitCost;

    /**
     * 管理费用-人工费用(万元)
     */
    @ApiModelProperty(value = "管理费用-人工费用(万元)")
    private String overheadLaborCosts;

    /**
     * 管理费用-福利费(万元)
     */
    @ApiModelProperty(value = "管理费用-福利费(万元)")
    private String overheadWelfareCosts;

    /**
     * 管理费用-办公费(万元)
     */
    @ApiModelProperty(value = "管理费用-办公费(万元)")
    private String overheadOfficeExpenses;

    /**
     * 管理费用-交通费(万元)
     */
    @ApiModelProperty(value = "管理费用-交通费(万元)")
    private String overheadTransportationExpenses;

    /**
     * 管理费用-招待费(万元)
     */
    @ApiModelProperty(value = "管理费用-招待费(万元)")
    private String overheadEntertainmentExpenses;

    /**
     * 管理费用-水电费(万元)
     */
    @ApiModelProperty(value = "管理费用-水电费(万元)")
    private String overheadWaterElectricityExpenses;

    /**
     * 管理费用-差旅费(万元)
     */
    @ApiModelProperty(value = "管理费用-差旅费(万元)")
    private String overheadTravelExpenses;

    /**
     * 管理费用-租金(万元)
     */
    @ApiModelProperty(value = "管理费用-租金(万元)")
    private String overheadRent;

    /**
     * 管理费用-其他(万元)
     */
    @ApiModelProperty(value = "管理费用-其他(万元)")
    private String overheadOther;

    /**
     * 管理费用-合计(万元)
     */
    @ApiModelProperty(value = "管理费用-合计(万元)")
    private String overheadTotal;

    /**
     * 报表-管理费用-管理人数(人)
     */
    @ApiModelProperty(value = "报表-管理费用-管理人数(人)")
    private String managementPersonnel;

    /**
     * 财务费用-手续费(万元)
     */
    @ApiModelProperty(value = "财务费用-手续费(万元)")
    private String commission;

}
