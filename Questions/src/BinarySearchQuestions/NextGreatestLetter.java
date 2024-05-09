package BinarySearchQuestions;

/**
 * Leetcode URL - https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * You are given an array of characters letters that is sorted in non-decreasing order, and a character
 * target. There are at least two different characters in letters.
 * Return the smallest character in letters that is lexicographically greater than target.
 * If such a character does not exist, return the first character in letters.
 */
public class NextGreatestLetter {
    public static  void main(String[] args){
        char[] letters = {'x', 'x', 'y', 'y'};
        char target = 'z';

        char solution = nextGreatestLetter(letters, target);
        System.out.println(solution);
    }

    static char nextGreatestLetter(char[] letters, char target){
        // 1. We will apply binary search. To find the smallest letter greater than the target
        int index = binarySearch(letters, target);
        return letters[index];
    }

    static int binarySearch(char[] letters, char target){
        int start = 0;
        int end = letters.length - 1;

        while (start <= end){
            int middle = start + ((end - start) / 2);

            if (target > letters[middle]){
                start = middle + 1;
            } else if (target < letters[middle]) {
                end = middle - 1;
            } else {
                // condition might arise that middle may actually be the last element.
                // in that case, we need to return the 1st element.
                if(middle < letters.length - 1){
                    return middle + 1;
                }
                return 0;
            }
        }

        // condition might arise that start is out of bounds, in that case we
        // have to return the 1st element.
        if (start >= letters.length){
            return 0;
        }
        return start;
    }
}
