import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Problem Statement
 * Given String A containing lowercase english letters of length N,
 * you need to sort it in decreasing order based on frequency of characters
 * and return sorted string.
 * <br/>
 * Note:
 * 1. If 2 characters have equal frequency, they should be sorted alphabetically
 * 2, The frequency of character is number of times it appears in the string.
 */

/* Problem Constraints:
 * 1 <= N <= 10^5
 * 'a' <= A[i] <= 'z'
 */

/* Expected Output
 * A = "bottle"
 * output: ttbelo
 */

class FrequencySorting {
    public static void main(String[] args) {
        String A = "bottle";
        String res = sortStringByFreq(A);
        System.out.println(res);
    }

    public static String sortStringByFreq(String A) {
        Map<Character, Integer> freqMap = new HashMap<>();
        List<Pair<Character, Integer>> list = new ArrayList<>();

        // prepare freqMap
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }

        // add items to list
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            list.add(new Pair<Character, Integer>(entry.getKey(), entry.getValue()));
        }

        // sort content of freqMap based on value
        list.sort((o1, o2) -> {
            if (o2.second.equals(o1.second)) return (o1.first).compareTo(o2.first);
            return (o2.second).compareTo(o1.second);
        });

        StringBuilder ans = new StringBuilder();

        for (Pair<Character, Integer> p : list) {
            int j = 0;
            while (j < p.second) {
                ans.append(p.first);
                j++;
            }
        }

        return ans.toString();
    }
}