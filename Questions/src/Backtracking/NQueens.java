package Backtracking;

import java.util.Arrays;

public class NQueens {
    public static void main(String[] args){
        char[][] board = {
                {'.','.','.','.'},
                {'.','.','.','.'},
                {'.','.','.','.'},
                {'.','.','.','.'}
        };

        nQueens(board, 0);
    }

    static boolean isInBounds(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x >= board[0].length || y >= board.length){
            return true;
        }

        return false;
    }

    static boolean isSafe(char[][] board, int x, int y){
        // 1. cannot place a queen on same row as others.
        for(int i = 0; i<board[x].length; i++){
            if (board[x][i] == 'Q'){
                return false;
            }
        }
        // 2. cannot place a queen on same col as others.
        for(int i = 0; i< board.length; i++){
            if (board[i][y] == 'Q'){
                return false;
            }
        }
        // 3. please check for diagonals.
        int[][] dirs = {
                {1, -1},
                {-1, -1},
                {1, 1},
                {-1, 1}
        };

        for(int i = 0; i< dirs.length; i++){
            int dirX = dirs[i][0];
            int dirY = dirs[i][1];

            int nX = x;
            int nY = y;

            while (!isInBounds(board, nX, nY)){
                if(board[nX][nY] == 'Q'){
                    return false;
                }

                nX = nX + dirX;
                nY = nY + dirY;
            }
        }

        return true;
    }

    static boolean nQueens(char[][] board, int row){
        if(row >= board.length){
            for(int i = 0; i< board.length; i++){
                System.out.println(Arrays.toString(board[i]));
            }

            return true;
        }

        for(int i = 0; i<board[row].length; i++){
            // checking if position is safe or not.
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';

                if (nQueens(board, row + 1)){
                    return true;
                }

                // back track
                board[row][i] = '.';
            }
        }

        return false;
    }
}
