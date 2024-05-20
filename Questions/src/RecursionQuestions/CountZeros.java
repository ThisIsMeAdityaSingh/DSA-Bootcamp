package RecursionQuestions;

public class CountZeros {
    public static void main(String[] args){
        int result = countZeros(100010, 0);
        System.out.println(result);
    }

    static int countZeros(int num, int count){
        if(num == 0){
            return count;
        }

        int lastDigit = num % 10;
        int newNum = num / 10;

        if (lastDigit == 0){
            count = count + 1;
        }

        return countZeros(newNum, count);
    }
}
