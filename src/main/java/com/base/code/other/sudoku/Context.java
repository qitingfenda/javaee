package com.base.code.other.sudoku;

import com.google.common.collect.Lists;

import java.util.*;

public class Context {

    /**
     * 尚未确定的
     */
    public final List<BoxNumber> notSure = new ArrayList<>();
    /**
     * 行维度的格子集合
     */
    public final Map<Integer, List<BoxNumber>> rows = new HashMap<>(9);
    /**
     * 列维度的格子集合
     */
    public final Map<Integer, List<BoxNumber>> columns = new HashMap<>(9);
    /**
     * 九宫格维度的格子集合
     */
    public final Map<Integer, List<BoxNumber>> boxes = new HashMap<>(9);
    /**
     * 所有的格子
     */
    public final Map<Integer, BoxNumber> allNumbers = new LinkedHashMap<>(9 * 9);
    /**
     * 所有格子的概率统计
     */
    public final Map<Integer, Map<Integer, Integer>> rate = new HashMap<>(9 * 9 * 9);

    public Context(SudokuPuzzle puzzle) {
        int no = 1;
        int row = 1;
        for (List<Integer> columnNumber : puzzle.puzzle) {
            int column = 1;
            for (Integer number : columnNumber) {
                final BoxNumber boxNumber = new BoxNumber(number, no, column, row, (row - 1) / 3 * 3 + (column - 1) / 3 + 1);
                rows.computeIfAbsent(boxNumber.row, (key) -> new ArrayList<>()).add(boxNumber);
                columns.computeIfAbsent(boxNumber.column, (key) -> new ArrayList<>()).add(boxNumber);
                boxes.computeIfAbsent(boxNumber.box, (key) -> new ArrayList<>()).add(boxNumber);
                if (!boxNumber.isSure()) {
                    notSure.add(boxNumber);
                }
                allNumbers.put(no, boxNumber);
                no++;
                column++;
            }
            row++;
        }
    }

    /**
     * 初始化
     */
    public Context(Context context) {
        init(context);
    }

    /**
     * 初始化
     */
    private void init(Context contextCopy) {
        this.rows.clear();
        this.columns.clear();
        this.boxes.clear();
        this.notSure.clear();
        this.allNumbers.clear();
        this.rate.clear();
        for (BoxNumber boxNumber : contextCopy.allNumbers.values()) {
            final BoxNumber boxNumberCopy = new BoxNumber(boxNumber);
            rows.computeIfAbsent(boxNumberCopy.row, (key) -> new ArrayList<>()).add(boxNumberCopy);
            columns.computeIfAbsent(boxNumberCopy.column, (key) -> new ArrayList<>()).add(boxNumberCopy);
            boxes.computeIfAbsent(boxNumberCopy.box, (key) -> new ArrayList<>()).add(boxNumberCopy);
            if (!boxNumberCopy.isSure()) {
                notSure.add(boxNumberCopy);
            }
            allNumbers.put(boxNumberCopy.no, boxNumberCopy);
            for (Map.Entry<Integer, Integer> rateEntry : contextCopy.rate.get(boxNumberCopy.no).entrySet()) {
                rate.computeIfAbsent(boxNumberCopy.no, (key) -> new HashMap<>()).put(rateEntry.getKey(), rateEntry.getValue());
            }
        }
    }

    /**
     * 根据编号获取格子
     */
    public BoxNumber getBoxNumber(int no) {
        if (no < 1 || no > 81) {
            throw new IllegalArgumentException();
        }
        return allNumbers.get(no);
    }

    /**
     * 获取格子的数字概率
     */
    public Map<Integer, Integer> getBoxNumberRate(int no) {
        return rate.get(no);
    }

    /**
     * 是否已经完成
     */
    public boolean completed() {
        return notSure.isEmpty();
    }

    public SudokuPuzzle toPuzzle() {
        final List<List<Integer>> numbers = Lists.newArrayList();
        List<Integer> rowNumbers = null;
        for (BoxNumber boxNumber : this.allNumbers.values()) {
            if (rowNumbers == null || boxNumber.column == 1) {
                rowNumbers = new ArrayList<>();
                numbers.add(rowNumbers);
            }
            rowNumbers.add(boxNumber.number);
        }
        return new SudokuPuzzle(numbers);
    }

    /**
     * 将当前状态保存到备忘录
     */
    public Context saveStateToMemento() {
        return new Context(this);
    }

    /**
     * 从备忘录中恢复状态
     */
    public void getStateFromMemento(Context context) {
        this.init(context);
    }
}
