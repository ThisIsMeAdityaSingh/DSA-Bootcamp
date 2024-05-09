package BinarySearchQuestions;

/**
 * The question is:
 * You have been given an array of sorted numbers (say, ascending in this case), and a target,
 * you need to find the number which is greater than or equal to that target from the array.
 *
 * say, arr = [1,2,3,4,5,6,9,10], target = 8
 * -> the number that is closest to being greater than or equal to 8 is 9. So answer is 9.
 *
 * say, arr = [1,2,3,4,5,6,9,10], target = 9
 * -> the number that is closest to being greater than or equal to 9 is 9. So answer is 9.
 */

public class CeilingOfANumber {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,6,9,9,10};
        int target = 11;

        int indexOfCeilingNumber = findCeilingOfNumber(arr, target);
        if(indexOfCeilingNumber < 0){
            System.out.println("No ceiling number found");
        } else {
            System.out.println(arr[indexOfCeilingNumber]);
        }
    }

    // return the index of the celing number
    static int findCeilingOfNumber(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }

        if(arr.length == 1){
            if(arr[0] >= target){
                return 0;
            }

            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int middle = start + ((end - start) / 2);

            if (target > arr[middle]){
                start = middle + 1;
            } else if (target < arr[middle]) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        if (start < arr.length){
            if(arr[start] >= target) {
                return start;
            }
        }

        return -1;
    }
}
