package com.base.util;

import io.swagger.annotations.ApiModelProperty;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @author yhc
 * @create 2023-08-23 15:34
 */
public class GenerFile {


    public static void main(String[] args) {
        File[] files = getFiles("D:\\IdeaProjects\\dj-finance-manage\\finance-manage-dao\\src\\main\\java\\com\\dongjing\\finance\\manage\\dao\\base\\budget");
        for (File file : files) {
            String oldStr = "return value;";
            String newStr = "return super.calculateValue(budgetCompleteModel);";
            autoReplace(file.getPath(),oldStr, newStr);
        }
        System.out.println("end!!");
    }

    private static void autoReplace(String filePath, String oldstr, String newStr) {
        File file = new File(filePath);
        Long fileLength = file.length();
        byte[] fileContext = new byte[fileLength.intValue()];
        FileInputStream in = null;
        PrintWriter out = null;
        try {
            in = new FileInputStream(filePath);
            in.read(fileContext);
            // 防止中文乱码
            String str = new String(fileContext);
            str = str.replace(oldstr, newStr);
            out = new PrintWriter(filePath);
            out.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static File[] getFiles(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        return file.listFiles();
    }


    @Test
    public void test2() throws Exception {
        File file = new File("D:/IdeaProjects/javaee/src/main/java/com/base/util/budget/" + "TestModel2" + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        //创建一个文件字符输出流
        FileWriter fw = new FileWriter(file);

        Class<?> calzz = Class.forName("com.base.util.TestModel");
        Field[] fields = calzz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(Boolean.TRUE);
            ApiModelProperty apiModelProperty = field.getDeclaredAnnotation(ApiModelProperty.class);
            String name = field.getName();
            generFile2(fw,name,name.substring(0, 1).toUpperCase() + name.substring(1), apiModelProperty.value());
        }

        //关闭流
        fw.close();

    }

    private void generFile2(FileWriter fw ,String sourceName,String str, String remark) throws Exception {
        //写入数据
        fw.write("    /**\n" +
                "     * "+remark+"\n" +
                "     */\n" +
                "    @ApiModelProperty(value = \""+remark+"\")\n" +
                "    private "+str+" "+sourceName+";\n\n");
    }

    @Test
    public void test() throws Exception {

        Class<?> calzz = Class.forName("com.base.util.TestModel");
        Field[] fields = calzz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(Boolean.TRUE);
            ApiModelProperty apiModelProperty = field.getDeclaredAnnotation(ApiModelProperty.class);
            String name = field.getName();
            generFile1(name.substring(0, 1).toUpperCase() + name.substring(1), apiModelProperty.value());
        }
    }

    private void generFile1(String fileName, String remark) throws Exception {
        File file = new File("D:/IdeaProjects/javaee/src/main/java/com/base/util/budget/" + fileName + "VO.java");
        if (!file.exists()) {
            file.createNewFile();
        }
        //创建一个文件字符输出流
        FileWriter fw = new FileWriter(file);
        //写入数据
        fw.write("package com.dongjing.finance.manage.service.vo.budget.manage;\n" +
                "\n" +
                "import lombok.Data;\n" +
                "import lombok.EqualsAndHashCode;\n" +
                "\n" +
                "import java.math.BigDecimal;\n" +
                "\n" +
                "/**\n" +
                " * " + remark + "\n" +
                " * \n" +
                " * @author yhc\n" +
                " * @create 2023-08-28 10:21\n" +
                " */\n" +
                "@EqualsAndHashCode(callSuper = true)\n" +
                "@Data\n" +
                "public class " + fileName + "VO" + " extends BudgetBaseVO<BigDecimal> {\n" +
                "}\n");
        //关闭流
        fw.close();
    }

}
