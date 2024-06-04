package Backtracking;

public class ObstaclePaths {
    public static void main(String[] args){
        int N = 3;
        int targetX = 2, targetY = 2;
        int obX = 1, obY = 1;
        int x = 0, y = 0;

        int ans = numberOfWays(x, y, targetX, targetY, N, obX, obY);
        System.out.println(ans);
    }

    static int numberOfWays(int x, int y, int targetX, int targetY, int N, int obX, int obY){
        // checking for out of bound
        if(x < 0 || y < 0 || x >= N || y>= N){
            return 0;
        }

        // if current position is an obstacle
        if(x == obX && y == obY){
            return 0;
        }

        if (x == targetX && y == targetY){
            return 1;
        }

        int goRight = numberOfWays(x+1, y, targetX, targetY, N, obX, obY);
        int goDown = numberOfWays(x, y+1, targetX, targetY, N, obX, obY);

        return goDown + goRight;
    }
}
