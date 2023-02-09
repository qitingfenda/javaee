package com.base.code.other.sudoku;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数独
 */
public class Sudoku {

    private final SudokuPuzzle puzzle;
    private Context context = null;
    private int deep;

    public static void main(String[] args) {
        final long l1 = System.currentTimeMillis();
        final Sudoku sudoku = new Sudoku(PuzzleGenerator.puzzle1);
        sudoku.printPuzzle();
        final List<SudokuPuzzle> answers = sudoku.solve(10);
        for (int i = 1; i <= answers.size(); i++) {
            System.out.println("答案" + i);
            System.out.println(answers.get(i - 1));
        }
        System.out.println(System.currentTimeMillis() - l1 + "ms");
    }

    /**
     * 初始化
     */
    public Sudoku(SudokuPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    /**
     * 解题
     */
    public List<SudokuPuzzle> solve(int needAnswers) {
        preSolve();
        List<SudokuPuzzle> answers = new ArrayList<>();
        try {
            elimination(answers, needAnswers, false);
        } catch (IllegalStateException ignore) {
        }
        if (answers.isEmpty()) {
            System.out.println("解题失败");
        } else {
            System.out.println("答案已解出，共" + answers.size() + "个答案");
        }
        return answers;
    }

    /**
     * 开始解题之前的步骤
     */
    public void preSolve() {
        this.deep = 0;
        this.context = new Context(this.puzzle);
        // 初始化格子的概率
        for (BoxNumber boxNumber : context.allNumbers.values()) {
            context.rate.put(boxNumber.no, avgRate(Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        }
    }

    public SudokuPuzzle solveOneStep() {
        System.out.println("走一步");
        preSolve();
        List<SudokuPuzzle> answers = new ArrayList<>();
        try {
            elimination(answers, 1, true);
        } catch (IllegalStateException ignore) {
        }
        return answers.get(0);
    }

    /**
     * 重新计算数字格子的概率
     */
    public static void computeRate(Context context, BoxNumber boxNumber) throws IllegalStateException {
        // 通过相同行，相同列，相同格子中已经确认的数据，计算数值的概率
        final List<List<BoxNumber>> sameDimensions = sameDimensions(context, boxNumber);
        // 根据相同维度上已经存在的数据，进行排除，剩余的可能数字平分概率
        // 然后对各个维度上的概率进行合并，得出最终概率
        final Map<Integer, Integer> rates = context.getBoxNumberRate(boxNumber.no);
        for (int i = 0; i < sameDimensions.size(); i++) {
            final Set<Integer> possible = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9);
            for (BoxNumber sameDimension : sameDimensions.get(i)) {
                if (sameDimension != boxNumber && sameDimension.isSure()) {
                    possible.remove(sameDimension.number);
                }
            }
            if (i == 0) {
                assignRate(rates, avgRate(possible));
            } else {
                combineRate(rates, avgRate(possible));
            }
        }
        if (!checkRate(rates)) {
            throw new IllegalStateException("no." + boxNumber.no + " 概率异常1");
        }
        // 对相同维度上的数据进行排查，如果其它格子都不可能是某个数，那么就能100%确定自己就是那个数
        for (int number = 1; number <= 9; number++) {
            for (List<BoxNumber> dimension : sameDimensions) {
                int rate = 0;
                for (BoxNumber sameDimension : dimension) {
                    if (sameDimension.isSure() && sameDimension.number == number) {
                        rate = 100;
                        break;
                    }
                    if (sameDimension != boxNumber && !sameDimension.isSure()) {
                        rate += context.getBoxNumberRate(sameDimension.no).get(number);
                    }
                }
                if (rate == 100) {
                    break;
                } else if (rate == 0) {
                    if (possibleNumber(context, boxNumber).contains(number)) {
                        assignRate(rates, sureRate(number));
                    } else {
                        throw new IllegalStateException("no." + boxNumber.no + " 概率异常，只能为" + number + "，又不能为" + number);
                    }
                    return;
                }
            }
        }
    }

    /**
     * 获取格子的所有可能数字
     */
    public static Set<Integer> possibleNumber(Context context, BoxNumber boxNumber) {
        final Set<Integer> possible = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (List<BoxNumber> dimension : sameDimensions(context, boxNumber)) {
            for (BoxNumber sameDimension : dimension) {
                if (sameDimension != boxNumber && sameDimension.isSure()) {
                    possible.remove(sameDimension.number);
                }
            }
        }
        return possible;
    }

    /**
     * 根据提供的概率，对原概率进行赋值
     */
    public static void assignRate(Map<Integer, Integer> rate, Map<Integer, Integer> targetRate) {
        for (int i = 1; i <= 9; i++) {
            rate.put(i, targetRate.get(i));
        }
    }

    /**
     * 组合两个概率
     */
    public static void combineRate(Map<Integer, Integer> rate1, Map<Integer, Integer> rate2) {
        for (int i = 1; i <= 9; i++) {
            final Integer integer1 = rate1.get(i);
            final Integer integer2 = rate2.get(i);
            if (integer1 == 0 || integer2 == 0) {
                rate1.put(i, 0);
            } else if (integer1 == 100 || integer2 == 100) {
                rate1.put(i, 100);
            } else {
                rate1.put(i, rate2.get(i) * (100 - rate1.get(i)) / 100 + rate1.get(i));
            }
        }
    }

    /**
     * 生成平均概率
     */
    public static Map<Integer, Integer> avgRate(Set<Integer> possible) {
        final int weight = (int) (1.0 / possible.size() * 100);
        final Map<Integer, Integer> rate = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            rate.put(i, possible.contains(i) ? weight : 0);
        }
        return rate;
    }

    /**
     * 生成确定概率
     */
    public static Map<Integer, Integer> sureRate(Integer possible) {
        final Map<Integer, Integer> rate = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            rate.put(i, possible == i ? 100 : 0);
        }
        return rate;
    }

