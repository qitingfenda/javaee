package com.base.code.other.sudoku;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * 生成数独
 *
 * @author yhc
 * @create 2022-07-27 16:57
 */
public class GeneratorSudoku {

    private static final int NUMBER = 9;

    @Test
    public void test01() {
        int[][] sudoku = new int[9][9];
        // 初始化首行
        init(sudoku);
        // 输出
        print(sudoku);
    }

    private void print(int[][] sudoku) {
        for (int[] ints : sudoku) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    private void print(int[] sudoku) {
        for (int anInt : sudoku) {
            System.out.print(anInt);
            System.out.print(", ");
        }
        System.out.println();
    }

    private void print(List<Integer> sudoku) {
        for (int anInt : sudoku) {
            System.out.print(anInt);
            System.out.print(", ");
        }
        System.out.println();
    }

    public void init(int[][] sudoku) {
        for (int i = 0; i < NUMBER; i++) {
            sudoku[i] = getLineRandomNumber(sudoku, i);
        }
    }

    /**
     * 获取一行随机数字
     */
    private int[] getLineRandomNumber(int[][] sudoku, int i) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[] randomArr = new int[NUMBER];
        for (int j = 0; j < NUMBER; j++) {
            List<Integer> ignoredList = new ArrayList<>();
            for (int y = 0; y < i; y++) {
                ignoredList.add(sudoku[y][j]);
            }
            int number = randomIndex(list);
            while (ignoredList.contains(number)) {
                if (ignoredList.containsAll(list)) {
                    print(sudoku);
                    // 生成失败，重试
                    System.out.println("第" + (i + 1) + "行生成失败");
                    System.out.print("已生成randomArr:");
                    print(randomArr);
                    System.out.print("ignoredList:");
                    print(ignoredList);
                    System.out.print("list:");
                    print(list);
                    System.out.println("正在重新生成第...");
                    System.out.println("----------------------------------------------------");
                    try {
                        Thread.sleep(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    test01();
                }
                number = randomIndex(list);
            }
            randomArr[j] = number;
            int finalNumber = number;
            list = list.stream().filter(x -> !x.equals(finalNumber)).collect(Collectors.toList());
        }
        return randomArr;
    }

    /**
     * 获取随机数字1~9
     */
    private int randomNumber() {
        return 1 + (int) (Math.random() * (NUMBER));
    }

    public static int randomIndex(List<Integer> arr) {
        if (arr != null && arr.size() > 0) {
            //获取随机下标
            return arr.get(new Random().nextInt(arr.size()));
        } else {
            throw new RuntimeException("数组为空");
        }
    }

}
