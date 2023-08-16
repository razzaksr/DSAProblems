package problems.dsa.days.day2;

public class AssignCountTimesOfPatterns {
    // Function to count the number of times pattern `Y[0…n)`
    // appears in a given string `X[0…m)` as a subsequence
    public static int count(String X, String Y, int m, int n)
    {
        // Base case 1: if only one character is left
        if (m == 1 && n == 1) {
            return (X.charAt(0) == Y.charAt(0)) ? 1: 0;
        }

        // Base case 2: if the input string `X` reaches its end
        if (m == 0) {
            return 0;
        }

        // Base case 3: if pattern `Y` reaches its end, we have found
        // subsequence
        if (n == 0) {
            return 1;
        }

        // Optimization: the solution is not possible if the number of characters
        // in the string is less than the number of characters in the pattern
        if (n > m) {
            return 0;
        }

        /*
          If the last character of both string and pattern matches,
            1. Exclude the last character from both string and pattern
            2. Exclude only the last character from the string.

          Otherwise, if the last character of the string and pattern do not match,
          recur by excluding only the last character in the string
        */

        return ((X.charAt(m - 1) == Y.charAt(n - 1)) ? count(X, Y, m - 1, n - 1) : 0)
                + count(X, Y, m - 1, n);
    }

    public static void main(String[] args)
    {
        String X = "subsequence";   // input string
        String Y = "su";           // pattern

        System.out.print(count(X, Y, X.length(), Y.length()));
    }
}
