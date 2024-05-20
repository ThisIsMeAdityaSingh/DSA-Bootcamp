package RecursionQuestions;

public class NumberOfSteps {
    public static void main(String[] args){
        int result = numberOfSteps(8, 0);
        System.out.println(result);
    }

    // if step is even -> divide it by two.
    // if step is odd -> subtract 1 from it.
    static int numberOfSteps(int num, int steps){
        if (num == 0){
            return steps;
        }

        if (num % 2 == 0){
            return numberOfSteps(num / 2, steps + 1);
        }

        return numberOfSteps(num - 1, steps + 1);
    }
}
