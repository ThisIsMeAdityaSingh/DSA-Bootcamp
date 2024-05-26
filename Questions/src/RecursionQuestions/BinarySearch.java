package RecursionQuestions;

public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {5,6,7,8,9,1,2,3};

        // 1. If number you are searching for is smaller than first and last element, you need
        //    to search in the smaller half of the array.
        // 2. If number is greater than both, you need to search in the greater half.

        /**
         * Algo
         * 1. Check of the array is rotated or not (first element is smaller than last-> not rotated).
         * 2. If not rotated do normal binary search.
         * 3. If rortated, do modified binary search.
         */

        int targetIndex = rotatedBinarySearch(arr, 7);
        System.out.println(targetIndex);
    }

    static int rotatedBinarySearch(int[] arr, int target){
        if(arr[0] < arr[arr.length - 1]){
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        // find the dip
        int largestNumberIndex = findTheDip(arr, 0, arr.length - 1);

        if(target <= arr[largestNumberIndex] && target > arr[arr.length - 1]){
            return binarySearch(arr, target, 0, largestNumberIndex);
        }

        return binarySearch(arr, target, largestNumberIndex + 1, arr.length - 1);
    }

    /**
     * Will return the index of largest number in the array.
     */
    static int findTheDip(int[] arr, int start, int end){
        if(start > end) {
            return -1;
        }

        int middle = start + ((end - start) / 2);

        if(arr[middle] > arr[middle + 1]){
            return middle;
        }

        if(arr[middle] > arr[0] && arr[middle] > arr[arr.length - 1]){
            return findTheDip(arr, middle + 1, end);
        }

        return findTheDip(arr, start, middle - 1);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }

        int middle = start + ((end - start) / 2);

        if (arr[middle] == target){
            return middle;
        }

        if(arr[middle] < target){
            return binarySearch(arr, target, middle + 1, end);
        }

        return binarySearch(arr, target, start, end - 1);
    }
}
