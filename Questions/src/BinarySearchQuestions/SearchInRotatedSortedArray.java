package BinarySearchQuestions;

public class SearchInRotatedSortedArray {
    public static void main(String[] args){
        int[] nums = {4,5,6,7,7,0,1,2};
        int target = 0;

        int targetIndex = search(nums, target);
        System.out.println(targetIndex);
    }

    static int findDip(int[] arr){
        if (arr[0] < arr[arr.length - 1]){
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int middle = start + ((end - start) / 2);

            if (arr[middle] > arr[middle + 1]){
                return middle;
            } else if (arr[middle] > arr[0]) {
                start = middle + 1;
            } else if (arr[middle] < arr[0]) {
                end = middle - 1;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while (start <= end){
            int middle = start + ((end - start) / 2);

            if (arr[middle] == target){
                return middle;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else if (target < arr[middle]) {
                end = middle - 1;
            }
        }

        return -1;
    }

    static int search(int[] arr, int target){
        if (arr.length == 1){
            if (arr[0] != target){
                return -1;
            }
            return 0;
        }

        int largestElementIndex = findDip(arr);

        if (largestElementIndex == -1){
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        if (target <= arr[largestElementIndex] && target >= arr[0]){
            return binarySearch(arr, target, 0, largestElementIndex);
        }

        return binarySearch(arr, target, largestElementIndex + 1, arr.length - 1);
    }
}