    /**
     * 检查概率是否有问题
     */
    public static boolean checkRate(Map<Integer, Integer> rate) {
        int highestRate = 0;
        for (Integer value : rate.values()) {
            highestRate = Math.max(value, highestRate);
        }
        return highestRate != 0;
    }

    /**
     * 获取概率最高的数字
     */
    public static Map.Entry<Integer, Integer> getHighestRate(Map<Integer, Integer> rate) {
        int highestRate = -1;
        Map.Entry<Integer, Integer> highestRateEntry = null;
        for (Map.Entry<Integer, Integer> rateEntry : rate.entrySet()) {
            if (rateEntry.getValue() > highestRate) {
                highestRateEntry = rateEntry;
                highestRate = rateEntry.getValue();
            }
        }
        return highestRateEntry;
    }

    /**
     * 从概率中判断能确定的数字
     * 如果不能确定，返回空
     */
    public static Integer getSure(Map<Integer, Integer> rate) {
        int zeroRate = 0;
        int propertyNumber = 0;
        for (Map.Entry<Integer, Integer> rateEntry : rate.entrySet()) {
            if (rateEntry.getValue() == 0) {
                zeroRate++;
            } else {
                propertyNumber = rateEntry.getKey();
            }
        }
        if (zeroRate == 8 && propertyNumber != 0) {
            return propertyNumber;
        }
        return null;
    }

    /**
     * 排除法
     */
    public void elimination(List<SudokuPuzzle> answers, int needAnswers, boolean oneStep) throws IllegalStateException {
        boolean flag = false;
        for (int i = context.notSure.size(); i > 0; i--) {
            final BoxNumber boxNumber = context.notSure.get(i - 1);
            // 计算数值的概率
            computeRate(context, boxNumber);
            // 如果能明确数值, 将该格子从未确定中移除
            final Integer sureNumber = getSure(context.getBoxNumberRate(boxNumber.no));
            if (sureNumber != null) {
                System.out.println(getDeepSpace() + "排除法:" + "no." + boxNumber.no + "=" + sureNumber);
                boxNumber.sure(sureNumber);
                flag = true;
                context.notSure.remove(i - 1);
            }
        }
        // 如果计算出了某个格子的数字，那么继续通过排除法，重新再计算一遍，直到排除法无法确定数字
        // 如果通过排除法已经无法确定数字，则需要通过概率法进行计算
        if (context.completed()) {
            if (checkError(context) == null) {
                answers.add(context.toPuzzle());
            }
        } else if (flag) {
            if (oneStep) {
                return;
            }
            elimination(answers, needAnswers, oneStep);
        } else {
            probabilistic(answers, needAnswers, oneStep);
        }
    }

