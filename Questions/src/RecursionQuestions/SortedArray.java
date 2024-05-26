package RecursionQuestions;

public class SortedArray {
    public static void main(String[] args){
        boolean result = isArraySorted(new int[] {1, 2, 3, 4, 5, 6});
        System.out.println(result);
    }

    static boolean isArraySorted(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        if (start == end){
            return true;
        }

        int low = nums[start];
        int high = nums[end];

        return helper(nums, start, end, low, high);
    }

    static boolean helper(int[] nums, int start, int end, int low, int high){
        if(start > end){
            return true;
        }

        if(nums[start] > nums[end]){
            return false;
        }

        if (nums[start] < low || nums[start] > high){
            return false;
        }

        if(nums[end] < low || nums[end] > high){
            return false;
        }

        low = nums[start];
        high = nums[end];
        // all cases passed
        // updating the values
        start = start + 1;
        end = end - 1;

        return helper(nums, start, end, low, high);
    }
}
