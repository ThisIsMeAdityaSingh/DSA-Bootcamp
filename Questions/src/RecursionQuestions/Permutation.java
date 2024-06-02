package RecursionQuestions;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args){
        String str = "abcd";
        String holder = "";
        ArrayList<String> list = new ArrayList<>();

        ArrayList<String> answer = permutation(str, holder, list);
        System.out.println(answer.toString());
    }

    static ArrayList<String> permutation(String str, String holder, ArrayList<String> list){
        if(str.isEmpty()){
            list.add(holder);
        } else {
            String target = str.substring(0, 1);
            String newStr = str.substring(1);

            for(int i = 0; i<=holder.length(); i++){
                String holderString = holder.substring(0, i) + target + holder.substring(i);
                permutation(newStr, holderString, list);
            }
        }

        return list;
    }
}
