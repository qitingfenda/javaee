package com.base.code.other;

import jdk.management.resource.internal.TotalResourceContext;
import org.junit.Test;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yhc
 * @create 2022-08-08 9:12
 */
public class Test05 {


    @Test
    public void test2() {
        String nameStr = "客户编号,用户类型,证件资料,合同资料";
        String markStr = "customer_no,authentication_type,authentication_img,contract_img";
        String[] markArr = markStr.split(",");
        int belongModule = 0;
        String[] nameArr = nameStr.split(",");
        for (int i = 0; i < nameArr.length; i++) {
            StringBuilder str = new StringBuilder("// ");
            str.append(nameArr[i]).append("\n").append("public static final String ")
                    .append(markArr[i].toUpperCase()).append(" = \"").append(markArr[i]).append("\";");
            System.out.println(str.toString());
        }
    }

    @Test
    public void test() {
        String source = "客户编号,用户类型,证件资料,合同资料";
        String markBegin = "";
        markBegin = ObjectUtils.isEmpty(markBegin)? markBegin : markBegin + "_";
        String markStr = "customer_no,authentication_type,authentication_img,contract_img";
        String[] markArr = markStr.split(",");
        int belongModule = 0;
        String[] split = source.split(",");
        String fatherId = "23b0af98ef0d11eda730000c29f98159";
        int noSelectNum = 0;
        for (int i = 0; i < split.length; i++) {
            StringBuilder str = new StringBuilder("INSERT INTO `crm_config_default_field` (`id`, `skey`, `name`, `mark`, `status`, `belong_module`, `father_id`) VALUES('");
            str.append(UUID.randomUUID().toString().replace("-", ""))
                    .append("','100','")
                    .append(split[i])
                    .append("','")
                    .append(markBegin + markArr[i])
                    .append("','")
                    .append(belongModule)
                    .append("','");
            if (i < noSelectNum) {
                str.append("1");
            } else {
                str.append("0");
            }
            str.append("','").append(fatherId).append("');");
            System.out.println(str);
        }
    }

    private void init(List<String> dataList) {
        for (int i = 0; i < 22; i++) {
            dataList.add(i + "");
        }
    }


    /**
     * 计算两个时间差
     */
    public String getTimeDifference(Date date1, Date date2) {
        StringBuilder df = new StringBuilder();
        // 计算单位设置(毫秒1000 * 秒60 * 分60 * 时24);
        long time = (date1.getTime() - date2.getTime());
        long num = time / (1000 * 60 * 60);
        long num1 = time % (1000 * 60 * 60);
        float temp = (float) (num1 / 1000 / 60) / (float) 60.0;
//        float temp = (num1 / 1000 / 60) / (float) 60.0;
        if (num >= 0) {
            df.append(num + temp);
        }
        return df.toString();

    }


}