    /**
     * 概率算法
     * 当排除法已经无能为力时，可以通过概率法，从所有未确定的格子中找到一个最明确的格子，进行填写
     */
    public void probabilistic(List<SudokuPuzzle> answers, int needAnswers, boolean oneStep) {
        System.out.println("概率算法");
        int highestRate = -1;
        Map.Entry<Integer, Integer> highestRateEntry = null;
        BoxNumber highestRateBoxNumber = null;
        for (BoxNumber boxNumber : context.notSure) {
            final Map.Entry<Integer, Integer> rateEntry = getHighestRate(context.getBoxNumberRate(boxNumber.no));
            if (rateEntry.getValue() > highestRate) {
                highestRate = rateEntry.getValue();
                highestRateEntry = rateEntry;
                highestRateBoxNumber = boxNumber;
            }
        }
        // 通过概率计算得出的值有不确定性，当后续发生错误时，需要恢复到当前状态，并重新选择其它值
        if (highestRateEntry != null && highestRate > 0) {
            System.out.println("有最高概率");
            final int no = highestRateBoxNumber.no;
            // 将该格子的可能的数字和概率，根据概率从高到低排列
            final List<Map.Entry<Integer, Integer>> rateList = context.getBoxNumberRate(no).entrySet().stream()
                    .filter(entry -> entry.getValue() > 0)
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toList());
            // 将数独的当前状态进行备份，如果根据概率填写的数值，导致后续解题报错，可以从这里恢复
            final Context contextCopy = context.saveStateToMemento();
            // 根据概率从高到低进行遍历
            for (Map.Entry<Integer, Integer> rateEntry : rateList) {
                System.out.println(getDeepSpace() + "概率算法:" + "no." + no + "=" + rateEntry.getKey() + ", " + rateEntry.getValue() + "%");
                sure(no, rateEntry.getKey());
                try {
                    deep++;
                    elimination(answers, needAnswers, oneStep);
                    if (oneStep) {
                        context.getStateFromMemento(contextCopy);
                        sure(no, rateEntry.getKey());
                        break;
                    }
                    // 跳出循环就只有一个解，不跳出循环会计算所有可能解
                    if (answers.size() >= needAnswers) {
                        break;
                    }
                } catch (IllegalStateException e) {
                    System.out.println(getDeepSpace() + "概率算法判断错误，重新选值");
                } finally {
                    deep--;
                }
                // 如果后续解题过程发生报错，将状态初始化到填写之前，并选择下一个优先级的数值
                context.getStateFromMemento(contextCopy);
            }
        }
    }

    public void sure(int no, int number) {
        final BoxNumber boxNumber = context.getBoxNumber(no);
        boxNumber.sure(number);
        context.notSure.remove(boxNumber);
    }

    /**
     * 获取与格子有相同维度的格子集合
     */
    public static List<List<BoxNumber>> sameDimensions(Context context, BoxNumber boxNumber) {
        // 通过相同行，相同列，相同格子中已经确认的数据，计算数值的概率
        List<BoxNumber> sameRows = context.rows.get(boxNumber.row);
        List<BoxNumber> sameColumns = context.columns.get(boxNumber.column);
        List<BoxNumber> sameBoxes = context.boxes.get(boxNumber.box);
        return Lists.newArrayList(sameRows, sameColumns, sameBoxes);
    }

    /**
     * 检查数独是否有错误
     */
    public String checkError(Context context) {
        boolean hasError = false;
        final StringBuilder stringBuilder = new StringBuilder();
        for (BoxNumber boxNumber : context.allNumbers.values()) {
            if (!boxNumber.isSure()) {
                stringBuilder.append(" ").append(boxNumber.number).append(" ");
            } else {
                boolean flag = false;
                for (List<BoxNumber> sameDimensions : Lists.newArrayList(
                        context.rows.get(boxNumber.row),
                        context.columns.get(boxNumber.column),
                        context.boxes.get(boxNumber.box)
                )) {
                    if (hasRepeat(boxNumber, sameDimensions)) {
                        stringBuilder.append(" ").append("x").append(" ");
                        flag = true;
                        hasError = true;
                        break;
                    }
                }
                if (!flag) {
                    stringBuilder.append(" ").append(boxNumber.number).append(" ");
                }
            }
            if (boxNumber.column == 9) {
                stringBuilder.append("\r\n");
            }
        }
        if (hasError) {
            System.out.println("检查完毕 发现错误");
            return stringBuilder.toString();
        } else {
            System.out.println("检查完毕 没有错误");
            return null;
        }
    }

    /**
     * 检查格子是否与列表中的格子数字重复
     */
    public boolean hasRepeat(BoxNumber boxNumber, List<BoxNumber> boxNumbers) {
        for (BoxNumber targetBoxNumber : boxNumbers) {
            if (targetBoxNumber != boxNumber && targetBoxNumber.isSure() && targetBoxNumber.number == boxNumber.number) {
                return true;
            }
        }
        return false;
    }

    /**
     * 打印谜题
     */
    public void printPuzzle() {
        System.out.println(this.puzzle);
    }

    public String getDeepSpace() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.deep; i++) {
            stringBuilder.append("  ");
        }
        return stringBuilder.toString();
    }
}
