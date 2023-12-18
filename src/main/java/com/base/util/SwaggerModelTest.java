package com.base.util;

import org.junit.Test;

/**
 * @author yhc
 * @create 2023-09-08 13:39
 */
public class SwaggerModelTest {
    String text = "    calculate_type: //计算逻辑类型（1：进行中；2：已核算）" +
            "    ,day_avg_area: //营业收入-纸板收入-日均接单量" +
            "    ,order_day: //营业收入-接单天数" +
            "    ,sales_area: //营业收入-销售面积" +
            "    ,sales_price: //营业收入-销售单价" +
            "    ,cardboard_revenue_total_tax_price: //营业收入-价税合计" +
            "    ,cardboard_revenue_total_exclude_tax: //营业收入-不含税合计" +
            "    ,discount_ratio: //营业收入-销售折让-折让比例" +
            "    ,unit_price_after_rebate: //营业收入-返利后单价" +
            "    ,sales_allowance_total_tax_price: //营业收入-价税合计" +
            "    ,sales_allowance_total_exclude_tax: //营业收入-不含税合计" +
            "    ,waste_paper_unit: //营业收入-废纸收入-废纸单价" +
            "    ,base_paper_utilization_rate: //营业收入-原纸利用率" +
            "    ,waste_paper_weight: //营业收入-废纸重量" +
            "    ,waste_paper_revenue_total_tax_price: //营业收入-价税合计" +
            "    ,waste_paper_revenue_total_exclude_tax: //营业收入-不含税合计" +
            "    ,operating_revenue_total_tax_price: //营业收入-价税合计" +
            "    ,operating_revenue_total_exclude_tax: //营业收入-不含税合计" +
            "    ,cardboard_weight: //营业成本-纸板生产成本-原纸成本-纸板克重" +
            "    ,paper_weight: //营业成本-原纸重量" +
            "    ,paper_unit_price: //营业成本-原纸单价" +
            "    ,paper_unit_cost: //营业成本-原纸单位成本" +
            "    ,paper_cost_total_tax_price: //营业成本-价税合计" +
            "    ,paper_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,starch_unit_price: //营业成本-淀粉成本-淀粉单价" +
            "    ,avg_starch_dosage: //营业成本-平均淀粉用量" +
            "    ,starch_dosage: //营业成本-淀粉用量" +
            "    ,starch_cost_total_tax_price: //营业成本-价税合计" +
            "    ,starch_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,borax_cost_unit_cost: //营业成本-硼砂成本-单位成本" +
            "    ,borax_cost_total_tax_price: //营业成本-价税合计" +
            "    ,borax_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,caustic_soda_cost_unit_cost: //营业成本-烧碱成本-单位成本" +
            "    ,caustic_soda_cost_total_tax_price: //营业成本-价税合计" +
            "    ,caustic_soda_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,additive_cost_unit_cost: //营业成本-添加剂成本-单位成本" +
            "    ,additive_cost_total_tax_price: //营业成本-价税合计" +
            "    ,additive_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,glue_cost_unit_cost: //营业成本-胶水成本-价税合计" +
            "    ,glue_cost_total_tax_price: //营业成本-不含税合计" +
            "    ,glue_cost_total_exclude_tax: //营业成本-单位成本" +
            "    ,steam_cost_unit_cost: //营业成本-蒸汽成本-单位成本" +
            "    ,steam_cost_total_tax_price: //营业成本-价税合计" +
            "    ,steam_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,water_cost_unit_cost: //营业成本-水费成本-单位成本" +
            "    ,water_cost_total_tax_price: //营业成本-价税合计" +
            "    ,water_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,electricity_cost_unit_cost: //营业成本-电费成本-单位成本" +
            "    ,electricity_cost_total_tax_price: //营业成本-价税合计" +
            "    ,electricity_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,water_electricity_expenses_unit_cost: //营业成本-水电费-价税合计" +
            "    ,water_electricity_expenses_total_tax_price: //营业成本-不含税合计" +
            "    ,water_electricity_expenses_total_exclude_tax: //营业成本-单位成本" +
            "    ,repair_cost_unit_cost: //营业成本-修理费成本-单位成本" +
            "    ,repair_cost_total_tax_price: //营业成本-价税合计" +
            "    ,repair_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,consumables_cost_unit_cost: //营业成本-易耗品成本-单位成本" +
            "    ,consumables_cost_total_tax_price: //营业成本-价税合计" +
            "    ,consumables_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,other_cost_unit_cost: //营业成本-其他成本-价税合计" +
            "    ,other_cost_total_tax_price: //营业成本-不含税合计" +
            "    ,other_cost_total_exclude_tax: //营业成本-单位成本" +
            "    ,labor_cost_unit_cost: //营业成本-人工成本-单位成本" +
            "    ,labor_cost_total_tax_price: //营业成本-价税合计" +
            "    ,labor_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,rent_total_tax_price: //营业成本-租金-价税合计" +
            "    ,rent_total_exclude_tax: //营业成本-不含税合计" +
            "    ,depreciation_total_tax_price: //营业成本-折旧-价税合计" +
            "    ,depreciation_total_exclude_tax: //营业成本-不含税合计" +
            "    ,rent_depreciation_total_tax_price: //营业成本-租金&折旧-价税合计" +
            "    ,rent_depreciation_total_exclude_tax: //营业成本-不含税合计" +
            "    ,cardboard_production_cost_unit_cost: //营业成本-价税合计" +
            "    ,cardboard_production_cost_total_tax_price: //营业成本-不含税合计" +
            "    ,cardboard_production_cost_total_exclude_tax: //营业成本-单位生产成本" +
            "    ,freight_unit_price: //营业成本-运输成本-运费单价" +
            "    ,transportation_area: //营业成本-运输面积" +
            "    ,freight_offline_subsidies: //营业成本-线下补贴" +
            "    ,freight_excess_delivery: //营业成本-超家数费" +
            "    ,transport_cost_total_tax_price: //营业成本-价税合计" +
            "    ,transport_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,operating_cost_total_tax_price: //营业成本-价税合计" +
            "    ,operating_cost_total_exclude_tax: //营业成本-不含税合计" +
            "    ,unit_operating_cost: //营业成本-单位营业成本" +
            "    ,gross_profit_amount: //毛利额-毛利额" +
            "    ,gross_margin: //毛利额-毛利率" +
            "    ,machining_cost: //毛利额-加工费" +
            "    ,total_machining_cost: //毛利额-加工费总额" +
            "    ,machining_cost_proportion: //毛利额-加工费占比" +
            "    ,paper_cost_proportion: //毛利额-原纸成本占比" +
            "    ,supply_and_sales_dif: //毛利额-供销差额" +
            "    ,value_added_tax: //税费-增值税" +
            "    ,additional_tax: //税费-附加税" +
            "    ,stamp_duty: //税费-印花税" +
            "    ,other_taxes: //税费-其他税费" +
            "    ,total_taxes: //税费-税费合计" +
            "    ,tax_bearing_rate: //税费-税负率" +
            "    ,sales_compensation: //销售费用-销售薪酬" +
            "    ,labor_costs: //管理费用-人工费用" +
            "    ,welfare_costs: //管理费用-福利费" +
            "    ,office_expenses: //管理费用-办公费" +
            "    ,transportation_expenses: //管理费用-交通费" +
            "    ,entertainment_expenses: //管理费用-招待费" +
            "    ,water_electricity_expenses: //管理费用-水电费" +
            "    ,travel_expenses: //管理费用-差旅费" +
            "    ,overhead_rent: //管理费用-租金" +
            "    ,overhead_other: //管理费用-其他" +
            "    ,overhead_total: //管理费用-合计" +
            "    ,commission: //财务费用-手续费" +
            "    ,period_fees_and_taxes: //期间费用及税费" +
            "    ,non_operating_income: //营业外收入" +
            "    ,non_operating_expenses: //营业外支出" +
            "    ,non_operating_profit: //营业外利润" +
            "    ,total_compensation: //薪酬总额" +
            "    ,unit_salary: //单位薪酬" +
            "    ,total_profit: //利润总额" +
            "    ,income_tax: //所得税" +
            "    ,net_profit: //净利润" +
            "    ,net_profit_margin: //净利率" +
            "    ,paper_purchase_price: //原纸近期采购价格" +
            "    ,paper_inventory_price: //原纸历史库存价格" +
            "    ,paper_market_price: //原纸市场价格" +
            "    ,paper_trimming_rate: //原纸修边率" +
            "    ,paper_other_rate: //原纸其他" +
            "    ,number_of_employee: //员工人数" +
            "    ,management_personnel: //管理人数" +
            "    ,steam_cost_consumption: //蒸汽用量(吨)" +
            "    ,natural_gas_consumption: //天然气用量(吨)" +
            "    ,sales_compensation_unit_cost: //销售薪酬-单位成本" +
            "    ,freight_avg_car: //报表-运输成本-平均运输面积(平方米/车)";

