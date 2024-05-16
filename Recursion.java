public class Recursion {
    public static void main(String[] args){
        int ans = nthFibonacci(8);
        System.out.println(ans);
    }

    static int nthFibonacci(int n){
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        if (start > end){
            return -1;
        }

        int middle = start + ((end - start) / 2);

        if (arr[middle] == target){
            return target;
        }

        if (target < arr[middle]){
            return binarySearch(arr, target, start, middle - 1);
        }

        return binarySearch(arr, target, middle + 1, end);
    }
}
