package RecursionQuestions;

public class SkipACharacter {
    public static void main(String[] args){
        StringBuilder st = new StringBuilder();
        String str = "baccad";
        char skip = 'a';
        int start = 0;

        String processedString = skipACharacter(str, skip, start, st);
        System.out.println("Skipping a character " + processedString);

        StringBuilder st1 = new StringBuilder();
        String str1 = "baccad";
        String skip1 = "ca";
        int start1 = 0;

        String processed = skipASubString(str1, skip1, start1, st1);
        System.out.println("Skipping a sub string " + processed);
    }

    static String skipACharacter(String str, char skip, int start, StringBuilder st){
        if(start == str.length()){
            return st.toString();
        }

        if(str.charAt(start) == skip){
            return skipACharacter(str, skip, start + 1, st);
        }

        st.append(str.charAt(start));
        return skipACharacter(str, skip, start + 1, st);
    }

    static String skipASubString(String str, String skip, int start, StringBuilder st){
        if(start == str.length()){
            return st.toString();
        }

        if(start + skip.length() < str.length()){
            if(str.substring(start, start + skip.length()).equals(skip)){
                return skipASubString(str, skip, start + skip.length(), st);
            }
        } else {
            st.append(str.charAt(start));
            return skipASubString(str, skip, start + 1, st);
        }

        st.append(str.charAt(start));
        return skipASubString(str, skip, start + 1, st);
    }
}
