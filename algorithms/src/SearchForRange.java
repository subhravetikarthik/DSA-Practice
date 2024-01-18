/**
 * Given a sorted array of integers A (0-indexed) of size N,
 * find the left most and the right most index of a given integer B in the array A.
 * <br/>
 * Return an array of size 2, such that
 *           First element = Left most index of B in A
 *           Second element = Right most index of B in A.
 * If B is not found in A, return [-1, -1].
 * Note : Your algorithm's runtime complexity must be in the order of O(log n).
 */

/**
 * Problem Constraints
 * 1 <= N <= 106
 * 1 <= A[i], B <= 109
 */
public class SearchForRange {
    public static void main(String[] args) {
        int[] A = {1, 7, 7, 7, 7, 6};
        int B = 1;

        int[] res = bruteForceApproach(A, B);
        System.out.println("Using brute force approach: {" + res[0] + ", " + res[1] + "}");

        int[] resOpt = optimizedApproach(A, B);
        System.out.println("Using binary search approach: {" + resOpt[0] + ", " + resOpt[1] + "}");

    }

    // Idea:
    // Keep track of the first and last occurrence of the element.
    // and return that indices.

    // T.C => O(N), S.C => O(1)
    public static int[] bruteForceApproach(int[] A, int B) {
        int leftIdx = -1;
        int rightIdx = -1;
        int[] ans = new int[2];

        // find left most occurrence of B in A[].
        for(int i = 0; i < A.length; i++) {
            if(A[i] == B) {
                leftIdx = i;
                break;
            }
        }

        // find right most occurrence of B in A[].
        for(int i = A.length-1; i >=0; i--) {
            if(A[i] == B) {
                rightIdx = i;
                break;
            }
        }

        ans[0] = leftIdx;
        ans[1] = rightIdx;

        return ans;
    }

    // Approach 2: Use binary search to find the first and last occurrence idx of the element.
    // and return that indices.

    // T.C => O(log N), S.C => O(1)
    public static int[] optimizedApproach(int[] A, int B) {
        int leftIdx = -1;
        int rightIdx = -1;
        int[] ans = new int[2];

        // use bs to find left most occurrence of B in A[].
        int left = 0;
        int right = A.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(A[mid] == B) {
                leftIdx = mid;
                right = mid - 1;
            } else if(A[mid] > B) {
                // go left
                right = mid - 1;
            } else {
                // go right
                left =  mid + 1;
            }
        }
        ans[0] = leftIdx;

        // use bs to find right most occurrence of B in A[].
        left = 0;
        right = A.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(A[mid] == B) {
                rightIdx = mid;
                left = mid + 1;
            } else if(A[mid] > B) {
                // go left
                right = mid - 1;
            } else {
                // go right
                left =  mid + 1;
            }
        }
        ans[1] = rightIdx;

        return ans;
    }
}
