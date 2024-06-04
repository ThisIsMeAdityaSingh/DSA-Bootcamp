package Backtracking;

public class NumberOfWays {
    public static void main(String[] args){
        int N = 3;
        int targetX = 2, targetY = 2;
        int x = 0, y = 0;

        int numWays = numberOfWays(x, y, targetX, targetY, N);
        System.out.println(numWays);
        printAllPaths(x, y, targetX, targetY, N, "");
    }

    /**
     * You are given an N x N matrix. You need the find the number of ways you can reach a certain position
     * Rules:
     * 1. You can only travel in two directions. Right and down.
     */
    static int numberOfWays(int x, int y, int targetX, int targetY, int N){
        if(x < 0 || y < 0 || x >= N || y >= N){
            return 0;
        }

        if(x == targetX || y == targetY){
            return 1;
        }

        int goRight = numberOfWays(x + 1, y, targetX, targetY, N);
        int goDown = numberOfWays(x, y + 1, targetX, targetY, N);

        return goDown + goRight;
    }

    static void printAllPaths(int x, int y, int targetX, int targetY, int N, String path){
        if(x < 0 || y < 0 || x >= N || y >= N){
            return;
        }

        if(x == targetX){
            StringBuilder newPath = new StringBuilder(path);

            while (y != targetY){
                newPath.append('D');
                y++;
            }

            System.out.println(newPath);
            return;
        }

        if(y == targetY){
            StringBuilder newPath = new StringBuilder(path);

            while (x != targetX){
                newPath.append('R');
                x++;
            }

            System.out.println(newPath);
            return;
        }

        // go right
        printAllPaths(x + 1, y, targetX, targetY, N, path + "R");

        // go down
        printAllPaths(x, y + 1, targetX, targetY, N, path + "D");
    }
}
