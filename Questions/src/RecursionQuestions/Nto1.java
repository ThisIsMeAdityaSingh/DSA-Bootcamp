package RecursionQuestions;

public class Nto1 {
    public static void main(String[] args){
        printNto1(10);
    }

    static void printNto1(int n){
        if(n == 0){
            return;
        }

        printNto1(n-1);
        System.out.println(n);
    }

}
