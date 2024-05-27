import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }

        int middle = (start + end) / 2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        merge(arr, start, middle, end);
    }

    static void merge(int[] arr, int start, int middle, int end){
        int[] merged = new int[end - start + 1];

        int left = start;
        int right = middle + 1;
        int i = 0;

        while (left <= middle && right <= end){
            if (arr[left] < arr[right]){
                merged[i] = arr[left];
                left++;
            } else {
                merged[i] = arr[right];
                right++;
            }
            i++;
        }

        while (left <= middle){
            merged[i++] = arr[left++];
        }

        while (right <= end){
            merged[i++] = arr[right++];
        }

        // now modifying the original array
        for (i = 0; i < merged.length; i++) {
            arr[start + i] = merged[i];
        }
    }
}
