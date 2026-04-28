import java.util.Scanner;

public class CharArrayProgram {


    static char[] getChars(String str) {

        char[] arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        return arr;
    }

  
    static boolean compareArrays(char[] a, char[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String text = sc.next();

        char[] userArray = getChars(text);
        char[] builtInArray = text.toCharArray();

        boolean result = compareArrays(userArray, builtInArray);

        System.out.print("User-defined array: ");
        for (char c : userArray)
            System.out.print(c + " ");

        System.out.print("\nBuilt-in array: ");
        for (char c : builtInArray)
            System.out.print(c + " ");

        System.out.println("\nAre both arrays equal? " + result);
    }
}
