/**
 * max number of 4 members families that can sit consecutively in a venue, taking into account that the 4 members must be consecutively seated in one single row, with the following context:
 * N represents the number of rows availabe.
 * The Columns are labeled from the letter "A" to "K", purposely ommiting the letter "i" (in other words, {A,B,C,D,E,F,G,H,J,K})
 * M represents a list of reserved seats
 * Quick example:
 * N = 2
 * M = {"1A","2F","1C"}
 * Solution = 3
 */
public class maxConsecutiveSeats {

    public static void main(String[] args) {

        int ans = solution(2, "1A 2F 1C");
        System.out.println(ans);
    }

    public static int solution(int N, String S) {
        String columnName = "ABCDEFGHJK";
        int[][] mat = new int[N+1][10]; // 0-based indexing
        for(int i = 1 ; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                mat[i][j] = -1;
            }
        }

        String[] reservedSeats = S.trim().split(" ");
        for(String seat : reservedSeats) {
            int seatRow = Integer.parseInt(seat.substring(0, seat.length()-1));
            int seatCol = columnName.indexOf(seat.charAt(seat.length() -1));
            mat[seatRow][seatCol] = 1;
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int consecutiveEmptySeats = 0;
            for(int j = 0; j < columnName.length(); j++) {
                if(mat[i][j] == 1) {
                    consecutiveEmptySeats = 0;
                    continue;
                }
                consecutiveEmptySeats++;

                if(consecutiveEmptySeats == 4) {
                    ans++;
                    consecutiveEmptySeats = 0;
                }
            }
        }
        return ans;
    }
}
