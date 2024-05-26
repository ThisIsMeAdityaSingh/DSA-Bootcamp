package RecursionQuestions;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args){
        ArrayList<Integer> indexes = new ArrayList<>();
        int[] arr = {1,2,3,4,4,5,6,7};
        ArrayList<Integer> answer = linearSearch(arr, 0, 4, indexes);

        System.out.println(answer.toString());
    }

    static ArrayList<Integer> linearSearch(int[] arr, int i, int target, ArrayList<Integer> indexes){
        if(i >= arr.length){
            return indexes;
        }

        if(arr[i] == target){
            indexes.add(i);
            return linearSearch(arr, i+1, target, indexes);
        }

        return linearSearch(arr, i+1, target, indexes);
    }
}
