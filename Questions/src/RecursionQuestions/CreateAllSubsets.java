package RecursionQuestions;

import java.util.ArrayList;

public class CreateAllSubsets {
    public static void main(String[] args){
        // prints all possible subsets of a given string.
        String str = "abc";
        ArrayList<String> list = new ArrayList<>();
        String holder = "";

        ArrayList<String> answer = subsets(str, holder, list);
        System.out.println(answer.toString());
    }

    static ArrayList<String> subsets(String str, String holder, ArrayList<String> list){
        if(str.isEmpty()){
            list.add(holder);
        } else {
            char flagged = str.charAt(0);
            String newStr = str.substring(1);

            // case 1: taking value
            subsets(newStr, holder + flagged, list);

            // case 2: ignoring value
            subsets(newStr, holder, list);
        }

        return list;
    }
}
