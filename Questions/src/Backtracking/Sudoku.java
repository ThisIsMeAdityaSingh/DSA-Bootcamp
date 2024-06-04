package Backtracking;

public class Sudoku {
    public static void main(String[] args){

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
        int startX = x % 3;
        int endX = startX + 3;

        int startY = y % 3;
        int endY = startY + 3;

        for(int i = startX; i<endX; i++){
            for(int j = startY; j<endY; j++){
                if(board[i][j] == target){
                    return false;
                }
            }
        }

        return true;
    }

    static void solveSudoku(char[][] board) {

    }
}
