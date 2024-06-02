package RecursionQuestions;

import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args){
        // int number = numberOfWays(4, "");
        // System.out.println("Number of ways " + number);

        ArrayList<String> holder = new ArrayList<>();
        ArrayList<String> ans = printAllWays(4, "", holder);
        System.out.println(ans);
    }

    static int numberOfWays(int target, String st){
        if(target == 0){
            System.out.println(st);
            return 1;
        }

        int count = 0;
        for(int i = 1; i<=6 && i <= target; i++){
            count = count + numberOfWays(target - i, st + i);
        }

        return count;
    }

    static ArrayList<String> printAllWays(int target, String st, ArrayList<String> ans){
        if(target == 0){
            ans.add(st);
        } else {
            for(int i = 1; i<=6 && i <= target; i++){
                printAllWays(target - i, st+i, ans);
            }
        }

        return ans;
    }
}
