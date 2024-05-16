package RecursionQuestions;

public class SumOfDigits {
    public static void main(String[] args){
        int ans = digitSum(12034);
        System.out.println(ans);
    }

    static int digitSum(int n){
        if (n == 0){
            return 0;
        }

        int rem = n % 10;
        int newNum = n / 10;

        int ans = rem + digitSum(newNum);

        return ans;
    }
}
