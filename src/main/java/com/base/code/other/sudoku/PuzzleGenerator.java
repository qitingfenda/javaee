package com.base.code.other.sudoku;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 谜题生成器
 */
public class PuzzleGenerator {

    public static final SudokuPuzzle puzzleZero = new SudokuPuzzle(Lists.newArrayList(
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 0)
    ));

    public static final SudokuPuzzle puzzle1 = new SudokuPuzzle(Lists.newArrayList(
            Lists.newArrayList(0, 0, 0, 7, 0, 2, 0, 6, 3),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 0, 1),
            Lists.newArrayList(0, 7, 0, 0, 9, 0, 2, 8, 0),
            Lists.newArrayList(0, 0, 0, 2, 0, 0, 6, 0, 8),
            Lists.newArrayList(3, 0, 6, 0, 8, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 1, 0, 0, 4, 5, 0, 0),
            Lists.newArrayList(2, 0, 0, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(4, 5, 0, 0, 7, 8, 0, 0, 0),
            Lists.newArrayList(0, 1, 7, 6, 0, 0, 0, 9, 0)
    ));

    public static final SudokuPuzzle puzzle2 = new SudokuPuzzle(Lists.newArrayList(
            Lists.newArrayList(8, 3, 0, 6, 0, 9, 0, 0, 0),
            Lists.newArrayList(6, 0, 2, 0, 0, 0, 9, 0, 0),
            Lists.newArrayList(5, 0, 0, 0, 0, 7, 0, 0, 1),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 6, 9),
            Lists.newArrayList(3, 9, 0, 2, 0, 8, 0, 0, 0),
            Lists.newArrayList(0, 5, 0, 4, 0, 6, 0, 2, 3),
            Lists.newArrayList(9, 2, 0, 0, 7, 0, 5, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 5, 4, 0, 0),
            Lists.newArrayList(0, 1, 0, 9, 0, 0, 0, 0, 7)
    ));

    public static final SudokuPuzzle puzzle3 = new SudokuPuzzle(Lists.newArrayList(
            Lists.newArrayList(1, 5, 0, 6, 0, 3, 0, 2, 0),
            Lists.newArrayList(0, 0, 0, 0, 4, 0, 3, 7, 8),
            Lists.newArrayList(0, 0, 0, 0, 0, 8, 0, 0, 0),
            Lists.newArrayList(5, 1, 0, 0, 0, 0, 9, 0, 0),
            Lists.newArrayList(0, 0, 2, 0, 0, 0, 6, 1, 0),
            Lists.newArrayList(0, 0, 4, 3, 0, 0, 2, 0, 0),
            Lists.newArrayList(7, 3, 5, 8, 0, 0, 0, 0, 6),
            Lists.newArrayList(0, 8, 0, 0, 0, 0, 0, 4, 0),
            Lists.newArrayList(0, 6, 9, 0, 0, 0, 8, 0, 0)
    ));

    public static final SudokuPuzzle puzzle4 = new SudokuPuzzle(Lists.newArrayList(
            Lists.newArrayList(0, 0, 0, 5, 0, 0, 3, 0, 0),
            Lists.newArrayList(0, 7, 0, 0, 3, 2, 0, 0, 5),
            Lists.newArrayList(0, 3, 0, 7, 6, 0, 0, 0, 9),
            Lists.newArrayList(0, 0, 0, 4, 0, 7, 0, 0, 8),
            Lists.newArrayList(0, 0, 0, 0, 0, 0, 0, 3, 0),
            Lists.newArrayList(2, 5, 0, 0, 0, 0, 9, 0, 7),
            Lists.newArrayList(7, 2, 0, 3, 0, 9, 5, 0, 0),
            Lists.newArrayList(8, 9, 0, 2, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 5, 0, 0, 0, 0, 0, 6)
    ));

    public static final SudokuPuzzle puzzle5 = new SudokuPuzzle(Lists.newArrayList(
            Lists.newArrayList(0, 1, 0, 0, 0, 0, 0, 3, 2),
            Lists.newArrayList(0, 0, 3, 0, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 2, 0, 4, 0, 0, 0, 5),
            Lists.newArrayList(9, 0, 0, 1, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 2, 5, 3, 0, 0, 0),
            Lists.newArrayList(1, 0, 7, 4, 0, 0, 0, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 0, 5, 4, 0, 0),
            Lists.newArrayList(8, 6, 0, 0, 0, 0, 7, 0, 0),
            Lists.newArrayList(0, 0, 0, 0, 6, 0, 0, 1, 0)
    ));

    /**
     * 生成谜题
     */
    public static SudokuPuzzle generate(int sureNumber) {
        if (sureNumber < 0 || sureNumber > 81) {
            throw new IllegalArgumentException();
        }
        final Random random = new Random();
        final Context context = new Context(puzzleZero);
        final List<Integer> nos = Stream.iterate(1, x -> x + 1).limit(9 * 9).collect(Collectors.toList());
        for (int i = 0; i < sureNumber; i++) {
            // 获取随机的一个格子
            final BoxNumber randomBoxNumber = context.getBoxNumber(nos.remove(random.nextInt(nos.size())));
            // 计算格子可能的数值
            final List<Integer> possibleNumber = new ArrayList<>(Sudoku.possibleNumber(context, randomBoxNumber));
            if (possibleNumber.isEmpty()) {
                i--;
                continue;
            }
            // 从可能数值中，随机选择一个进行填写
            final Integer randomNumber = possibleNumber.get(random.nextInt(possibleNumber.size()));
            randomBoxNumber.sure(randomNumber);
        }
        return context.toPuzzle();
    }

    /**
     * 生成谜题
     * @param sureNumber
     * @param attempts 尝试次数
     */
    public static SudokuPuzzle generate(int sureNumber, int attempts, boolean unique) {
        for (int i = 0; i < attempts; i++) {
            try {
                final SudokuPuzzle puzzle = generate(sureNumber);
                if (unique) {
                    return unique(puzzle);
                } else {
                    if (new Sudoku(puzzle).solve(1).isEmpty()) {
                        continue;
                    }
                    return puzzle;
                }
            } catch (Exception ignore) {
            }
        }
        throw new IllegalStateException("生成失败");
    }

    public static SudokuPuzzle unique(SudokuPuzzle puzzle) {
        final Sudoku sudoku = new Sudoku(puzzle);
        final List<SudokuPuzzle> answers = sudoku.solve(2);
        if (answers.isEmpty()) {
            System.out.println("1");
            throw new IllegalStateException("生成失败");
        } else if(answers.size() == 1) {
            System.out.println("2");
            return puzzle;
        } else {
            System.out.println("3");
            final SudokuPuzzle sudokuPuzzle = sudoku.solveOneStep();
            return unique(sudokuPuzzle);
        }
    }

    public static void main(String[] args) {
        final SudokuPuzzle puzzle = generate(25, 100, true);
        System.out.println(puzzle);
    }
}