    @Test
    public void test01() {
        String[] testArr = this.text.split(",");
        for (String item : testArr) {
            String[] itemArr = item.split(":");
            System.out.println("@ApiModelProperty(value = \"" + itemArr[1].trim().replace("//", "") + "\")");
            String paramName = itemArr[0].trim();
            System.out.println("@JsonProperty(\"" + paramName + "\")");
            System.out.println("private String " + StringUtil.underlineToHump(paramName, false) + ";");
            System.out.println();
        }
    }

    String text02 = "result.setDayAvgArea;" +
            "result.setSalesArea;" +
            "result.setSalesPrice;" +
            "result.setCardboardRevenueTotalTaxPrice;" +
            "result.setCardboardRevenueTotalExcludeTax;" +
            "result.setDiscountRatio;" +
            "result.setUnitPriceAfterRebate;" +
            "result.setSalesAllowanceTotalTaxPrice;" +
            "result.setSalesAllowanceTotalExcludeTax;" +
            "result.setWastePaperUnit;" +
            "result.setBasePaperUtilizationRate;" +
            "result.setWastePaperWeight;" +
            "result.setWastePaperRevenueTotalTaxPrice;" +
            "result.setWastePaperRevenueTotalExcludeTax;" +
            "result.setOperatingRevenueTotalTaxPrice;" +
            "result.setOperatingRevenueTotalExcludeTax;" +
            "result.setCardboardWeight;" +
            "result.setPaperWeight;" +
            "result.setPaperUnitPrice;" +
            "result.setPaperUnitCost;" +
            "result.setPaperCostTotalTaxPrice;" +
            "result.setPaperCostTotalExcludeTax;" +
            "result.setStarchUnitPrice;" +
            "result.setAvgStarchDosage;" +
            "result.setStarchDosage;" +
            "result.setStarchCostTotalTaxPrice;" +
            "result.setStarchCostTotalExcludeTax;" +
            "result.setBoraxCostUnitCost;" +
            "result.setBoraxCostTotalTaxPrice;" +
            "result.setBoraxCostTotalExcludeTax;" +
            "result.setCausticSodaCostUnitCost;" +
            "result.setCausticSodaCostTotalTaxPrice;" +
            "result.setCausticSodaCostTotalExcludeTax;" +
            "result.setAdditiveCostUnitCost;" +
            "result.setAdditiveCostTotalTaxPrice;" +
            "result.setAdditiveCostTotalExcludeTax;" +
            "result.setGlueCostUnitCost;" +
            "result.setGlueCostTotalTaxPrice;" +
            "result.setGlueCostTotalExcludeTax;" +
            "result.setSteamCostUnitCost;" +
            "result.setSteamCostTotalTaxPrice;" +
            "result.setSteamCostTotalExcludeTax;" +
            "result.setWaterCostUnitCost;" +
            "result.setWaterCostTotalTaxPrice;" +
            "result.setWaterCostTotalExcludeTax;" +
            "result.setElectricityCostUnitCost;" +
            "result.setElectricityCostTotalTaxPrice;" +
            "result.setElectricityCostTotalExcludeTax;" +
            "result.setWaterElectricityExpensesUnitCost;" +
            "result.setWaterElectricityExpensesTotalTaxPrice;" +
            "result.setWaterElectricityExpensesTotalExcludeTax;" +
            "result.setRepairCostUnitCost;" +
            "result.setRepairCostTotalTaxPrice;" +
            "result.setRepairCostTotalExcludeTax;" +
            "result.setConsumablesCostUnitCost;" +
            "result.setConsumablesCostTotalTaxPrice;" +
            "result.setConsumablesCostTotalExcludeTax;" +
            "result.setOtherCostUnitCost;" +
            "result.setOtherCostTotalTaxPrice;" +
            "result.setOtherCostTotalExcludeTax;" +
            "result.setLaborCostUnitCost;" +
            "result.setLaborCostTotalTaxPrice;" +
            "result.setLaborCostTotalExcludeTax;" +
            "result.setRentTotalTaxPrice;" +
            "result.setRentTotalExcludeTax;" +
            "result.setDepreciationTotalTaxPrice;" +
            "result.setDepreciationTotalExcludeTax;" +
            "result.setRentDepreciationTotalTaxPrice;" +
            "result.setRentDepreciationTotalExcludeTax;" +
            "result.setCardboardProductionCostUnitCost;" +
            "result.setCardboardProductionCostTotalTaxPrice;" +
            "result.setCardboardProductionCostTotalExcludeTax;" +
            "result.setFreightUnitPrice;" +
            "result.setTransportationArea;" +
            "result.setFreightOfflineSubsidies;" +
            "result.setFreightExcessDelivery;" +
            "result.setTransportCostTotalTaxPrice;" +
            "result.setTransportCostTotalExcludeTax;" +
            "result.setOperatingCostTotalTaxPrice;" +
            "result.setOperatingCostTotalExcludeTax;" +
            "result.setUnitOperatingCost;" +
            "result.setGrossProfitAmount;" +
            "result.setGrossMargin;" +
            "result.setMachiningCost;" +
            "result.setTotalMachiningCost;" +
            "result.setMachiningCostProportion;" +
            "result.setPaperCostProportion;" +
            "result.setSupplyAndSalesDif;" +
            "result.setValueAddedTax;" +
            "result.setAdditionalTax;" +
            "result.setStampDuty;" +
            "result.setOtherTaxes;" +
            "result.setTotalTaxes;" +
            "result.setTaxBearingRate;" +
            "result.setSalesCompensation;" +
            "result.setOverheadLaborCosts;" +
            "result.setOverheadWelfareCosts;" +
            "result.setOverheadOfficeExpenses;" +
            "result.setOverheadTransportationExpenses;" +
            "result.setOverheadEntertainmentExpenses;" +
            "result.setOverheadWaterElectricityExpenses;" +
            "result.setOverheadTravelExpenses;" +
            "result.setOverheadRent;" +
            "result.setOverheadOther;" +
            "result.setOverheadTotal;" +
            "result.setCommission;" +
            "result.setPeriodFeesAndTaxes;" +
            "result.setNonOperatingIncome;" +
            "result.setNonOperatingExpenses;" +
            "result.setNonOperatingProfit;" +
            "result.setTotalCompensation;" +
            "result.setUnitSalary;" +
            "result.setTotalProfit;" +
            "result.setIncomeTax;" +
            "result.setNetProfit;" +
            "result.setNetProfitMargin;" +
            "result.setPaperPurchasePrice;" +
            "result.setPaperInventoryPrice;" +
            "result.setPaperMarketPrice;" +
            "result.setPaperTrimmingRate;" +
            "result.setPaperOtherRate;" +
            "result.setNumberOfEmployee;" +
            "result.setManagementPersonnel;" +
            "result.setSteamCostConsumption;" +
            "result.setNaturalGasConsumption;" +
            "result.setSalesCompensationUnitCost;" +
            "result.setFreightAvgCar";

    @Test
    public void test02() {
        String[] testArr = this.text02.split(";");
        for (String item : testArr) {
            String[] itemArr = item.split("\\.");
            System.out.println(itemArr[0] + "."+itemArr[1]+"("+itemArr[0]+"."+itemArr[1].replace("set", "get")+"().divide(tenThousand, 4, RoundingMode.HALF_UP));");
        }
    }
}
