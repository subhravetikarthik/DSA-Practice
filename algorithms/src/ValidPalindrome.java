/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 * letters and removing all non-alphanumeric characters, it reads the same forward
 * and backward. Alphanumeric characters include letters and numbers.
 <br/>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */

/** Sample
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "race a car";
        boolean res = isPalindrome(s);
        System.out.println(s + " is " + (res ? "a valid" : "not a valid") + " palindrome!");
    }

    public static boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.trim().isEmpty()) return true;

        s = removeAllNonAlphaNumericChars(s);

        int l = 0;
        int r = s.length()-1;

        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static String removeAllNonAlphaNumericChars(String s) {
        s = s.toLowerCase(); // convert to lowercase
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
