/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different
 * word or phrase, typically using all the original letters exactly once.
 */
public class ValidAnagram {

    public static void main(String[] args) {

        String s = "car";
        String t = "rat";
        boolean res = approach2(s, t);
        System.out.println(res);
    }

    public static boolean approach2(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
