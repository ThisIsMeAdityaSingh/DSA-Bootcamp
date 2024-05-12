import java.util.ArrayList;
import java.lang.StringBuilder;

public class StringConcepts {
    public static void main(String[] args){
        String name = "Aditya";
        String name1 = "Aditya";

        System.out.println("CASE 1");
        System.out.println(name == name1);
        System.out.println(name.equals(name1));


        System.out.println("CASE 2");
        String str = new String("AdityaSingh");
        String str2 = new String("AdityaSingh");

        System.out.println(str == str2);
        System.out.println(str.equals(str2));

        System.out.println("Aditya Singh");

        float num = 453.12434f;
        System.out.printf("The formatted number is %.3f \n", num);
        System.out.printf("Hi my name is %s, and I am a %s \n", "Aditya", "SWE");

        // String concatenation
        int newCh = 'a' + 'b'; //char types are converted to ASCII values and then added
        System.out.println(newCh);

        String newSt = "a" + "b"; // if data type is String they are concatenated.
        System.out.println(newSt);

        // adding char and integer
        int newSum = 'a' + 3;
        System.out.println(newSum);

        // adding a string with integer
        // behind the scenes int is converted into it's wrapper class Integer, and .toString() method
        // is called on it, to convert that into it's equivalent string, and then it is concatenated.
        String st = "a" + 1;
        System.out.println(st);

        // hell, we can add any objects together, as long as that object supports ".toString()" method
        // as long as one of the object is string.
        String st1 = "Aditya" + new ArrayList<>();
        System.out.println(st1);

        // String Builder
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i<26; i++){
            char ch = (char) ('a' + i);
            builder.append(ch);
        }

        System.out.println(builder);
    }
}
