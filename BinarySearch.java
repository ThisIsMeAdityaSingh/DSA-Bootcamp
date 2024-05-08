public class BinarySearch {
    public static void main(String[] args){
        int[] arr = {-4, -3, -2, -2, -1, 1,2,3,4,5,6,7,8,9,90,100,123,1234,1234567,12345344};
        int target = 12345344;

        int indexOfTarget = binarySearch(arr, target);
        System.out.println(indexOfTarget);
    }

    /**
     * Return index if the target is found, else returns -1
     * @param arr int[]
     * @param target int
     * @return int
     */
    static int binarySearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }

        if(arr.length == 1){
            if(arr[0] == target){
                return 0;
            }

            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int middle = start + ((end - start) / 2);

            if (target > arr[middle]){
                start = middle + 1;
            } else if (target < arr[middle]){
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    /**
     * FOR ELEMENTS SORTED IN DESCENDING ORDER.
     * Return index if the target is found, else returns -1
     * @param arr int[]
     * @param target int
     * @return int
     */
    static int binarySearchDesc(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }

        if(arr.length == 1){
            if(arr[0] == target){
                return 0;
            }
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int middle = start + ((end - start)/2);

            if (target > arr[middle]){
                end = middle - 1;
            } else if (target < arr[middle]){
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
