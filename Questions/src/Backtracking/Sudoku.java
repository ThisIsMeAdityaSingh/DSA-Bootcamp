package Backtracking;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args){
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean ans = solveSudoku(board, 0, 0);
        System.out.println(ans);
    }

    static boolean isSafe(char[][] board, int x, int y, char target){
        // 1. each digit must occur once in a row.
        for(int i = 0; i<board[x].length; i++){
            if(board[x][i] == target){
                return false;
            }
        }

        // 2. each digit must occur once in a col
        for(int i = 0; i<board.length; i++){
            if(board[i][y] == target){
                return false;
            }
        }

        // 3. each digit must occur once in that 3x3 box.
        int startX = x / 3 * 3;
        int startY = y / 3 * 3;

        for(int i = startX; i < startX + 3; i++){
            for(int j = startY; j < startY + 3; j++){
                if(board[i][j] == target){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solveSudoku(char[][] board, int row, int col) {
        if(row >= board.length){
            for(int i = 0; i<9; i++){
                System.out.println(Arrays.toString(board[i]));
            }
            return true;
        }

        if (col >= board[0].length){
            return solveSudoku(board, row + 1, 0);
        }

        // placing number
        if(board[row][col] == '.'){
            for(int i = 1; i<=9; i++){
                char num = (char)(i + '0');
                if(isSafe(board, row, col, num)){
                    // placing
                    board[row][col] = num;

                    if(solveSudoku(board, row, col + 1)){
                        return true;
                    }

                    board[row][col] = '.';
                }
            }
        } else {
            return solveSudoku(board, row, col + 1);
        }

        return false;
    }
}
