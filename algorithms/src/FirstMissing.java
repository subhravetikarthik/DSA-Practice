import java.util.HashSet;
import java.util.Set;

/** Given unsorted integer array A of size N. Find the first missing positive integer.
    Note: Algorithm should run in O(n) time and constant space.

    Constraints: 1 <= N <= 10^5
 **/

public class FirstMissing {

    public static void main(String[] args) {

        int[] A = {3,4,-1, 1};
        int ans = bruteForceSolution(A);
        System.out.println(ans);
    }

    // Idea: Add all positive elements from the array to hashset
    // Iterate from 1-N (len of array) and find the missing positive integer.
    public static int bruteForceSolution(int[] A) {
        int ans = Integer.MIN_VALUE;
        int N = A.length;
        Set<Integer> hs = new HashSet<>();

        // add array elements > 0 into hashset
        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                hs.add(A[i]);
            }
        }

        // iterate over 1-N to find first missing positive integer
        for(int i = 1; i <= N; i++) {
            if(!hs.contains(i)) {
                ans = i;
            }
        }

        return ans;
    }
    // T.C => O(N) && S.C => O(N)
}
