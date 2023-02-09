package com.base.code.other.sudoku;

import java.util.List;

/**
 * 数独谜题
 */
public class SudokuPuzzle {

    public final List<List<Integer>> puzzle;

    public SudokuPuzzle(List<List<Integer>> puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> rows : this.puzzle) {
            for (Integer number : rows) {
                stringBuilder.append(" ").append(number).append(" ");
            }
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }
}
