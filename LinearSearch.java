public class LinearSearch {
    public static void main(String[] args){
        int[] nums = {1,4,2,425,6563,324,6536,13246,765723,1234,976};
        int target = 1234;
        
        int result = linearSearch(nums, target);
        System.out.println(result);

        int minNumber = findMinNumber(nums);
        System.out.println(minNumber);

        String name = "adityasingh";
        char targetChar = 's';

        int res = linearSearchInString(name, targetChar);
        System.out.println(res);

        int[] numArr = {123456, 123,345,4567,45,7890,7,78,789,765};
        int evenNumbers = findNumbersWithEventDigits(numArr);
        System.out.println(evenNumbers);
    }

    // for integer array
    static int linearSearch(int[] arr, int target){
        // condition 1: If empty array return -1
        if(arr.length == 0){
            return -1;
        }
        
        // looping through the array, if element found we will return the index, else -1
        for(int i = 0; i<arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }
        
        // no element that is equal to target was found. returning -1
        return -1;
    }

    static int linearSearchInString(String str, char target){
        // condition 1: if given an empty string
        if (str.isEmpty()){
            return -1;
        }

        // searching through the string
        for(int i = 0; i<str.length(); i++){
            char charAtI = str.charAt(i);

            if(charAtI == target){
                return i;
            }
        }

        // no such character found in string
        return -1;
    }

    static int findMinNumber(int[] arr){
        if (arr.length == 0){
            return Integer.MAX_VALUE;
        }

        int flag = Integer.MAX_VALUE;

        // looping through array, updating flag anytime we encounter a new minimum
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < flag){
                flag = arr[i];
            }
        }

        return flag;
    }

    static int findNumbersWithEventDigits(int[] arr){
        // condition 1: if array is empty, we return 0
        if (arr.length == 0){
            return 0;
        }

        int count = 0;
        for(int num: arr){
            if(numberOfDigits(num) % 2 == 0){
                count = count + 1;
            }
        }

        return count;
    }

    private static boolean isEven(int num){
        if(num == 0){
            return false;
        }

        if(num < 0){
            num = num * -1;
        }

        int count = 0;

        while (num > 0){
            count = count + 1;

            num = num / 10;
        }

        return count % 2 == 0;
    }

    private static int numberOfDigits(int num){
        if(num == 0) return 1;
        if(num < 0){
            num = num * -1;
        }
        return (int) (Math.log10(num)) + 1;
    }
}
