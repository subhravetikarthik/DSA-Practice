/**
 * Problem Statement
 * You are given a sorted array A of size N and a target value B.
 * Your task is to find the index (0-based indexing) of the target value in the array.
 * <br/>
 * If the target value is present, return its index.
 * If the target value is not found, return the index of least element greater than equal to B.
 * Your solution should have a time complexity of O(log(N)).
 */

/**
 * Problem Constraints
 * 1 <= N <= 10^5
 * 1 <= A[i] <= 10^5
 * 1 <= B <= 10^5
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        int B = 5;

        int res = bruteForceApproach(A, B);
        System.out.println("Using bruteforce approach: " + res);

        int ans = optimizedApproach(A, B);
        System.out.println("Using binary search approach: " + ans);
    }

    // Approach 1:
    // Idea: Iterate over the entire array to find the target in the array
    // T.C = O(N), S.C = O(N)
    private static int bruteForceApproach(int[] A, int B) {
        int ans = -1;
        int minIdx = Integer.MAX_VALUE;

        int start = 0;
        int end = A.length-1;

        while(start <= end) {
            if(A[start] == B) {
                ans = start;
                break;
            } else if(A[start] > B) {
                minIdx = Math.min(start, minIdx);
                ans = minIdx;
            }
            start++;
        }
        return ans;
    }

    // Approach 2:
    // Idea: As we know for fact the array is already sorted,
    // we can make use of binary search to find the target in the input array
    // T.C = O(log N), S.C = O(1)

    private static int optimizedApproach(int[] A, int B) {
        int ans = -1;
        int left = 0;
        int right = A.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(A[mid] == B) {
                ans = mid;
                return ans;
            } else if(A[mid] > B) {
                // go left
                right = mid - 1;
                ans = mid;
            } else {
                // go right
                left = mid + 1;
               // ans = left;
            }
        }
        return ans;
    }
}
