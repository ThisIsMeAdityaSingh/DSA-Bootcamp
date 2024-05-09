package BinarySearchQuestions;

import java.util.Arrays;

/**
 * Leetcode URL - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value. If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchRange {
    public static void main(String[] args){
        int[] nums = {5,5,7,7,8,8,10, 10};
        int target = 5;

        int[] solution = searchRange(nums, target);
        System.out.println(Arrays.toString(solution));
    }

    static int[] searchRange(int[] nums, int target){
        // Step 1: finding the 1st occurrence of target in nums. If not found, return [-1, -1]
        int orderOne = binarySearch(nums, target, 0, nums.length - 1);

        if (orderOne == -1) {
            return new int[]{-1, -1};
        }

        // Step 2: finding the left most occurrence, by reducing the end index at each iteration.
        int leftOrder = binarySearch(nums, target, 0, orderOne - 1);
        int leftIndex = orderOne;

        while (leftOrder != -1){
            leftIndex = leftOrder;
            leftOrder = binarySearch(nums, target, 0, leftOrder - 1);
        }


        int rightOrder = binarySearch(nums, target, orderOne + 1, nums.length - 1);
        int rightIndex = orderOne;

        while (rightOrder != -1){
            rightIndex = rightOrder;
            rightOrder = binarySearch(nums, target, rightOrder + 1, nums.length - 1);
        }

        return new int[]{leftIndex, rightIndex};
    }

    static int binarySearch(int[] nums, int target, int start, int end){
        // condition 1: nums is empty array
        if (nums.length == 0){
            return -1;
        }

        // condition 2: nums has a length of 1.
        if (nums.length == 1){
            if (nums[0] == target){
                return 0;
            }
            return -1;
        }

        while (start <= end){
            int middle = start + ((end - start) / 2);

            if (target > nums[middle]){
                start = middle + 1;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
