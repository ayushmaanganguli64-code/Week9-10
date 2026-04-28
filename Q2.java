import java.util.Scanner;

public class SplitTextProgram {

    
    static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }


    static int countWords(String str) {
        int count = 1; 

        for (int i = 0; i < findLength(str); i++) {
            if (str.charAt(i) == ' ')
                count++;
        }
        return count;
    }

 
    static String[] splitText(String str) {

        int length = findLength(str);
        int wordCount = countWords(str);

        int[] spaceIndex = new int[wordCount - 1];
        int idx = 0;

        
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndex[idx++] = i;
            }
        }

        String[] words = new String[wordCount];

        int start = 0;

        for (int i = 0; i < wordCount; i++) {

            int end;

            if (i < wordCount - 1)
                end = spaceIndex[i];
            else
                end = length;

            String word = "";

            for (int j = start; j < end; j++) {
                word += str.charAt(j);
            }

            words[i] = word;
            start = end + 1;
        }

        return words;
    }

   
    static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] userWords = splitText(text);
        String[] builtInWords = text.split(" ");

        boolean result = compareArrays(userWords, builtInWords);

        System.out.println("\nUser-defined split:");
        for (String w : userWords)
            System.out.println(w);

        System.out.println("\nBuilt-in split:");
        for (String w : builtInWords)
            System.out.println(w);

        System.out.println("\nAre both results same? " + result);
    }
}
