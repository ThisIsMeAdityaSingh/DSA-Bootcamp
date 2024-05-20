package RecursionQuestions;

public class ReverseNumber {
    public static void main(String[] args){
        int rev = reverseNum(9, 0);
        System.out.println(rev);
    }

    static int reverseNum(int num, int revNum){
        if(num == 0){
            return revNum;
        }

        int lastDigit = num % 10;
        revNum = revNum * 10 + lastDigit;

        int remNum = num / 10;

        return reverseNum(remNum, revNum);
    }
}
