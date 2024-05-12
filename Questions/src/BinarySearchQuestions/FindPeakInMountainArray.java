package BinarySearchQuestions;

public class FindPeakInMountainArray {
    public static void main(String[] args){
        int[] nums = {0,1,2,3,4,5,6,7,9,6,5};
        int peakIndex = findPeakInMountainArray(nums);
        System.out.println(peakIndex);
    }

    // does not handle duplicate entries well.
    // to handle that -> change ">" or "<" sign to ">=" or "<=" where necessary.
    static int findPeakInMountainArray(int[] arr){
        // 1. if we are at index i, if arr[i-1] < arr[i] < arr[i+1] -> move right
        // 2. if we are at index i, if arr[i-1] > arr[i] > arr[i+1] -> move left

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int middle = start + ((end - start) / 2);

            if (arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]){
                return middle;
            } else if (arr[middle - 1] < arr[middle] && arr[middle] < arr[middle + 1]) {
                start = middle + 1;
            } else if (arr[middle - 1] > arr[middle] && arr[middle] > arr[middle + 1]) {
                end = middle - 1;
            }
        }

        return -1;
    }
}
