package com.base.code.other.sudoku;


public class BoxNumber {

    /**
     * 数值，0：表示不确定
     */
    public int number;
    /**
     * 编号
     */
    public final int no;
    /**
     * 所属列
     */
    public final int column;
    /**
     * 所属行
     */
    public final int row;
    /**
     * 所属格子
     */
    public final int box;

    public BoxNumber(int number, int no, int column, int row, int box) {
        this.number = number;
        this.no = no;
        this.column = column;
        this.row = row;
        this.box = box;
    }

    public BoxNumber(BoxNumber boxNumber) {
        this.number = boxNumber.number;
        this.no = boxNumber.no;
        this.column = boxNumber.column;
        this.row = boxNumber.row;
        this.box = boxNumber.box;
    }


    /**
     * 是否已经确定为某个数字
     */
    public boolean isSure() {
        return this.number != 0;
    }

    /**
     * 确定为某个数字
     */
    public void sure(int number) {
        this.number = number;
    }

    public String toString() {
        return "no." + no + "=" + number + "[" + row + "," + column + "]";
    }
}