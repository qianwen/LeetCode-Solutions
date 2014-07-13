import java.util.*;

// Reverse Words in a String 
//Given s = "the sky is blue",
//return "blue is sky the".

public class ReverseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        System.out.println(reverseWords(text));
    }

    public static String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }

        String[] array = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i =  array.length - 1; i >= 0; i--) {
            sb.append(array[i]);

            if (i != 0) {
                sb.append(" ");
            } 
        }
        
        return sb.toString();
    }
}