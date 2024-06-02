package RecursionQuestions;

import java.util.ArrayList;

public class PhoneNumber {
    public static void main(String[] args){
        ArrayList<String> ans = letterCombinations("234");
        System.out.println(ans.toString());
    }

    static ArrayList<String> letterCombinations(String digits){
        String[] numberMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> list = new ArrayList<>();
        return combinations(digits, 0, "", list, numberMap);
    }

    static ArrayList<String> combinations(String digits, int index, String st, ArrayList<String> list, String[] numberMap){
        if(index == digits.length()){
            list.add(st);
        } else {
            int target = Character.getNumericValue(digits.charAt(index));
            String targetSt = numberMap[target];

            for(int i = 0; i<targetSt.length(); i++){
                combinations(digits, index + 1, st+targetSt.charAt(i), list, numberMap);
            }
        }

        return list;
    }
}
